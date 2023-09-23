package vip.sujianfeng.enjoyapi.rbac.role

import vip.sujianfeng.enjoyapi.base.controller.MasterController
import vip.sujianfeng.enjoyapi.vo.rbac.RbacRoleVO
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vip.sujianfeng.enjoyapi.rbac.role.params.RolePageParam
import vip.sujianfeng.enjoydao.handler.model.ManyIdParam
import vip.sujianfeng.enjoydao.interfaces.JdbcTbDao
import vip.sujianfeng.utils.define.CallResult

/**
 * @Author keyy
 * @Date 2022/5/20
 * @Description
 **/
@Api(tags = ["角色管理"])
@RestController
@RequestMapping("/role-api")
class RoleApiController: MasterController<RbacRoleVO, RolePageParam>() {


    override fun afterAdd(op: CallResult<*>, jdbcDao: JdbcTbDao, item: RbacRoleVO) {
        super.afterAdd(op, jdbcDao, item)
        myRbacHandler.clearCache()
    }

    override fun afterUpdate(op: CallResult<*>, jdbcDao: JdbcTbDao, item: RbacRoleVO) {
        super.afterUpdate(op, jdbcDao, item)
        myRbacHandler.clearCache()
    }

    override fun afterDelete(
        op: CallResult<*>,
        jdbcDao: JdbcTbDao,
        manyIdParam: ManyIdParam,
        rows: MutableList<RbacRoleVO>
    ) {
        super.afterDelete(op, jdbcDao, manyIdParam, rows)
        myRbacHandler.clearCache()
    }

    @Autowired
    lateinit var myRbacHandler: vip.sujianfeng.enjoyapi.config.MyRbacHandler
}