package vip.sujianfeng.enjoyapi.rbac.system.params

import vip.sujianfeng.enjoydao.handler.model.PageParam
import vip.sujianfeng.enjoydao.interfaces.TbDao
import vip.sujianfeng.enjoydao.sqlcondition.ISqlConditionBuilder
import vip.sujianfeng.enjoyapi.po.rbac.RbacSystemCU
import vip.sujianfeng.utils.comm.StringUtilsEx

/**
 * @Author SuJianFeng
 * @Date 2022/5/20
 * @Description
 **/
class SystemPageParam: PageParam() {

    override fun createBuilder(tbDao: TbDao?): ISqlConditionBuilder {
        return RbacSystemCU().apply {
            this.and(StringUtilsEx.isNotEmpty(keyword)) {
                this.NAME.like("%$keyword%")
            }
        }
    }
}