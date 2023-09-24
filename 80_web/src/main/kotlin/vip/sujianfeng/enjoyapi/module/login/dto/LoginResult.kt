package vip.sujianfeng.enjoyapi.module.login.dto

import io.swagger.annotations.ApiModelProperty
import vip.sujianfeng.enjoyapi.vo.rbac.RbacUserVO

/**
 *
 * @Date 2022/12/15
 * @Description
 **/
open class LoginResult {

    @ApiModelProperty("token")
    var token: String? = null

    @ApiModelProperty("用户信息")
    var userInfo: RbacUserVO? = null
}