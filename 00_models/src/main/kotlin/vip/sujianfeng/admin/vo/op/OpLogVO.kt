package vip.sujianfeng.admin.vo.op

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import vip.sujianfeng.enjoydao.annotations.TbTableUuid
import vip.sujianfeng.admin.po.op.OpLogPO
import vip.sujianfeng.enjoydao.annotations.TbRelationField

/**
 * @Author SuJianFeng
 * @Date 2022/6/2
 * @Description
 **/
@ApiModel(description = "操作日志")
@TbTableUuid(table = "op_log")
class OpLogVO: OpLogPO() {

    @ApiModelProperty("操作人名称")
    @TbRelationField(joinTable = "rbac_user", joinTableAlias = "ou", joinCondition = "a.user_id = ou.id", srcField = "ou.name")
    var userName: String? = null
}
