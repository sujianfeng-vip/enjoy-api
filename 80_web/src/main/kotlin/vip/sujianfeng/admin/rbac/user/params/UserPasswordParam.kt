package vip.sujianfeng.admin.rbac.user.params

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * @Author keyy
 * @Date 2022/6/1
 * @Description
 **/
@ApiModel(description = "用户密码参数")
class UserPasswordParam {

    @ApiModelProperty("旧密码")
    var password: String? = ""

    @ApiModelProperty("新密码")
    var newPassword: String? = ""

    @ApiModelProperty("确认新密码")
    var confirmPassword: String? = ""

}