package vip.sujianfeng.enjoyapi.rbac.user.params

import vip.sujianfeng.enjoydao.handler.model.PageParam
import vip.sujianfeng.enjoydao.interfaces.TbDao
import vip.sujianfeng.enjoydao.sqlcondition.ISqlConditionBuilder
import vip.sujianfeng.enjoyapi.po.rbac.RbacUserCU
import vip.sujianfeng.utils.comm.StringUtilsEx

/**
 * @Author keyy
 * @Date 2022/5/20
 * @Description
 **/
class UserPageParam: PageParam() {
    override fun createBuilder(tbDao: TbDao?): ISqlConditionBuilder {
        return RbacUserCU().apply {
            this.and(StringUtilsEx.isNotEmpty(keyword)) {
                this.NAME.like("%$keyword%")
            }
        }
    }
}