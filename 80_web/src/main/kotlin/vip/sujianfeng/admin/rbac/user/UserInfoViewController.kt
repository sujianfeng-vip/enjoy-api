package vip.sujianfeng.admin.rbac.user

import vip.sujianfeng.utils.comm.StringUtilsEx
import com.alibaba.fastjson.JSON
import vip.sujianfeng.admin.base.controller.BaseController
import io.swagger.annotations.Api
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView
import vip.sujianfeng.admin.vo.rbac.RbacUserVO

/**
 * @Author keyy
 * @Date 2022/6/1
 * @Description
 **/
@Api(tags = ["界面视图"])
@Controller
class UserInfoViewController: BaseController() {

    @GetMapping("/rbac/user-info/edit")
    fun edit(): ModelAndView {
        return ModelAndView("rbac/user-info/edit", ModelMap().apply {
            this["moduleCode"] = "rbac/user"
            this["moduleApi"] = "user-api"
            var id = currUserId()
            this["formItemJson"] = if(StringUtilsEx.isEmpty(id)) "{}" else JSON.toJSONString(jdbcTbDao().selectOneByUuId(
                RbacUserVO::class.java, id))
        })
    }


}