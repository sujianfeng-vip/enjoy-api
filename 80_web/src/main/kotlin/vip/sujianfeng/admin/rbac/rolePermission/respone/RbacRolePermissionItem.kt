package vip.sujianfeng.admin.rbac.rolePermission.respone

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import vip.sujianfeng.enjoydao.annotations.TbFieldString
import vip.sujianfeng.enjoydao.annotations.TbTableUuid
import vip.sujianfeng.enjoydao.model.AbstractBizModel

@ApiModel(description = "角色分配权限列表")
@TbTableUuid(table = "rbac_permission")
class RbacRolePermissionItem: AbstractBizModel() {
    @TbFieldString(tableField = "system_id", label = "系统ID")
    var systemId: String? = null

    @TbFieldString(tableField = "name", label = "权限名称")
    var name: String? = null

    @ApiModelProperty("是否分配")
    var _checked = true
}