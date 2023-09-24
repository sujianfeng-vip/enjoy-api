package vip.sujianfeng.enjoyapi.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vip.sujianfeng.enjoyapi.dbconn.MyJdbcDao;
import vip.sujianfeng.enjoyapi.dbconn.MyModelBase;
import vip.sujianfeng.enjoyapi.vo.rbac.RbacUserVO;
import vip.sujianfeng.redis.TbRedisCache;
import vip.sujianfeng.token.JwtToken;
import vip.sujianfeng.token.JwtTokenData;
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

    private static String TOKEN_KEY = "TOKEN";
    public static final String TOKEN_SEED = "enjoyApi@2023";
    public static final int TOKEN_EXPIRE_DAYS = 7;
    private static int TIMEOUT_SECONDS = 3600 * 24 * 7;

    private static Logger logger = LoggerFactory.getLogger(UserUtils.class);

    private static RbacUserVO getByToken(String token) {
        if (StringUtilsEx.isNotEmpty(token)) {
            try {
                JwtTokenData jwtTokenData = JwtToken.parseToken(token, TOKEN_SEED);
                if (StringUtilsEx.isNotEmpty(jwtTokenData.getUserId())) {
                    TbRedisCache redisCache = CtxProvider.getBeanByType(TbRedisCache.class);

                    RbacUserVO userVO = redisCache.getObj(jwtTokenData.getUserId(), RbacUserVO.class);
                    if (userVO != null) {
                        return userVO;
                    }
                    userVO = getUserByDB(jwtTokenData.getUserId());

                    if (userVO != null) {
                        userPutToRedis(jwtTokenData.getUserId(), userVO);
                        return userVO;
                    }
                }
            } catch (Exception e) {
                logger.info(e.toString(), e);
            }
        }
        return anonymousUser();
    }

    public static RbacUserVO getCurrUser() {
        return getByToken(getToken());
    }

    private static RbacUserVO getUserByDB(String userId) throws Exception {
        MyJdbcDao myJdbcDao = CtxProvider.getBeanByType(MyJdbcDao.class);
        return myJdbcDao.selectOneByUuId(RbacUserVO.class, userId);
    }

    public static JSONObject getCurrUserJson(){
        String token = getToken();
        if (StringUtilsEx.isEmpty(token)) {
            return new JSONObject();
        }
        return tbRedisCache().getObj(token, JSONObject.class);
    }

    public static RbacUserVO userPutToRedis(String userId, RbacUserVO rbacUserVO) {
        tbRedisCache().addCache(userId, rbacUserVO, TIMEOUT_SECONDS);
        return rbacUserVO;
    }

    public static void logout() {
        RbacUserVO currUser = getCurrUser();
        tbRedisCache().removeCache(currUser.getId());
        logger.info("退出登录：{}", JSON.toJSONString(currUser));
    }

    public static String getCurrUserId() {
        String token = getToken();
        if (StringUtilsEx.isNotEmpty(token)) {
            try {
                JwtTokenData jwtTokenData = JwtToken.parseToken(token, TOKEN_SEED);
                if (StringUtilsEx.isNotEmpty(jwtTokenData.getUserId())) {
                    return jwtTokenData.getUserId();
                }
            } catch (Exception e) {
                logger.info(e.toString(), e);
            }
        }
        return anonymousUser().getId();
    }

    public static String currLoginSystemId() {
        return getCurrUser().getSystemId();
    }

    public static String newToken(JwtTokenData data) throws Exception {
        return JwtToken.newTokenByExpireDays(data, TOKEN_SEED, TOKEN_EXPIRE_DAYS);
    }

    public static RbacUserVO anonymousUser() {
        RbacUserVO result = new RbacUserVO();
        result.setId("0");
        result.setLoginName("匿名");
        return result;
    }

    public static String getToken() {
        String result = "";
        HttpServletRequest request = HttpRequestUtils.getRequest();
        if (request != null) {
            result = HttpRequestUtils.getCookie(request, TOKEN_KEY);
            if (StringUtilsEx.isEmpty(result)) {
                result = request.getHeader(TOKEN_KEY);
                if (StringUtilsEx.isEmpty(result)) {
                    result = request.getHeader(TOKEN_KEY.toUpperCase());
                }
            }
        }
        return result;
    }

    public static TbRedisCache tbRedisCache() {
        return MyModelBase.Companion.tbRedisCache();
    }

    public static boolean isLogin(){
        String currUserId = getCurrUserId();
        return StringUtilsEx.isNotEmpty(currUserId) && !"0".equalsIgnoreCase(currUserId);
    }


}
