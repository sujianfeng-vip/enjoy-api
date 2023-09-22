package vip.sujianfeng.admin.module.opLog

import vip.sujianfeng.admin.base.controller.MasterController
import vip.sujianfeng.admin.vo.op.OpLogVO
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vip.sujianfeng.admin.module.opLog.params.OpLogPageParam

/**
 * @Author keyy
 * @Date 2022/5/20
 * @Description
 **/
@Api(tags = ["操作日志"])
@RestController
@RequestMapping("/op-log-api")
class OpLogApiController: MasterController<OpLogVO, OpLogPageParam>() {

}