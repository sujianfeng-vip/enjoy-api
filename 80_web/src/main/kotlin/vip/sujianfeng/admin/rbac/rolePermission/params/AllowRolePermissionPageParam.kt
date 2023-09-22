package vip.sujianfeng.admin.rbac.rolePermission.params

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import vip.sujianfeng.enjoydao.handler.model.PageParam
import vip.sujianfeng.enjoydao.interfaces.TbDao
import vip.sujianfeng.enjoydao.sqlcondition.ISqlConditionBuilder
import vip.sujianfeng.admin.po.rbac.RbacRolePermissionCU
import vip.sujianfeng.utils.comm.StringUtilsEx

/**
 * @Author keyy
 * @Date 2022/5/20
 * @Description
 **/
@ApiModel(description = "分配")
class AllowRolePermissionPageParam: PageParam() {
    var systemId = ""

    @ApiModelProperty("权限id")
    var roleId: String? = null

    override fun createBuilder(tbDao: TbDao?): ISqlConditionBuilder {
        return RbacRolePermissionCU().apply {
            this.and().SYSTEM_ID.eq(systemId)
            this.and(StringUtilsEx.isNotEmpty(roleId)) {
                this.ROLE_ID.eq(roleId)
            }
        }
    }
}