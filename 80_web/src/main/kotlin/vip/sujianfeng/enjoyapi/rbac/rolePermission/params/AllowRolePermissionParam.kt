package vip.sujianfeng.enjoyapi.rbac.rolePermission.params

import io.swagger.annotations.ApiModel
import vip.sujianfeng.enjoydao.tree.models.TreeData
import vip.sujianfeng.enjoydao.tree.models.TreeNode

@ApiModel(description = "角色分配权限参数")
class AllowRolePermissionParam {
    var systemId = ""
    var roleId: String ?= null
    var treeNodes: List<TreeNode<TreeData>> ?= null
}