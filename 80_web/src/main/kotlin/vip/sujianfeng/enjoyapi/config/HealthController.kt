package vip.sujianfeng.enjoyapi.config

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author SuJianFeng
 * @date 2022/5/28
 * @Description
 */
@Api(tags = ["健康检查"])
@RestController
class HealthController {

    @ApiOperation("提供给阿里云健康检查")
    @GetMapping("/health")
    fun health(): String {
        //logger.info("health check.")
        return "health ok"
    }

    var logger: Logger = LoggerFactory.getLogger(this.javaClass)
}