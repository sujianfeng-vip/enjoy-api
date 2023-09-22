package vip.sujianfeng.admin.vo.rbac

import io.swagger.annotations.ApiModel
import vip.sujianfeng.enjoydao.annotations.TbTableUuid
import vip.sujianfeng.admin.po.rbac.RbacPermissionPO
import vip.sujianfeng.rbac.intf.IPermission

/**
 * @Author GenerateModelBuilder
 * @Date 2023-06-20 08:45:14
 * @Description 读取数据库生成的实体模型代码，仅不存在时生成，可修改
 **/
@ApiModel("权限定义VO")
@TbTableUuid(table = "rbac_permission")
open class RbacPermissionVO: RbacPermissionPO(), IPermission {
    override fun wgetId(): String {
        return id ?: ""
    }

    override fun wgetName(): String {
        return name ?: ""
    }

}
