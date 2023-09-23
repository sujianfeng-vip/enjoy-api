package vip.sujianfeng.enjoyapi.vo.rbac

import io.swagger.annotations.ApiModel
import vip.sujianfeng.enjoydao.annotations.*
import vip.sujianfeng.enjoyapi.po.rbac.*

/**
 * @Author GenerateModelBuilder
 * @Date 2023-06-20 08:45:14
 * @Description 读取数据库生成的实体模型代码，仅不存在时生成，可修改
 **/
@ApiModel("系统定义VO")
@TbTableUuid(table = "rbac_system")
open class RbacSystemVO: RbacSystemPO() {
}
