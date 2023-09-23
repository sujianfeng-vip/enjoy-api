package vip.sujianfeng.enjoyapi.rbac.userRole.params

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import vip.sujianfeng.enjoydao.handler.model.PageParam
import vip.sujianfeng.enjoydao.interfaces.TbDao
import vip.sujianfeng.enjoydao.sqlcondition.ISqlConditionBuilder
import vip.sujianfeng.enjoyapi.po.rbac.RbacRoleUserCU

/**
 * @Author keyy
 * @Date 2022/5/20
 * @Description
 **/
@ApiModel(description = "分配")
class AllowUserRolePageParam: PageParam() {

    @ApiModelProperty("用户id")
    var userId: String? = null

    var systemId = ""

    override fun createBuilder(tbDao: TbDao?): ISqlConditionBuilder {
        return RbacRoleUserCU().apply {
            this.and().SYSTEM_ID.eq(systemId)
            this.and().USER_ID.eq(userId)
        }
    }
}