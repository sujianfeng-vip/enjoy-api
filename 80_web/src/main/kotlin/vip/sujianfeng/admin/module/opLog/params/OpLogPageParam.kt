package vip.sujianfeng.admin.module.opLog.params

import io.swagger.annotations.ApiModel
import vip.sujianfeng.enjoydao.handler.model.PageParam
import vip.sujianfeng.enjoydao.interfaces.TbDao
import vip.sujianfeng.enjoydao.sqlcondition.ISqlConditionBuilder
import vip.sujianfeng.admin.po.op.OpLogCU
import vip.sujianfeng.utils.comm.StringUtilsEx

/**
 * @Author keyy
 * @Date 2022/5/20
 * @Description
 **/
@ApiModel("操作日志-分页查询参数")
class OpLogPageParam: PageParam() {

    override fun createBuilder(tbDao: TbDao?): ISqlConditionBuilder {
        return OpLogCU().apply {
            this.and(StringUtilsEx.isNotEmpty(keyword)) {
                this.newPar {
                    this.CONTENT.like("%$keyword%")
                    this.or().block(" u.name like '%$keyword%' ")
                }
            }
        }
    }
}