package vip.sujianfeng.enjoyapi.rbac.menu

import vip.sujianfeng.enjoyapi.base.controller.MasterController
import vip.sujianfeng.enjoyapi.vo.rbac.RbacMenuVO
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vip.sujianfeng.enjoyapi.po.rbac.RbacMenuCU
import vip.sujianfeng.enjoyapi.rbac.menu.params.MenuPageParam
import vip.sujianfeng.enjoyapi.rbac.menu.params.MenuTreeParam
import vip.sujianfeng.enjoydao.handler.model.ManyIdParam
import vip.sujianfeng.enjoydao.interfaces.JdbcTbDao
import vip.sujianfeng.enjoydao.tree.models.TreeData
import vip.sujianfeng.enjoydao.tree.models.TreeNode
import vip.sujianfeng.utils.define.CallResult

/**
 * @Author keyy
 * @Date 2022/5/20
 * @Description
 **/
@Api(tags = ["菜单管理"])
@RestController
@RequestMapping("/menu-api")
class MenuApiController: MasterController<RbacMenuVO, MenuPageParam>() {

    override fun afterAdd(op: CallResult<*>, jdbcDao: JdbcTbDao, item: RbacMenuVO) {
        super.afterAdd(op, jdbcDao, item)
        myRbacHandler.clearCache()
    }

    override fun afterUpdate(op: CallResult<*>, jdbcDao: JdbcTbDao, item: RbacMenuVO) {
        super.afterUpdate(op, jdbcDao, item)
        myRbacHandler.clearCache()
    }

    @PostMapping("/getMenuTree")
    fun getMenuTree(@RequestBody param: MenuTreeParam): CallResult<List<TreeNode<TreeData>>> {
        return CallResult.opCall {
            it.data = MenuTreeHandler(jdbcTbDao().selectList(RbacMenuVO::class.java, RbacMenuCU().apply {
                this.and().STATE.eq(0).and().SYSTEM_ID.eq(param.systemId)
            })).buildTree()
        }
    }

    override fun afterDelete(
        op: CallResult<*>,
        jdbcDao: JdbcTbDao,
        manyIdParam: ManyIdParam,
        rows: MutableList<RbacMenuVO>
    ) {
        super.afterDelete(op, jdbcDao, manyIdParam, rows)
        myRbacHandler.clearCache()
    }

    @Autowired
    lateinit var myRbacHandler: vip.sujianfeng.enjoyapi.config.MyRbacHandler
}