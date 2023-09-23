package vip.sujianfeng.enjoyapi.rbac.menu.params

import vip.sujianfeng.enjoyapi.po.rbac.RbacMenuCU
import vip.sujianfeng.enjoydao.handler.model.PageParam
import vip.sujianfeng.enjoydao.interfaces.TbDao
import vip.sujianfeng.enjoydao.sqlcondition.ISqlConditionBuilder
import vip.sujianfeng.utils.comm.StringUtilsEx

/**
 * @Author keyy
 * @Date 2022/5/20
 * @Description
 **/
class MenuPageParam: PageParam() {
    var systemId: String = ""
    var parentId: String = ""

    override fun createBuilder(tbDao: TbDao?): ISqlConditionBuilder {
        return RbacMenuCU().apply {
            this.and().block("(a.id = '$parentId' or ifnull(a.parent_id, '') = '$parentId')")
            this.and().SYSTEM_ID.eq(systemId)
            this.and(StringUtilsEx.isNotEmpty(keyword)) {
                this.NAME.like("%$keyword%")
            }
        }
    }
}