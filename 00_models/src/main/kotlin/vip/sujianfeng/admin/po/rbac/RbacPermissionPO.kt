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
@ApiModel("权限定义PO")
@TbTableUuid(table = "rbac_permission")
open class RbacPermissionPO: vip.sujianfeng.admin.dbconn.MyModelBase() {
    @ApiModelProperty("名称")
    @TbFieldString(tableField = "name", label = "名称", length = 100)
    var name: String? = null
    @ApiModelProperty("上级ID")
    @TbFieldString(tableField = "parent_id", label = "上级ID", length = 100)
    var parentId: String? = null
    @ApiModelProperty("排序号")
    @TbFieldInt(tableField = "sort_no", label = "排序号")
    var sortNo: Int? = null
    @ApiModelProperty("系统ID")
    @TbFieldString(tableField = "system_id", label = "系统ID", length = 50)
    var systemId: String? = null
    @ApiModelProperty("权限类型")
    @TbFieldInt(tableField = "type", label = "权限类型")
    var type: Int? = null

    companion object {
        const val TABLE_NAME = "rbac_permission"
        const val BIZ_STATUS = "biz_status"
        const val CREATE_TIME = "create_time"
        const val CREATE_USER_ID = "create_user_id"
        const val ID = "id"
        const val NAME = "name"
        const val PARENT_ID = "parent_id"
        const val REMARK = "remark"
        const val SORT_NO = "sort_no"
        const val STATE = "state"
        const val SYSTEM_ID = "system_id"
        const val TYPE = "type"
        const val UPDATE_TIME = "update_time"
        const val UPDATE_USER_ID = "update_user_id"
    }
}

/**
 * @Author GenerateModelBuilder
 * @Description Sql条件生成器
 **/
class RbacPermissionCU: SqlConditionBuilder<RbacPermissionCU>() {
    var BIZ_STATUS = SqlConditionField<RbacPermissionCU>(this, "a.biz_status")
    var CREATE_TIME = SqlConditionField<RbacPermissionCU>(this, "a.create_time")
    var CREATE_USER_ID = SqlConditionField<RbacPermissionCU>(this, "a.create_user_id")
    var ID = SqlConditionField<RbacPermissionCU>(this, "a.id")
    var NAME = SqlConditionField<RbacPermissionCU>(this, "a.name")
    var PARENT_ID = SqlConditionField<RbacPermissionCU>(this, "a.parent_id")
    var REMARK = SqlConditionField<RbacPermissionCU>(this, "a.remark")
    var SORT_NO = SqlConditionField<RbacPermissionCU>(this, "a.sort_no")
    var STATE = SqlConditionField<RbacPermissionCU>(this, "a.state")
    var SYSTEM_ID = SqlConditionField<RbacPermissionCU>(this, "a.system_id")
    var TYPE = SqlConditionField<RbacPermissionCU>(this, "a.type")
    var UPDATE_TIME = SqlConditionField<RbacPermissionCU>(this, "a.update_time")
    var UPDATE_USER_ID = SqlConditionField<RbacPermissionCU>(this, "a.update_user_id")
}
