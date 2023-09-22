package vip.sujianfeng.admin.vo.rbac

import io.swagger.annotations.ApiModel
import vip.sujianfeng.enjoydao.annotations.TbRelationField
import vip.sujianfeng.enjoydao.annotations.TbTableUuid
import vip.sujianfeng.admin.po.rbac.RbacUserPO
import vip.sujianfeng.rbac.intf.IUser


/**
 * @Author GenerateModelBuilder
 * @Date 2023-06-20 08:45:14
 * @Description 读取数据库生成的实体模型代码，仅不存在时生成，可修改
 **/
@ApiModel("用户VO")
@TbTableUuid(table = "rbac_user")
open class RbacUserVO: RbacUserPO(), IUser {

    @TbRelationField(
        joinTable = "rbac_system",
        joinTableAlias = "sys",
        joinCondition = "a.system_id = sys.id",
        srcField = "name"
    )
    var systemName: String? = null

    override fun wgetId(): Any {
        return id ?: ""
    }

    override fun wgetName(): String {
        return name ?: ""
    }

    override fun superAdminUser(): Boolean {
        return userType == 99
    }

    override fun beforeInsert() {
        super.beforeInsert()
        checkNotRepeat(jdbcDao(),"login_name", this.loginName, "登录名不能重复");
    }

    override fun beforeUpdate() {
        super.beforeUpdate()
        checkNotRepeat(jdbcDao(),"login_name", this.loginName, "登录名不能重复");
    }

}
