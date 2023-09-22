package vip.sujianfeng.admin.rbac.user

import vip.sujianfeng.utils.define.CallResult
import vip.sujianfeng.utils.comm.StringUtilsEx
import vip.sujianfeng.admin.base.controller.MasterController
import vip.sujianfeng.admin.vo.rbac.RbacUserVO
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vip.sujianfeng.enjoydao.handler.model.OneIdParam
import vip.sujianfeng.enjoydao.interfaces.JdbcTbDao
import vip.sujianfeng.admin.rbac.user.params.ChangeThemeParam
import vip.sujianfeng.admin.rbac.user.params.UserPageParam
import vip.sujianfeng.admin.rbac.user.params.UserPasswordParam
import vip.sujianfeng.enjoydao.handler.model.ManyIdParam

/**
 * @Author keyy
 * @Date 2022/5/20
 * @Description
 **/
@Api(tags = ["用户管理"])
@RestController
@RequestMapping("/user-api")
class UserApiController: MasterController<RbacUserVO, UserPageParam>() {


    override fun afterAdd(op: CallResult<*>, jdbcDao: JdbcTbDao, item: RbacUserVO) {
        super.afterAdd(op, jdbcDao, item)
        myRbacHandler.clearCache()
    }

    override fun afterUpdate(op: CallResult<*>, jdbcDao: JdbcTbDao, item: RbacUserVO) {
        super.afterUpdate(op, jdbcDao, item)
        myRbacHandler.clearCache()
    }

    override fun afterDelete(
        op: CallResult<*>,
        jdbcDao: JdbcTbDao,
        manyIdParam: ManyIdParam,
        rows: MutableList<RbacUserVO>
    ) {
        super.afterDelete(op, jdbcDao, manyIdParam, rows)
        myRbacHandler.clearCache()
    }


    @Autowired
    lateinit var myRbacHandler: vip.sujianfeng.admin.config.MyRbacHandler

    @ApiOperation("切换主题")
    @PostMapping("/changeTheme")
    fun changeTheme(@RequestBody param: ChangeThemeParam): CallResult<String> {
        return CallResult.opCall {
            if (StringUtilsEx.isEmpty(param.theme)){
                it.error("主题参数为空!")
                return@opCall
            }
            val userInfo = vip.sujianfeng.admin.utils.UserUtils.getCurrUser()
            userInfo.theme = param.theme
            jdbcTbDao().update(userInfo, "theme")
            vip.sujianfeng.admin.utils.UserUtils.userPutToRedis(vip.sujianfeng.admin.utils.UserUtils.getToken(), userInfo)
        }
    }

    @ApiOperation("切换系统")
    @PostMapping("/changeSystem")
    fun changeSystem(@RequestBody param: OneIdParam): CallResult<String> {
        return CallResult.opCall {
            if (StringUtilsEx.isEmpty(param.id)){
                it.error("系统id参数为空!")
                return@opCall
            }
            val userInfo = vip.sujianfeng.admin.utils.UserUtils.getCurrUser()
            userInfo.systemId = param.id
            jdbcTbDao().update(userInfo, "systemId")
            val rbacUserVO = jdbcTbDao().selectOneByUuId(RbacUserVO::class.java, userInfo.id)
            vip.sujianfeng.admin.utils.UserUtils.userPutToRedis(vip.sujianfeng.admin.utils.UserUtils.getToken(), rbacUserVO)
        }
    }

    @ApiOperation("修改密码")
    @PostMapping("/editPassword")
    fun checkLink(@RequestBody param: UserPasswordParam): CallResult<Any> {
        return CallResult.opCall {
            var id = currUserId()
            var user = jdbcTbDao().selectOneByUuId(RbacUserVO::class.java, id)
            if (user == null){
                it.error("用户信息不存在: %s", id)
                return@opCall
            }
            if (!user.password.equals(param.password)) {
                it.error("旧密码不正确")
                return@opCall
            }
            if (!param.newPassword.equals(param.confirmPassword)) {
                it.error("两次密码输入不一样")
                return@opCall
            }

            user.password = param.newPassword
            jdbcTbDao().update(user, "password")
        }
    }
}