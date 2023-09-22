package vip.sujianfeng.admin.base

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication


@SpringBootApplication(scanBasePackages = ["vip.sujianfeng"], exclude = [DataSourceAutoConfiguration::class])
class TestMainApp
fun main(args: Array<String>) {
    runApplication<TestMainApp>(*args)
}