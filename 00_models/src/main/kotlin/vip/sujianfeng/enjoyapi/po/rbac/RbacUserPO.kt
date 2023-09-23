package vip.sujianfeng.enjoyapi.po.rbac

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import vip.sujianfeng.enjoydao.annotations.*
import vip.sujianfeng.enjoydao.sqlcondition.*
import vip.sujianfeng.enjoydao.enums.*

/**
 * author GenerateModelBuilder
 * description 读取数据库生成的实体模型代码，不要手动修改，重新生成后会覆盖
 **/
@ApiModel("用户PO")
@TbTableUuid(table = "rbac_user")
open class RbacUserPO: vip.sujianfeng.enjoyapi.dbconn.MyModelBase() {
    @ApiModelProperty("头像URL")
    @TbFieldString(tableField = "avatar_url", label = "头像URL", length = 500)
    var avatarUrl: String? = null
    @ApiModelProperty("登录名称")
    @TbFieldString(tableField = "login_name", label = "登录名称", length = 50)
    var loginName: String? = null
    @ApiModelProperty("名称")
    @TbFieldString(tableField = "name", label = "名称", length = 100)
    var name: String? = null
    @ApiModelProperty("微信openId")
    @TbFieldString(tableField = "open_id", label = "微信openId", length = 50)
    var openId: String? = null
    @ApiModelProperty("登录密码")
    @TbFieldString(tableField = "password", label = "登录密码", length = 50)
    var password: String? = null
    @ApiModelProperty("系统ID")
    @TbFieldString(tableField = "system_id", label = "系统ID", length = 50)
    var systemId: String? = null
    @ApiModelProperty("手机")
    @TbFieldString(tableField = "telephone", label = "手机", length = 255)
    var telephone: String? = null
    @ApiModelProperty("界面主题")
    @TbFieldString(tableField = "theme", label = "界面主题", length = 50)
    var theme: String? = null
    @ApiModelProperty("0-游客，1-普通用户, 99-管理员")
    @TbFieldInt(tableField = "user_type", label = "0-游客，1-普通用户, 99-管理员")
    var userType: Int? = null

    companion object {
        const val TABLE_NAME = "rbac_user"
        const val AVATAR_URL = "avatar_url"
        const val BIZ_STATUS = "biz_status"
        const val CREATE_TIME = "create_time"
        const val CREATE_USER_ID = "create_user_id"
        const val ID = "id"
        const val LOGIN_NAME = "login_name"
        const val NAME = "name"
        const val OPEN_ID = "open_id"
        const val PASSWORD = "password"
        const val REMARK = "remark"
        const val STATE = "state"
        const val SYSTEM_ID = "system_id"
        const val TELEPHONE = "telephone"
        const val THEME = "theme"
        const val UPDATE_TIME = "update_time"
        const val UPDATE_USER_ID = "update_user_id"
        const val USER_TYPE = "user_type"
    }
}

/**
 * author GenerateModelBuilder
 * description Sql条件生成器
 **/
class RbacUserCU: SqlConditionBuilder<RbacUserCU>() {
    var AVATAR_URL = SqlConditionField<RbacUserCU>(this, "a.avatar_url")
    var BIZ_STATUS = SqlConditionField<RbacUserCU>(this, "a.biz_status")
    var CREATE_TIME = SqlConditionField<RbacUserCU>(this, "a.create_time")
    var CREATE_USER_ID = SqlConditionField<RbacUserCU>(this, "a.create_user_id")
    var ID = SqlConditionField<RbacUserCU>(this, "a.id")
    var LOGIN_NAME = SqlConditionField<RbacUserCU>(this, "a.login_name")
    var NAME = SqlConditionField<RbacUserCU>(this, "a.name")
    var OPEN_ID = SqlConditionField<RbacUserCU>(this, "a.open_id")
    var PASSWORD = SqlConditionField<RbacUserCU>(this, "a.password")
    var REMARK = SqlConditionField<RbacUserCU>(this, "a.remark")
    var STATE = SqlConditionField<RbacUserCU>(this, "a.state")
    var SYSTEM_ID = SqlConditionField<RbacUserCU>(this, "a.system_id")
    var TELEPHONE = SqlConditionField<RbacUserCU>(this, "a.telephone")
    var THEME = SqlConditionField<RbacUserCU>(this, "a.theme")
    var UPDATE_TIME = SqlConditionField<RbacUserCU>(this, "a.update_time")
    var UPDATE_USER_ID = SqlConditionField<RbacUserCU>(this, "a.update_user_id")
    var USER_TYPE = SqlConditionField<RbacUserCU>(this, "a.user_type")
}
