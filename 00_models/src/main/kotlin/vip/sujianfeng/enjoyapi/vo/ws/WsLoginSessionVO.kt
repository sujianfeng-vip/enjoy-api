package vip.sujianfeng.enjoyapi.vo.ws

import vip.sujianfeng.enjoyapi.dbconn.MyModelBase
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import vip.sujianfeng.enjoydao.annotations.TbField
import vip.sujianfeng.enjoydao.annotations.TbFieldString
import vip.sujianfeng.enjoydao.annotations.TbTableUuid
import vip.sujianfeng.enjoydao.enums.TbDefineFieldType

/**
 * @Author SuJianFeng
 * @Date 2022/5/27
 * @Description
 **/
@ApiModel(description = "登录会话")
@TbTableUuid(table = "ws_login_session")
class WsLoginSessionVO: MyModelBase() {
    @ApiModelProperty("ws通讯通道id")
    @TbFieldString(tableField = "channel_id", label = "ws通讯通道id")
    var channelId: String ?= null

    @ApiModelProperty("微信小程序二维码")
    @TbField(tableField = "qr_code", label = "微信小程序二维码", fieldType = TbDefineFieldType.ftLongtext)
    var qrCode: String ?= null

    @ApiModelProperty("手机号")
    @TbFieldString(tableField = "telephone", label = "手机号")
    var telephone: String ?= null
}