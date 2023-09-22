package vip.sujianfeng.admin.rbac.userRole

import vip.sujianfeng.utils.define.CallResult
import vip.sujianfeng.admin.base.controller.BaseController
import vip.sujianfeng.admin.vo.rbac.RbacRoleUserVO
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vip.sujianfeng.admin.config.MyRbacHandler
import vip.sujianfeng.admin.dbconn.MyJdbcDao
import vip.sujianfeng.admin.rbac.userRole.params.AllowUserRolePageParam
import vip.sujianfeng.enjoydao.sqlbuilder.TbPageRows
import vip.sujianfeng.admin.rbac.userRole.params.AllowUserRoleParam
import vip.sujianfeng.admin.rbac.userRole.respone.RbacUserRoleItem


/**
 * @Author keyy
 * @Date 2022/5/23
 * @Description
 **/
@Api(tags = ["用户角色分配"])
@RestController
@RequestMapping("/user-role-api")
class UserRoleApiController: BaseController() {

    @ApiOperation("查询单页")
    @PostMapping("/queryPage")
    fun queryPage(@RequestBody param: AllowUserRolePageParam): CallResult<TbPageRows<RbacUserRoleItem>> {
        return CallResult.opCall {
            it.data = myJdbcDao.selectPageRows(RbacUserRoleItem::class.java, " and a.system_id = '${param.systemId}' and a.state = 0", param.pageNo, param.pageSize)
            it.data.rows.forEach { row ->
                val tmp = myJdbcDao.selectOneByCondition(RbacRoleUserVO::class.java, " and a.user_id = '${param.userId}' and a.role_id = '${row.id}' ")
                row._checked = (tmp?.allow ?: 0) == 1
            }
        }
    }

    @ApiOperation("分配角色")
    @PostMapping("/allowUserRole")
    fun allowUserRole(@RequestBody param: AllowUserRoleParam): CallResult<String> {
        return CallResult.opCall {
            param.rows?.forEach {
                val findAny = param.selectedRows?.stream()?.filter { row -> row.id == it.id }?.findAny()
                val allow = if (findAny?.isPresent == true) 1 else 0
                var tmp = myJdbcDao.selectOneByCondition(RbacRoleUserVO::class.java, " and a.system_id = '${param.systemId}' and a.user_id = '${param.userId}' and a.role_id = '${it.id}' ")
                if (tmp == null) {
                    tmp = RbacRoleUserVO().apply {
                        this.systemId = param.systemId
                        this.userId = param.userId
                        this.roleId = it.id
                        this.allow = allow
                    }
                    jdbcTbDao().insert(tmp)
                    return@forEach
                }
                if (tmp.allow != allow) {
                    tmp.allow = allow
                    myJdbcDao.update(tmp, "allow")
                }
            }
            myRbacHandler.clearCache()
        }
    }

    @Autowired
    lateinit var myRbacHandler: MyRbacHandler
    @Autowired
    lateinit var myJdbcDao: MyJdbcDao
}