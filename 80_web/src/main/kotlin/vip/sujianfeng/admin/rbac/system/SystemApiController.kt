package vip.sujianfeng.admin.rbac.system

import vip.sujianfeng.admin.base.controller.MasterController
import vip.sujianfeng.admin.vo.rbac.RbacSystemVO
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vip.sujianfeng.admin.rbac.system.params.SystemPageParam

/**
 * @Author SuJianFeng
 * @Date 2022/5/20
 * @Description
 **/
@Api(tags = ["系统管理"])
@RestController
@RequestMapping("/system-api")
class SystemApiController: MasterController<RbacSystemVO, SystemPageParam>() {

}