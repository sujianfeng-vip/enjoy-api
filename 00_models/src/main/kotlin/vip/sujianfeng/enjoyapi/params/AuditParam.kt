package vip.sujianfeng.enjoyapi.params

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import vip.sujianfeng.enjoydao.handler.model.ManyIdParam

@ApiModel(description = "审批参数")
class AuditParam: ManyIdParam() {
    @ApiModelProperty("审批状态：0-通过，2-驳回", required = true)
    var auditStatus: Int = 0;
    @ApiModelProperty("审批意见")
    var auditReason: String = "";
}