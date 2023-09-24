package vip.sujianfeng.enjoyapi.module.login.dto

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
}