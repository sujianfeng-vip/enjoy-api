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
@ApiModel("角色定义PO")
@TbTableUuid(table = "rbac_role")
open class RbacRolePO: vip.sujianfeng.enjoyapi.dbconn.MyModelBase() {
    @ApiModelProperty("名称")
    @TbFieldString(tableField = "name", label = "名称", length = 100)
    var name: String? = null
    @ApiModelProperty("系统ID")
    @TbFieldString(tableField = "system_id", label = "系统ID", length = 50)
    var systemId: String? = null

    companion object {
        const val TABLE_NAME = "rbac_role"
        const val BIZ_STATUS = "biz_status"
        const val CREATE_TIME = "create_time"
        const val CREATE_USER_ID = "create_user_id"
        const val ID = "id"
        const val NAME = "name"
        const val REMARK = "remark"
        const val STATE = "state"
        const val SYSTEM_ID = "system_id"
        const val UPDATE_TIME = "update_time"
        const val UPDATE_USER_ID = "update_user_id"
    }
}

/**
 * author GenerateModelBuilder
 * description Sql条件生成器
 **/
class RbacRoleCU: SqlConditionBuilder<RbacRoleCU>() {
    var BIZ_STATUS = SqlConditionField<RbacRoleCU>(this, "a.biz_status")
    var CREATE_TIME = SqlConditionField<RbacRoleCU>(this, "a.create_time")
    var CREATE_USER_ID = SqlConditionField<RbacRoleCU>(this, "a.create_user_id")
    var ID = SqlConditionField<RbacRoleCU>(this, "a.id")
    var NAME = SqlConditionField<RbacRoleCU>(this, "a.name")
    var REMARK = SqlConditionField<RbacRoleCU>(this, "a.remark")
    var STATE = SqlConditionField<RbacRoleCU>(this, "a.state")
    var SYSTEM_ID = SqlConditionField<RbacRoleCU>(this, "a.system_id")
    var UPDATE_TIME = SqlConditionField<RbacRoleCU>(this, "a.update_time")
    var UPDATE_USER_ID = SqlConditionField<RbacRoleCU>(this, "a.update_user_id")
}
