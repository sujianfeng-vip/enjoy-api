package vip.sujianfeng.admin.websocket.models

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * @author SuJianFeng
 * @date 2022/5/27
 * @Description
 */
@ApiModel(description = "消息对象")
class WebSocketMsg<T> {
    @ApiModelProperty("消息类型")
    var type: String = ""
    @ApiModelProperty("消息内容")
    var content: T? = null
}