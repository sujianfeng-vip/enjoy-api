package vip.sujianfeng.admin.base

import com.alibaba.fastjson.JSON
import org.junit.Assert
import org.junit.Before
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import vip.sujianfeng.utils.define.CallResult

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [TestMainApp::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
open class TestBase {

    @Before
    fun init() {

    }

    fun <T> assertOp(op: CallResult<T>): CallResult<T> {
        logger.info("{}", JSON.toJSONString(op))
        Assert.assertEquals(op.message, true, op.isSuccess)
        return op
    }

    private val logger = LoggerFactory.getLogger(this.javaClass)

}