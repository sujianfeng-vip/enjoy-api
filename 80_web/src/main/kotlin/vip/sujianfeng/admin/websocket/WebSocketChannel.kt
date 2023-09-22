package vip.sujianfeng.admin.websocket

import vip.sujianfeng.utils.comm.StringUtilsEx
import com.alibaba.fastjson.JSON
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.socket.*
import vip.sujianfeng.admin.websocket.models.WebSocketMsg
import java.util.concurrent.ConcurrentHashMap

/**
 * @Author SuJianFeng
 * @Date 2022/5/26
 * @Description
 **/
@Service
class WebSocketChannel: WebSocketHandler {

    companion object {
        var webSocketMap: ConcurrentHashMap<String, WebSocketSession> = ConcurrentHashMap()
        fun <T> sendMessage(channelId: String, message: WebSocketMsg<T>) {
            if (!webSocketMap.containsKey(channelId)){
                throw Exception("不存在通道: $channelId")
            }
            val channel = webSocketMap[channelId]
            val msg = JSON.toJSONString(message)
            logger.info("服务器发送消息到通道[{}] => {} ", channelId, msg)
            channel!!.sendMessage(TextMessage(msg))
        }
        var logger: Logger = LoggerFactory.getLogger(WebSocketChannel.javaClass)
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        val channelId = getChannelId(session)
        webSocketMap[channelId] = session
        logger.info("通道连接：${session.uri.toString()}")
        logger.info("通道[$channelId]连接成功!当前在线人数: ${webSocketMap.size}")
    }

    override fun handleMessage(session: WebSocketSession, message: WebSocketMessage<*>) {
        //val channelId = this.getChannelId(session)
        //logger.info("通道[${channelId}]服务端收到消息: ${message.payload}")
    }

    override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
        if (session.isOpen) {
            session.close()
        }
        logger.error("连接出错：$exception", exception)
        this.removeChannel(session)
    }

    override fun afterConnectionClosed(session: WebSocketSession, closeStatus: CloseStatus) {
        this.removeChannel(session)
    }

    override fun supportsPartialMessages(): Boolean {
        return false
    }

    fun getChannelId(session: WebSocketSession): String {
        return StringUtilsEx.rightStr(session.uri.toString(), "/")
    }

    fun removeChannel(session: WebSocketSession) {
        val channelId = this.getChannelId(session)
        if (StringUtilsEx.isEmpty(channelId)) {
            return
        }
        if(webSocketMap.containsKey(channelId)){
            webSocketMap.remove(channelId)
        }
        logger.info("通道[${channelId}]已关闭! 当前在线通道数: ${webSocketMap.size}")
    }

}

