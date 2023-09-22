package vip.sujianfeng.admin.params

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import vip.sujianfeng.enjoydao.handler.model.ManyIdParam

@ApiModel(description = "启用/禁用参数")
class BizChangeParam: ManyIdParam() {
    @ApiModelProperty("状态：0-启用，1-禁用", required = true)
    var bizStatus: Int = 0;
    @ApiModelProperty("审批意见")
    var bizChangeReason: String = "";
}