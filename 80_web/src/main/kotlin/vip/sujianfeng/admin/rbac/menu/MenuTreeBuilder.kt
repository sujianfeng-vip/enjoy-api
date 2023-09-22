package vip.sujianfeng.admin.rbac.menu

import vip.sujianfeng.admin.vo.rbac.RbacMenuVO
import vip.sujianfeng.enjoydao.tree.TreeBuilder
import vip.sujianfeng.enjoydao.tree.models.QueryChildTreeParam
import vip.sujianfeng.enjoydao.tree.models.TreeData
import vip.sujianfeng.enjoydao.tree.models.TreeNode
import vip.sujianfeng.utils.comm.StringUtilsEx
import kotlin.streams.toList

/**
 * @Author SuJianFeng
 * @Date 2023/8/2
 * @Description
 **/
class MenuTreeBuilder(var menuRows: List<RbacMenuVO>) {

    fun buildTreeNodes(): List<TreeNode<TreeData>> {
        return ArrayList<TreeNode<TreeData>>().apply {
            menuRows.forEach {
                if (findParentNode(it) == null) {
                    this.add(TreeNode<TreeData>().apply {
                        this.value = it.id
                        this.title = it.name
                        this.parentId = it.parentId
                        addChildNode(this, ArrayList())
                    })
                }
            }
        }
    }

    fun findSubNodes(params: QueryChildTreeParam<TreeData>): List<TreeNode<TreeData>> {
        val treeBuilder = TreeBuilder()
        return treeBuilder.findTreeList(buildTreeNodes(), params)
    }

    fun findParentNode(currNode: RbacMenuVO): RbacMenuVO? {
        if (StringUtilsEx.isEmpty(currNode.parentId)) {
            return null
        }
        return menuRows.stream().filter { it.id == currNode.parentId }.findAny().orElse(null)
    }

    fun addChildNode(currNode: TreeNode<TreeData>, parentLink: MutableList<TreeNode<TreeData>>) {
        parentLink.add(currNode)
        menuRows.stream().filter { it.parentId == currNode.value }.toList().forEach { type ->
            if (parentLink.stream().filter { it.value == type.id }.count() > 0) {
                //避免死循环
                return@forEach
            }
            if (currNode.children == null) {
                currNode.children = ArrayList()
            }
            currNode.children.add(TreeNode<TreeData>().apply {
                this.value = type.id
                this.title = type.name
                this.parentId = type.parentId
                val tmpParentList = ArrayList<TreeNode<TreeData>>()
                tmpParentList.addAll(parentLink)
                tmpParentList.add(this)
                addChildNode(this, parentLink)
            })
        }
    }

}