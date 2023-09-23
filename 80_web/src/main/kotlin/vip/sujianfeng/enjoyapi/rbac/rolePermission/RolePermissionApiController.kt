package vip.sujianfeng.enjoyapi.rbac.rolePermission

import vip.sujianfeng.utils.define.CallResult
import vip.sujianfeng.enjoyapi.base.controller.BaseController
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vip.sujianfeng.enjoyapi.config.MyRbacHandler
import vip.sujianfeng.enjoyapi.dbconn.MyJdbcDao
import vip.sujianfeng.enjoyapi.po.rbac.RbacMenuCU
import vip.sujianfeng.enjoyapi.po.rbac.RbacPermissionCU
import vip.sujianfeng.enjoyapi.po.rbac.RbacRolePermissionCU
import vip.sujianfeng.enjoyapi.po.rbac.RbacRolePermissionPO
import vip.sujianfeng.enjoyapi.rbac.menu.MenuTreeBuilder
import vip.sujianfeng.enjoyapi.rbac.rolePermission.params.AllowRolePermissionPageParam
import vip.sujianfeng.enjoyapi.rbac.rolePermission.params.AllowRolePermissionParam
import vip.sujianfeng.enjoyapi.vo.rbac.RbacMenuVO
import vip.sujianfeng.enjoyapi.vo.rbac.RbacPermissionVO
import vip.sujianfeng.enjoydao.tree.models.TreeData
import vip.sujianfeng.enjoydao.tree.models.TreeNode
import vip.sujianfeng.utils.comm.StringUtilsEx

/**
 * @Author keyy
 * @Date 2022/5/23
 * @Description
 **/
@Api(tags = ["角色分配权限"])
@RestController
@RequestMapping("/role-permission-api")
class RolePermissionApiController: BaseController() {

    @ApiOperation("查询菜单权限树数据")
    @PostMapping("/queryTree")
    fun queryTree(@RequestBody param: AllowRolePermissionPageParam): CallResult<ArrayList<TreeNode<TreeData>>> {
        return CallResult.opCall { op ->
            //查询菜单
            val menuNodes = myJdbcDao.selectList(RbacMenuVO::class.java, RbacMenuCU().apply {
                this.and().STATE.eq(0)
                this.and().SYSTEM_ID.eq(param.systemId)
                this.and().BIZ_STATUS.eq(0) //启用 == 0
                this.pageSize = 1000
            })
            //查询权限
            val permissionRows = myJdbcDao.selectList(RbacPermissionVO::class.java, RbacPermissionCU().apply {
                this.and().STATE.eq(0).and().SYSTEM_ID.eq(param.systemId)
                this.pageSize = 1000
            })
            op.data = ArrayList<TreeNode<TreeData>>().apply {
                this.add(TreeNode<TreeData>().apply {
                    this.value = "menuList"
                    this.title = "分配菜单"
                    this.children = MenuTreeBuilder(menuNodes).buildTreeNodes()
                })
                this.add(TreeNode<TreeData>().apply {
                    this.value = "permissionList"
                    this.title = "分配权限"
                    this.children = ArrayList<TreeNode<TreeData>>().apply {
                        permissionRows.forEach {
                            this.add(TreeNode<TreeData>().apply {
                                this.value = it.id
                                this.title = it.name
                            })
                        }
                    }
                })
            }
            //查询分配
            val allowItems = myJdbcDao.selectList(RbacRolePermissionPO::class.java, RbacRolePermissionCU().apply {
                this.and().SYSTEM_ID.eq(param.systemId).and().ROLE_ID.eq(param.roleId)
                this.pageSize = 10000
            })
            setTreeNodeCheckedValue(allowItems, op.data)
        }
    }

    @ApiOperation("分配权限")
    @PostMapping("/allowRolePermissionByTree")
    fun allowRolePermissionByTree(@RequestBody param: AllowRolePermissionParam): CallResult<String> {
        return proc(myJdbcDao) {
            val allowItems = myJdbcDao.selectList(RbacRolePermissionPO::class.java, RbacRolePermissionCU().apply {
                this.and().SYSTEM_ID.eq(param.systemId).and().ROLE_ID.eq(param.roleId)
                this.pageSize = 10000
            })
            allowRolePermission(allowItems, param.systemId, param.roleId!!, param.treeNodes)
            myRbacHandler.clearCache()
        }
    }

    private fun allowRolePermission(allowItems: List<RbacRolePermissionPO>, systemId: String, roleId: String, treeNodes: List<TreeNode<TreeData>>?) {
        treeNodes?.forEach { treeNode ->
            val item = allowItems.stream().filter { it.permissionId == treeNode.value }.findAny().orElse(RbacRolePermissionPO()).apply {
                this.systemId = systemId
                this.roleId = roleId
                this.permissionId = treeNode.value
            }
            try {
                //如果新数据，并且未勾选，那么就无需保存
                if (StringUtilsEx.isEmpty(item.id) && !treeNode.isChecked ) {
                    return@forEach
                }
                //如是旧数据，值没有变化，那么无需保存
                if (StringUtilsEx.isNotEmpty(item.id) && (item.allow == if (treeNode.isChecked) 1 else 0)) {
                    return@forEach
                }
                item.allow = if (treeNode.isChecked) 1 else 0
                myJdbcDao.save(item)
            }finally {
                allowRolePermission(allowItems, systemId, roleId, treeNode.children)
            }
        }
    }

    private fun setTreeNodeCheckedValue(allowItems: List<RbacRolePermissionPO>, treeNodes: List<TreeNode<TreeData>>?) {
        treeNodes?.forEach { treeNode ->
            try {
                val item = allowItems.stream().filter { it.permissionId == treeNode.value }.findAny()
                treeNode.isChecked = item.isPresent && item.get().allow == 1
            }finally {
                setTreeNodeCheckedValue(allowItems, treeNode.children)
            }
        }
    }


    @Autowired
    lateinit var myRbacHandler: MyRbacHandler
    @Autowired
    lateinit var myJdbcDao: MyJdbcDao
}