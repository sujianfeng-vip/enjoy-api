package vip.sujianfeng.admin.vo.rbac

import io.swagger.annotations.ApiModel
import vip.sujianfeng.enjoydao.annotations.TbTableUuid
import vip.sujianfeng.admin.po.rbac.RbacRoleUserPO
import vip.sujianfeng.rbac.intf.IRoleUser

/**
 * @Author GenerateModelBuilder
 * @Date 2023-06-20 08:45:14
 * @Description 读取数据库生成的实体模型代码，仅不存在时生成，可修改
 **/
@ApiModel("角色用户VO")
@TbTableUuid(table = "rbac_role_user")
open class RbacRoleUserVO: RbacRoleUserPO(), IRoleUser {
    override fun wgetRoleId(): String {
        return roleId ?: ""
    }

    override fun wgetUserId(): String {
        return userId ?: ""
    }
}
