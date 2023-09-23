package vip.sujianfeng.enjoyapi.rbac.role.params

import vip.sujianfeng.enjoydao.handler.model.PageParam
import vip.sujianfeng.enjoydao.interfaces.TbDao
import vip.sujianfeng.enjoydao.sqlcondition.ISqlConditionBuilder
import vip.sujianfeng.enjoyapi.po.rbac.RbacRoleCU
import vip.sujianfeng.utils.comm.StringUtilsEx

/**
 * @Author keyy
 * @Date 2022/5/20
 * @Description
 **/
class RolePageParam: PageParam() {

    var systemId = ""

    override fun createBuilder(tbDao: TbDao?): ISqlConditionBuilder {
        return RbacRoleCU().apply {
            this.and().SYSTEM_ID.eq(systemId)
            this.and(StringUtilsEx.isNotEmpty(keyword)) {
                this.NAME.like("%$keyword%")
            }
        }
    }

}