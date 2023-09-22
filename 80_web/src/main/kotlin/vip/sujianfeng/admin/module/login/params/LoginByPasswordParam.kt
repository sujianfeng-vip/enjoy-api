package vip.sujianfeng.admin.module.login.params

import io.swagger.annotations.ApiModel

/**
 * @author SuJianFeng
 * @date 2022/5/28
 * @Description
 */
@ApiModel(description = "密码登录参数")
class LoginByPasswordParam {
    var systemId = ""
    var loginName: String = ""
    var password: String = ""
    var verificationCode: String = ""
    var channelId: String = ""
}