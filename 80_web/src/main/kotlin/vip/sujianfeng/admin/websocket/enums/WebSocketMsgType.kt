package vip.sujianfeng.admin.websocket.enums

/**
 * @author SuJianFeng
 * @date 2022/5/28
 * @Description
 */
enum class WebSocketMsgType(var type: String, var typeName: String) {
    Heartbeat("Heartbeat", "心跳"),
    LoginSuccess("LoginSuccess", "登录成功")
}