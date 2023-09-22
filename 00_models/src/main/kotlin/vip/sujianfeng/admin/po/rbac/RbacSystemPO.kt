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
@ApiModel("系统定义PO")
@TbTableUuid(table = "rbac_system")
open class RbacSystemPO: vip.sujianfeng.admin.dbconn.MyModelBase() {
    @ApiModelProperty("名称")
    @TbFieldString(tableField = "name", label = "名称", length = 100)
    var name: String? = null
    @ApiModelProperty("排序号")
    @TbFieldInt(tableField = "sort_no", label = "排序号")
    var sortNo: Int? = null

    companion object {
        const val TABLE_NAME = "rbac_system"
        const val BIZ_STATUS = "biz_status"
        const val CREATE_TIME = "create_time"
        const val CREATE_USER_ID = "create_user_id"
        const val ID = "id"
        const val NAME = "name"
        const val REMARK = "remark"
        const val SORT_NO = "sort_no"
        const val STATE = "state"
        const val UPDATE_TIME = "update_time"
        const val UPDATE_USER_ID = "update_user_id"
    }
}

/**
 * @Author GenerateModelBuilder
 * @Description Sql条件生成器
 **/
class RbacSystemCU: SqlConditionBuilder<RbacSystemCU>() {
    var BIZ_STATUS = SqlConditionField<RbacSystemCU>(this, "a.biz_status")
    var CREATE_TIME = SqlConditionField<RbacSystemCU>(this, "a.create_time")
    var CREATE_USER_ID = SqlConditionField<RbacSystemCU>(this, "a.create_user_id")
    var ID = SqlConditionField<RbacSystemCU>(this, "a.id")
    var NAME = SqlConditionField<RbacSystemCU>(this, "a.name")
    var REMARK = SqlConditionField<RbacSystemCU>(this, "a.remark")
    var SORT_NO = SqlConditionField<RbacSystemCU>(this, "a.sort_no")
    var STATE = SqlConditionField<RbacSystemCU>(this, "a.state")
    var UPDATE_TIME = SqlConditionField<RbacSystemCU>(this, "a.update_time")
    var UPDATE_USER_ID = SqlConditionField<RbacSystemCU>(this, "a.update_user_id")
}
