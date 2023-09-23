package vip.sujianfeng.enjoyapi.po.demo

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import vip.sujianfeng.enjoydao.annotations.*
import vip.sujianfeng.enjoydao.sqlcondition.*
import vip.sujianfeng.enjoydao.enums.*

/**
 * author GenerateModelBuilder
 * description 读取数据库生成的实体模型代码，不要手动修改，重新生成后会覆盖
 **/
@ApiModel("课程定义PO")
@TbTableUuid(table = "demo_course")
open class DemoCoursePO: vip.sujianfeng.enjoyapi.dbconn.MyModelBase() {
    @ApiModelProperty("课程编号")
    @TbFieldString(tableField = "code", label = "课程编号", length = 50)
    var code: String? = null
    @ApiModelProperty("课程名称")
    @TbFieldString(tableField = "name", label = "课程名称", length = 50)
    var name: String? = null

    companion object {
        const val TABLE_NAME = "demo_course"
        const val BIZ_STATUS = "biz_status"
        const val CODE = "code"
        const val CREATE_TIME = "create_time"
        const val CREATE_USER_ID = "create_user_id"
        const val ID = "id"
        const val NAME = "name"
        const val REMARK = "remark"
        const val STATE = "state"
        const val UPDATE_TIME = "update_time"
        const val UPDATE_USER_ID = "update_user_id"
    }
}

/**
 * author GenerateModelBuilder
 * description Sql条件生成器
 **/
class DemoCourseCU: SqlConditionBuilder<DemoCourseCU>() {
    var BIZ_STATUS = SqlConditionField<DemoCourseCU>(this, "a.biz_status")
    var CODE = SqlConditionField<DemoCourseCU>(this, "a.code")
    var CREATE_TIME = SqlConditionField<DemoCourseCU>(this, "a.create_time")
    var CREATE_USER_ID = SqlConditionField<DemoCourseCU>(this, "a.create_user_id")
    var ID = SqlConditionField<DemoCourseCU>(this, "a.id")
    var NAME = SqlConditionField<DemoCourseCU>(this, "a.name")
    var REMARK = SqlConditionField<DemoCourseCU>(this, "a.remark")
    var STATE = SqlConditionField<DemoCourseCU>(this, "a.state")
    var UPDATE_TIME = SqlConditionField<DemoCourseCU>(this, "a.update_time")
    var UPDATE_USER_ID = SqlConditionField<DemoCourseCU>(this, "a.update_user_id")
}
