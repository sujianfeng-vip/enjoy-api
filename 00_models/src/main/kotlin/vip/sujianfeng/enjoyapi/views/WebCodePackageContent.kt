package vip.sujianfeng.enjoyapi.views

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * @author SuJianFeng
 * @date 2022/6/4
 * @Description
 */
@ApiModel(description = "代码包内容")
class WebCodePackageContent {
    @ApiModelProperty("主入口代码id")
    var mainCodeId: String = ""
    @ApiModelProperty("代码id列表")
    var subCodeIdList: ArrayList<String> = ArrayList()
}