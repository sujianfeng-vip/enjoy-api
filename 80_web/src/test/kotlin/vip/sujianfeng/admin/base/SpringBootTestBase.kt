package vip.sujianfeng.admin.base

import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

/**
 * @author SuJianFeng
 * @date 2020/3/26 11:18
 */

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [TestMainApp::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
class SpringBootTestBase {
}


