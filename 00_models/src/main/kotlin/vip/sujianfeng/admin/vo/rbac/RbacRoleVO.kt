package vip.sujianfeng.admin.vo.rbac

import io.swagger.annotations.ApiModel
import vip.sujianfeng.enjoydao.annotations.TbTableUuid
import vip.sujianfeng.admin.po.rbac.RbacRolePO
import vip.sujianfeng.rbac.intf.IRole

/**
 * @Author GenerateModelBuilder
 * @Date 2023-06-20 08:45:14
 * @Description 读取数据库生成的实体模型代码，仅不存在时生成，可修改
 **/
@ApiModel("角色定义VO")
@TbTableUuid(table = "rbac_role")
open class RbacRoleVO: RbacRolePO(), IRole {
    override fun wgetId(): String {
        return id ?: ""
    }

    override fun wgetName(): String {
        return name ?: ""
    }
}
