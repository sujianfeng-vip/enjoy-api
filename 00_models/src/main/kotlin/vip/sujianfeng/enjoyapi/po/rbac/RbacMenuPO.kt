package vip.sujianfeng.enjoyapi.po.rbac

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import vip.sujianfeng.enjoydao.annotations.*
import vip.sujianfeng.enjoydao.sqlcondition.*
import vip.sujianfeng.enjoydao.enums.*

/**
 * author GenerateModelBuilder
 * description 读取数据库生成的实体模型代码，不要手动修改，重新生成后会覆盖
 **/
@ApiModel("菜单定义PO")
@TbTableUuid(table = "rbac_menu")
open class RbacMenuPO: vip.sujianfeng.enjoyapi.dbconn.MyModelBase() {
    @ApiModelProperty("名称")
    @TbFieldString(tableField = "name", label = "名称", length = 100)
    var name: String? = null
    @ApiModelProperty("上级菜单")
    @TbFieldString(tableField = "parent_id", label = "上级菜单", length = 50)
    var parentId: String? = null
    @ApiModelProperty("绑定权限")
    @TbFieldString(tableField = "permission_id", label = "绑定权限", length = 50)
    var permissionId: String? = null
    @ApiModelProperty("排序号")
    @TbFieldInt(tableField = "sort_no", label = "排序号")
    var sortNo: Int? = null
    @ApiModelProperty("系统ID")
    @TbFieldString(tableField = "system_id", label = "系统ID", length = 50)
    var systemId: String? = null
    @ApiModelProperty("URL")
    @TbFieldString(tableField = "url", label = "URL", length = 500)
    var url: String? = null
    @ApiModelProperty("窗口显示类型：0-子页面，1-新页面，2-对话框")
    @TbFieldInt(tableField = "window_type", label = "窗口显示类型：0-子页面，1-新页面，2-对话框")
    var windowType: Int? = null

    companion object {
        const val TABLE_NAME = "rbac_menu"
        const val BIZ_STATUS = "biz_status"
        const val CREATE_TIME = "create_time"
        const val CREATE_USER_ID = "create_user_id"
        const val ID = "id"
        const val NAME = "name"
        const val PARENT_ID = "parent_id"
        const val PERMISSION_ID = "permission_id"
        const val REMARK = "remark"
        const val SORT_NO = "sort_no"
        const val STATE = "state"
        const val SYSTEM_ID = "system_id"
        const val UPDATE_TIME = "update_time"
        const val UPDATE_USER_ID = "update_user_id"
        const val URL = "url"
        const val WINDOW_TYPE = "window_type"
    }
}

/**
 * author GenerateModelBuilder
 * description Sql条件生成器
 **/
class RbacMenuCU: SqlConditionBuilder<RbacMenuCU>() {
    var BIZ_STATUS = SqlConditionField<RbacMenuCU>(this, "a.biz_status")
    var CREATE_TIME = SqlConditionField<RbacMenuCU>(this, "a.create_time")
    var CREATE_USER_ID = SqlConditionField<RbacMenuCU>(this, "a.create_user_id")
    var ID = SqlConditionField<RbacMenuCU>(this, "a.id")
    var NAME = SqlConditionField<RbacMenuCU>(this, "a.name")
    var PARENT_ID = SqlConditionField<RbacMenuCU>(this, "a.parent_id")
    var PERMISSION_ID = SqlConditionField<RbacMenuCU>(this, "a.permission_id")
    var REMARK = SqlConditionField<RbacMenuCU>(this, "a.remark")
    var SORT_NO = SqlConditionField<RbacMenuCU>(this, "a.sort_no")
    var STATE = SqlConditionField<RbacMenuCU>(this, "a.state")
    var SYSTEM_ID = SqlConditionField<RbacMenuCU>(this, "a.system_id")
    var UPDATE_TIME = SqlConditionField<RbacMenuCU>(this, "a.update_time")
    var UPDATE_USER_ID = SqlConditionField<RbacMenuCU>(this, "a.update_user_id")
    var URL = SqlConditionField<RbacMenuCU>(this, "a.url")
    var WINDOW_TYPE = SqlConditionField<RbacMenuCU>(this, "a.window_type")
}
