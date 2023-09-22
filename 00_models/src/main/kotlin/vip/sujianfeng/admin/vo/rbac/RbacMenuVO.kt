package vip.sujianfeng.admin.vo.rbac

import io.swagger.annotations.ApiModel
import vip.sujianfeng.enjoydao.annotations.TbRelationField
import vip.sujianfeng.enjoydao.annotations.TbTableUuid
import vip.sujianfeng.admin.po.rbac.RbacMenuPO
import vip.sujianfeng.rbac.intf.IMenu


/**
 * @Author GenerateModelBuilder
 * @Date 2023-06-20 08:45:14
 * @Description 读取数据库生成的实体模型代码，仅不存在时生成，可修改
 **/
@ApiModel("菜单定义VO")
@TbTableUuid(table = "rbac_menu")
open class RbacMenuVO: RbacMenuPO(), IMenu<RbacMenuVO> {

    @TbRelationField(
        joinTable = "rbac_menu",
        joinTableAlias = "p",
        joinCondition = "a.parent_id = p.id",
        srcField = "name"
    )
    var parentName: String? = null

    @TbRelationField(
        joinTable = "rbac_permission",
        joinTableAlias = "per",
        joinCondition = "a.permission_id = per.id",
        srcField = "name"
    )
    var permissionName: String? = null

    var children: MutableList<RbacMenuVO> = ArrayList()

    override fun wgetId(): String {
        return this.id
    }

    override fun wgetName(): String {
        return name ?: ""
    }

    override fun wgetParentId(): String {
        return parentId ?: ""
    }

    override fun wgetPermissionId(): String {
        return permissionId ?: ""
    }

    override fun wgetChildren(): List<RbacMenuVO> {
        return children
    }

    override fun addChild(menu: RbacMenuVO) {
        this.children.add(menu)
    }
}
