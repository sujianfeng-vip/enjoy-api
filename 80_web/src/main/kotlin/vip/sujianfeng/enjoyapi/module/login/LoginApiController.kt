package vip.sujianfeng.enjoyapi.module.login

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vip.sujianfeng.enjoyapi.base.controller.BaseController
import vip.sujianfeng.enjoyapi.enums.UserType
import vip.sujianfeng.enjoyapi.module.login.params.LoginByPasswordParam
import vip.sujianfeng.enjoyapi.utils.UserUtils
import vip.sujianfeng.enjoyapi.utils.UserUtils.getToken
import vip.sujianfeng.enjoyapi.vo.rbac.RbacUserVO
import vip.sujianfeng.redis.TbRedisCache
import vip.sujianfeng.utils.comm.StringUtilsEx
import vip.sujianfeng.utils.define.CallResult

/**
 * @Author SuJianFeng
 * @Date 2022/5/27
 * @Description
 **/
@Api(tags = ["用户登录"])
@RestController
@RequestMapping("/login")
class LoginApiController: BaseController() {

    @Autowired
    lateinit var tbRedisCache: TbRedisCache

    @ApiOperation("通过用户名密码登录")
    @PostMapping("/loginByPassword")
    fun loginByPassword(@RequestBody param: LoginByPasswordParam): CallResult<RbacUserVO> {
        return CallResult.opCall {
            if (param.loginName == "" || param.password == "") {
                it.error("登录名称或密码不能为空!")
                return@opCall
            }
            var rbacUserVO = jdbcTbDao().selectOneByCondition(RbacUserVO::class.java, " and a.state = 0 and a.login_name = ?", param.loginName)
            if (rbacUserVO == null) {
                it.error("登录名称不存在!")
                return@opCall
            }
            if (rbacUserVO.userType == UserType.UnAudit.code) {
                it.error("登录名称未审核!")
                return@opCall
            }
            if (rbacUserVO.password != param.password) {
                it.error("密码错误!")
                return@opCall
            }
            if (StringUtilsEx.isEmpty(param.systemId)) {
                it.error("未选择登录系统!")
                return@opCall
            }
            rbacUserVO.systemId = param.systemId
            jdbcTbDao().update(rbacUserVO, "systemId")
            rbacUserVO = jdbcTbDao().selectOneByUuId(RbacUserVO::class.java, rbacUserVO.id)
            it.data = UserUtils.userPutToRedis(getToken(), rbacUserVO)
            addOpLog("", "","密码登录")
            //发送token给客户端
            /*
            WebSocketChannel.sendMessage(param.channelId, WebSocketMsg<RbacUser>().apply {
                this.type = WebSocketMsgType.LoginSuccess.type
                this.content = it.data
            })
            */
        }
    }
}