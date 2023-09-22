package vip.sujianfeng.admin.views

import io.swagger.annotations.ApiModelProperty

/**
 * @Author SuJianFeng
 * @Date 2022/6/9
 * @Description
 **/
class IViewTreeNode {

    @ApiModelProperty("ID")
    var id: String? = null

    @ApiModelProperty("标题")
    var title: String? = null

    @ApiModelProperty("是否展开子节点")
    var expand: Boolean? = null

    @ApiModelProperty("是否勾选")
    var checked: Boolean? = null

    @ApiModelProperty("上级ID")
    var parentId: String? = null

    @ApiModelProperty("子节点")
    var children = ArrayList<IViewTreeNode>()
}