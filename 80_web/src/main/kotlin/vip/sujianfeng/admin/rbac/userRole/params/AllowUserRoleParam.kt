package vip.sujianfeng.admin.rbac.userRole.params

import io.swagger.annotations.ApiModel
import vip.sujianfeng.admin.rbac.userRole.respone.RbacUserRoleItem

@ApiModel(description = "用户分配角色参数")
class AllowUserRoleParam {
    var systemId = ""
    var userId: String ?= null
    var rows: ArrayList<RbacUserRoleItem> ?= null
    var selectedRows: ArrayList<RbacUserRoleItem> ?= null
}