package vip.sujianfeng.admin.po.ws

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import vip.sujianfeng.enjoydao.annotations.*
import vip.sujianfeng.enjoydao.sqlcondition.*
import vip.sujianfeng.enjoydao.enums.*

/**
 * @Author GenerateModelBuilder
 * @Description 读取数据库生成的实体模型代码，不要手动修改，重新生成后会覆盖
 **/
@ApiModel("微信登录会话PO")
@TbTableUuid(table = "ws_login_session")
open class WsLoginSessionPO: vip.sujianfeng.admin.dbconn.MyModelBase() {
    @ApiModelProperty("ws通讯通道id")
    @TbFieldString(tableField = "channel_id", label = "ws通讯通道id", length = 50)
    var channelId: String? = null
    @ApiModelProperty("浜岀淮鐮佹暟鎹?")
    @TbField(fieldType = TbDefineFieldType.ftText, tableField = "qr_code", label = "浜岀淮鐮佹暟鎹?")
    var qrCode: String? = null
    @ApiModelProperty("手机号")
    @TbFieldString(tableField = "telephone", label = "手机号", length = 50)
    var telephone: String? = null

    companion object {
        const val TABLE_NAME = "ws_login_session"
        const val BIZ_STATUS = "biz_status"
        const val CHANNEL_ID = "channel_id"
        const val CREATE_TIME = "create_time"
        const val CREATE_USER_ID = "create_user_id"
        const val ID = "id"
        const val QR_CODE = "qr_code"
        const val REMARK = "remark"
        const val STATE = "state"
        const val TELEPHONE = "telephone"
        const val UPDATE_TIME = "update_time"
        const val UPDATE_USER_ID = "update_user_id"
    }
}

/**
 * @Author GenerateModelBuilder
 * @Description Sql条件生成器
 **/
class WsLoginSessionCU: SqlConditionBuilder<WsLoginSessionCU>() {
    var BIZ_STATUS = SqlConditionField<WsLoginSessionCU>(this, "a.biz_status")
    var CHANNEL_ID = SqlConditionField<WsLoginSessionCU>(this, "a.channel_id")
    var CREATE_TIME = SqlConditionField<WsLoginSessionCU>(this, "a.create_time")
    var CREATE_USER_ID = SqlConditionField<WsLoginSessionCU>(this, "a.create_user_id")
    var ID = SqlConditionField<WsLoginSessionCU>(this, "a.id")
    var QR_CODE = SqlConditionField<WsLoginSessionCU>(this, "a.qr_code")
    var REMARK = SqlConditionField<WsLoginSessionCU>(this, "a.remark")
    var STATE = SqlConditionField<WsLoginSessionCU>(this, "a.state")
    var TELEPHONE = SqlConditionField<WsLoginSessionCU>(this, "a.telephone")
    var UPDATE_TIME = SqlConditionField<WsLoginSessionCU>(this, "a.update_time")
    var UPDATE_USER_ID = SqlConditionField<WsLoginSessionCU>(this, "a.update_user_id")
}
