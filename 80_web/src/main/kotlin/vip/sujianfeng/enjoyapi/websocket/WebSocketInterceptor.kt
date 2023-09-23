package vip.sujianfeng.enjoyapi.websocket

import org.slf4j.LoggerFactory
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.server.HandshakeInterceptor

/**
 * @author SuJianFeng
 * @date 2022/5/28
 * @Description
 */
class WebSocketInterceptor: HandshakeInterceptor {

    override fun beforeHandshake(
        request: ServerHttpRequest,
        response: ServerHttpResponse,
        wsHandler: WebSocketHandler,
        attributes: MutableMap<String, Any>
    ): Boolean {
        logger.info("进入拦截器：${request.uri}")
        return true
    }

    override fun afterHandshake(
        request: ServerHttpRequest,
        response: ServerHttpResponse,
        wsHandler: WebSocketHandler,
        exception: Exception?
    ) {
        logger.info("进入webSocket的afterHandshake拦截器！")
    }
    var logger = LoggerFactory.getLogger(this.javaClass)

}