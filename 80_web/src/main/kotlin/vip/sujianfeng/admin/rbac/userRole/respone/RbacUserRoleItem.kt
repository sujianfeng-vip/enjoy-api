package vip.sujianfeng.admin.rbac.userRole.respone

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import vip.sujianfeng.enjoydao.annotations.TbFieldString
import vip.sujianfeng.enjoydao.annotations.TbTableUuid
import vip.sujianfeng.enjoydao.model.AbstractBizModel

@ApiModel(description = "用户分配角色列表")
@TbTableUuid(table = "rbac_role")
class RbacUserRoleItem: AbstractBizModel() {
    @TbFieldString(tableField = "system_id", label = "系统ID")
    var systemId: String? = null

    @TbFieldString(tableField = "name", label = "角色名称")
    var name: String? = null

    @ApiModelProperty("是否分配")
    var _checked = true
}