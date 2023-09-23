package vip.sujianfeng.enjoyapi.views

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * @Author SuJianFeng
 * @Date 2022/5/26
 * @Description
 **/
@ApiModel(description = "列定义")
class MySqlColumn {

    @ApiModelProperty("库名")
    var tableSchema: String ?= null

    @ApiModelProperty("表名")
    var tableName: String ?= null

    @ApiModelProperty("字段名")
    var columnName: String ?= null

    @ApiModelProperty("数据类型")
    var dateType: String ?= null

    @ApiModelProperty("字段备注")
    var columnComment: String ?= null

    @ApiModelProperty("关联表")
    var relationTable: String ?= null

    @ApiModelProperty("描述")
    var desc: String ?= null

    @ApiModelProperty("数据类型")
    var dataType: String ?= null

    @ApiModelProperty("长度")
    var length: String ?= null

}