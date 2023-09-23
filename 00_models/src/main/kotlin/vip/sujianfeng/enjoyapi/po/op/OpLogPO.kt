package vip.sujianfeng.enjoyapi.po.op

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import vip.sujianfeng.enjoydao.annotations.*
import vip.sujianfeng.enjoydao.sqlcondition.*
import vip.sujianfeng.enjoydao.enums.*

/**
 * author GenerateModelBuilder
 * description 读取数据库生成的实体模型代码，不要手动修改，重新生成后会覆盖
 **/
@ApiModel("操作日志PO")
@TbTableUuid(table = "op_log")
open class OpLogPO: vip.sujianfeng.enjoyapi.dbconn.MyModelBase() {
    @ApiModelProperty("业务单据数据")
    @TbField(fieldType = TbDefineFieldType.ftText, tableField = "biz_data", label = "业务单据数据")
    var bizData: String? = null
    @ApiModelProperty("业务单据id")
    @TbFieldString(tableField = "biz_id", label = "业务单据id", length = 50)
    var bizId: String? = null
    @ApiModelProperty("操作内容")
    @TbFieldString(tableField = "content", label = "操作内容", length = 100)
    var content: String? = null
    @ApiModelProperty("操作用户id")
    @TbFieldString(tableField = "user_id", label = "操作用户id", length = 50)
    var userId: String? = null

    companion object {
        const val TABLE_NAME = "op_log"
        const val BIZ_DATA = "biz_data"
        const val BIZ_ID = "biz_id"
        const val BIZ_STATUS = "biz_status"
        const val CONTENT = "content"
        const val CREATE_TIME = "create_time"
        const val CREATE_USER_ID = "create_user_id"
        const val ID = "id"
        const val REMARK = "remark"
        const val STATE = "state"
        const val UPDATE_TIME = "update_time"
        const val UPDATE_USER_ID = "update_user_id"
        const val USER_ID = "user_id"
    }
}

/**
 * author GenerateModelBuilder
 * description Sql条件生成器
 **/
class OpLogCU: SqlConditionBuilder<OpLogCU>() {
    var BIZ_DATA = SqlConditionField<OpLogCU>(this, "a.biz_data")
    var BIZ_ID = SqlConditionField<OpLogCU>(this, "a.biz_id")
    var BIZ_STATUS = SqlConditionField<OpLogCU>(this, "a.biz_status")
    var CONTENT = SqlConditionField<OpLogCU>(this, "a.content")
    var CREATE_TIME = SqlConditionField<OpLogCU>(this, "a.create_time")
    var CREATE_USER_ID = SqlConditionField<OpLogCU>(this, "a.create_user_id")
    var ID = SqlConditionField<OpLogCU>(this, "a.id")
    var REMARK = SqlConditionField<OpLogCU>(this, "a.remark")
    var STATE = SqlConditionField<OpLogCU>(this, "a.state")
    var UPDATE_TIME = SqlConditionField<OpLogCU>(this, "a.update_time")
    var UPDATE_USER_ID = SqlConditionField<OpLogCU>(this, "a.update_user_id")
    var USER_ID = SqlConditionField<OpLogCU>(this, "a.user_id")
}
