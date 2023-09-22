package vip.sujianfeng.admin.po.rbac

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import vip.sujianfeng.enjoydao.annotations.*
import vip.sujianfeng.enjoydao.sqlcondition.*
import vip.sujianfeng.enjoydao.enums.*

/**
 * @Author GenerateModelBuilder
 * @Description 读取数据库生成的实体模型代码，不要手动修改，重新生成后会覆盖
 **/
@ApiModel("角色权限PO")
@TbTableUuid(table = "rbac_role_permission")
open class RbacRolePermissionPO: vip.sujianfeng.admin.dbconn.MyModelBase() {
    @ApiModelProperty("是否分配：0-否，1-是")
    @TbFieldInt(tableField = "allow", label = "是否分配：0-否，1-是")
    var allow: Int? = null
    @ApiModelProperty("权限id")
    @TbFieldString(tableField = "permission_id", label = "权限id", length = 50)
    var permissionId: String? = null
    @ApiModelProperty("角色id")
    @TbFieldString(tableField = "role_id", label = "角色id", length = 50)
    var roleId: String? = null
    @ApiModelProperty("系统ID")
    @TbFieldString(tableField = "system_id", label = "系统ID", length = 50)
    var systemId: String? = null

    companion object {
        const val TABLE_NAME = "rbac_role_permission"
        const val ALLOW = "allow"
        const val BIZ_STATUS = "biz_status"
        const val CREATE_TIME = "create_time"
        const val CREATE_USER_ID = "create_user_id"
        const val ID = "id"
        const val PERMISSION_ID = "permission_id"
        const val REMARK = "remark"
        const val ROLE_ID = "role_id"
        const val STATE = "state"
        const val SYSTEM_ID = "system_id"
        const val UPDATE_TIME = "update_time"
        const val UPDATE_USER_ID = "update_user_id"
    }
}

/**
 * @Author GenerateModelBuilder
 * @Description Sql条件生成器
 **/
class RbacRolePermissionCU: SqlConditionBuilder<RbacRolePermissionCU>() {
    var ALLOW = SqlConditionField<RbacRolePermissionCU>(this, "a.allow")
    var BIZ_STATUS = SqlConditionField<RbacRolePermissionCU>(this, "a.biz_status")
    var CREATE_TIME = SqlConditionField<RbacRolePermissionCU>(this, "a.create_time")
    var CREATE_USER_ID = SqlConditionField<RbacRolePermissionCU>(this, "a.create_user_id")
    var ID = SqlConditionField<RbacRolePermissionCU>(this, "a.id")
    var PERMISSION_ID = SqlConditionField<RbacRolePermissionCU>(this, "a.permission_id")
    var REMARK = SqlConditionField<RbacRolePermissionCU>(this, "a.remark")
    var ROLE_ID = SqlConditionField<RbacRolePermissionCU>(this, "a.role_id")
    var STATE = SqlConditionField<RbacRolePermissionCU>(this, "a.state")
    var SYSTEM_ID = SqlConditionField<RbacRolePermissionCU>(this, "a.system_id")
    var UPDATE_TIME = SqlConditionField<RbacRolePermissionCU>(this, "a.update_time")
    var UPDATE_USER_ID = SqlConditionField<RbacRolePermissionCU>(this, "a.update_user_id")
}
