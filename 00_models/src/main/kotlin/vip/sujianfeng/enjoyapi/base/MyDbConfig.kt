package vip.sujianfeng.enjoyapi.base

import io.swagger.annotations.ApiModelProperty
import vip.sujianfeng.datasource.DruidConfig

/**
 * @Author SuJianFeng
 * @Date 2023/6/29
 * @Description
 **/
class MyDbConfig: DruidConfig() {
    @ApiModelProperty("运行环境")
    var profile: String ?= null
}