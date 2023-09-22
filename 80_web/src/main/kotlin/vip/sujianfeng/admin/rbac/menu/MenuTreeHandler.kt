package vip.sujianfeng.admin.rbac.menu

import vip.sujianfeng.admin.vo.rbac.RbacMenuVO
import vip.sujianfeng.enjoydao.tree.models.TreeData
import vip.sujianfeng.enjoydao.tree.models.TreeNode
import vip.sujianfeng.utils.comm.StringUtilsEx

/**
 * @Author SuJianFeng
 * @Date 2023/9/11
 * @Description
 **/
class MenuTreeHandler(var menuList: List<RbacMenuVO>) {

    fun buildTree(): ArrayList<TreeNode<TreeData>> {
        return ArrayList<TreeNode<TreeData>>().apply {
            menuList.forEach {
                if (StringUtilsEx.isEmpty(it.parentId)) {
                    addTreeNode(this, null, it)
                }
            }
        }
    }

    fun addTreeNode(treeList: ArrayList<TreeNode<TreeData>>, parentMenu: TreeNode<TreeData>?, menuVO: RbacMenuVO) {
        val treeNode = TreeNode<TreeData>().apply {
            this.title = menuVO.name
            this.value = menuVO.id
            menuList.stream().filter { it.parentId == menuVO.id }.forEach {
                addTreeNode( treeList, this, it)
            }
            this.isExpand = true
        }
        if (parentMenu != null) {
            if (parentMenu.children == null) {
                parentMenu.children = ArrayList()
            }
            parentMenu.children.add(treeNode)
            return
        }
        treeList.add(treeNode)
    }
}