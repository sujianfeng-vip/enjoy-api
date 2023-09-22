package vip.sujianfeng.admin.rbac.permission

import vip.sujianfeng.admin.base.controller.MasterController
import vip.sujianfeng.admin.vo.rbac.RbacPermissionVO
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vip.sujianfeng.admin.rbac.permission.params.PermissionPageParam
import vip.sujianfeng.enjoydao.handler.model.ManyIdParam
import vip.sujianfeng.enjoydao.interfaces.JdbcTbDao
import vip.sujianfeng.utils.define.CallResult

/**
 * @Author keyy
 * @Date 2022/5/20
 * @Description
 **/
@Api(tags = ["权限管理"])
@RestController
@RequestMapping("/permission-api")
class PermissionApiController: MasterController<RbacPermissionVO, PermissionPageParam>() {


    override fun afterAdd(op: CallResult<*>, jdbcDao: JdbcTbDao, item: RbacPermissionVO) {
        super.afterAdd(op, jdbcDao, item)
        myRbacHandler.clearCache()
    }


    override fun afterUpdate(op: CallResult<*>, jdbcDao: JdbcTbDao, item: RbacPermissionVO) {
        super.afterUpdate(op, jdbcDao, item)
        myRbacHandler.clearCache()
    }

    override fun afterDelete(
        op: CallResult<*>,
        jdbcDao: JdbcTbDao,
        manyIdParam: ManyIdParam,
        rows: MutableList<RbacPermissionVO>
    ) {
        super.afterDelete(op, jdbcDao, manyIdParam, rows)
        myRbacHandler.clearCache()
    }

    @Autowired
    lateinit var myRbacHandler: vip.sujianfeng.admin.config.MyRbacHandler
}