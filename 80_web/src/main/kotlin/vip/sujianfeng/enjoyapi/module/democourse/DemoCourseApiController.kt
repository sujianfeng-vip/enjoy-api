package vip.sujianfeng.enjoyapi.module.democourse

import vip.sujianfeng.enjoyapi.base.controller.MasterController
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vip.sujianfeng.enjoydao.interfaces.JdbcTbDao
import vip.sujianfeng.utils.define.CallResult
import DemoCoursePageParam
import vip.sujianfeng.enjoyapi.vo.demo.DemoCourseVO

/**
 * author GenerateCodeBuilder
 * createTime 2023-09-23 16:35:41
 * description 读取数据库生成的代码，仅不存在时生成，可修改
 **/
@Api(tags = ["课程定义"])
@RestController
@RequestMapping("/module/demo-course-api")
class DemoCourseApiController: MasterController<DemoCourseVO, DemoCoursePageParam>() {
}