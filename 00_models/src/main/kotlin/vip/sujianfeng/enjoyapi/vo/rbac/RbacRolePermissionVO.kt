package vip.sujianfeng.enjoyapi.vo.rbac

import io.swagger.annotations.ApiModel
import vip.sujianfeng.enjoydao.annotations.TbTableUuid
import vip.sujianfeng.enjoyapi.po.rbac.RbacRolePermissionPO
import vip.sujianfeng.rbac.intf.IRolePermission

/**
 * @Author GenerateModelBuilder
 * @Date 2023-06-20 08:45:14
 * @Description 读取数据库生成的实体模型代码，仅不存在时生成，可修改
 **/
@ApiModel("角色权限VO")
@TbTableUuid(table = "rbac_role_permission")
open class RbacRolePermissionVO: RbacRolePermissionPO(), IRolePermission {
    override fun wgetRoleId(): String {
        return roleId ?: ""
    }

    override fun wgetPermissionId(): String {
        return permissionId ?: ""
    }
}
