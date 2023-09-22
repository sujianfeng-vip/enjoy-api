package vip.sujianfeng.admin.views

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * @Author SuJianFeng
 * @Date 2022/5/26
 * @Description
 **/
@ApiModel(description = "表定义")
class MySqlTable {

    @ApiModelProperty("库名")
    var tableSchema: String ?= null

    @ApiModelProperty("表名")
    var tableName: String ?= null

    @ApiModelProperty("总行数")
    var tableRows: Int ?= null

    @ApiModelProperty("平均每行长度")
    var avgRowLength: Int ?= null

    @ApiModelProperty("总长度")
    var dataLength: Int ?= null

    @ApiModelProperty("创建时间")
    var createTime: Int ? = null

    @ApiModelProperty("修改时间")
    var updateTime: Int ?= null

    @ApiModelProperty("表备注")
    var tableComment: String ?= null

    @ApiModelProperty("描述")
    var desc: String ?= null

}