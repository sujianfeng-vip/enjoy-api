package vip.sujianfeng.enjoyapi.rbac.system

import vip.sujianfeng.enjoyapi.base.controller.MasterController
import vip.sujianfeng.enjoyapi.vo.rbac.RbacSystemVO
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vip.sujianfeng.enjoyapi.rbac.system.params.SystemPageParam

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