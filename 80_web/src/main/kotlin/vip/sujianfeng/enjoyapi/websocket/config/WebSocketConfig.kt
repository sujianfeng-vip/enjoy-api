package vip.sujianfeng.enjoyapi.websocket.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.TaskScheduler
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry
import vip.sujianfeng.enjoyapi.websocket.WebSocketChannel
import vip.sujianfeng.enjoyapi.websocket.WebSocketInterceptor

/**
 * @author SuJianFeng
 * @date 2022/5/28
 * @Description
 */
@Configuration
@EnableWebSocket
class WebSocketConfig: WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        //handler是webSocket的核心，配置入口
        registry.addHandler(WebSocketChannel(), "/websocket/{channelId}")
            .setAllowedOrigins("*")
            .addInterceptors(WebSocketInterceptor())
    }

    @Bean
    fun taskScheduler(): TaskScheduler {
        val scheduling = ThreadPoolTaskScheduler()
        scheduling.poolSize = 20
        scheduling.initialize()
        return scheduling
    }
}