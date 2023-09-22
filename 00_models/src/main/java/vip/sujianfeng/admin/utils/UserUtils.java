package vip.sujianfeng.admin.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vip.sujianfeng.admin.dbconn.MyModelBase;
import vip.sujianfeng.admin.vo.rbac.RbacUserVO;
import vip.sujianfeng.redis.TbRedisCache;
import vip.sujianfeng.utils.comm.ConvertUtils;
import vip.sujianfeng.utils.comm.GuidUtils;
import vip.sujianfeng.utils.comm.StringUtilsEx;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户工具类
 * @Author SuJianFeng
 * @create 2020-11-15 12:18
 */
public class UserUtils {

    private static String USER_TOKEN = "TOKEN";
    private static int TIMEOUT_SECONDS = 3600 * 24 * 7;

    private static Logger logger = LoggerFactory.getLogger(UserUtils.class);

    public static RbacUserVO getCurrUser(){
        String token = getToken();
        if (StringUtilsEx.isEmpty(token)) {
            return null;
        }
        return tbRedisCache().getObj(token, RbacUserVO.class);
    }

    public static JSONObject getCurrUserJson(){
        String token = getToken();
        if (StringUtilsEx.isEmpty(token)) {
            return new JSONObject();
        }
        return tbRedisCache().getObj(token, JSONObject.class);
    }

    public static RbacUserVO userPutToRedis(String token, RbacUserVO rbacUserVO) {
        tbRedisCache().addCache(token, rbacUserVO, TIMEOUT_SECONDS);
        return rbacUserVO;
    }

    public static void logout() {
        RbacUserVO currUser = getCurrUser();
        if (currUser == null){
            return;
        }
        tbRedisCache().removeCache(getToken());
        logger.info("退出登录：{}", JSON.toJSONString(currUser));
    }

    public static String getCurrUserId() {
        RbacUserVO result = getCurrUser();
        return result != null ? ConvertUtils.cStr(result.getId()) : "";
    }

    public static String currLoginSystemId() {
        RbacUserVO currUser = getCurrUser();
        return currUser != null && StringUtilsEx.isNotEmpty(currUser.getSystemId()) ? currUser.getSystemId() : "";
    }

    public static String getToken() {
        String result = "";
        HttpServletRequest request = HttpRequestUtils.getRequest();
        if (request != null) {
            result = HttpRequestUtils.getCookie(request, USER_TOKEN);
            /*
            String id = request.getSession().getId();
            id = id.replace("-", "");
            return id;
            */
            if (StringUtilsEx.isEmpty(result)) {
                result = request.getHeader(USER_TOKEN);
            }

        }
        if (StringUtilsEx.isEmpty(result)) {
            result = GuidUtils.buildGuid();
            HttpRequestUtils.setCookie(HttpRequestUtils.getResponse(), USER_TOKEN, result, TIMEOUT_SECONDS);
        }
        return result;
    }

    public static TbRedisCache tbRedisCache() {
        return MyModelBase.Companion.tbRedisCache();
    }

    public static boolean isLogin(){
        return getCurrUser() != null;
    }


}
