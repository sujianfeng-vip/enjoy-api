package vip.sujianfeng.enjoyapi.utils;

import vip.sujianfeng.utils.comm.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author 苏建锋
 * @Date 2018/12/3 18:42
 **/
public class HttpRequestUtils {

    private static Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class);

    public static String getFullUrl(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        StringBuilder sb = new StringBuilder(url);
        if (request.getQueryString() != null) {
            sb.append('?');
            sb.append(request.getQueryString());
        }
        return sb.toString();
    }

    public static String getFullUri(HttpServletRequest request) {
        String url = request.getRequestURI();
        StringBuilder sb = new StringBuilder(url);
        if (request.getQueryString() != null) {
            sb.append('?');
            sb.append(request.getQueryString());
        }
        return sb.toString();
    }

    public static Map<String, String> getUrlParams(HttpServletRequest request){
        Map<String, String> result = new HashMap<>();
        String queryString = ConvertUtils.cStr(request.getQueryString());
        String[] params = queryString.split("&");
        for(String param: params){
            String[] paramPair = param.split("=");
            if (paramPair.length > 1){
                result.put(paramPair[0], paramPair[1]);
            }
        }
        return result;
    }

    public static String getFullUrl(String url, Map<String, String> params){
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, String>> entries = params.entrySet();
        for (Map.Entry<String, String> entry: entries){
            if (sb.length() == 0)
                sb.append("?");
            else
                sb.append("&");
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
        sb.insert(0, url);
        return sb.toString();
    }

    public static Map<String, String> getCookies(HttpServletRequest request){
        Map<String, String> result = new HashMap<>();
        if (request == null){
            return result;
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies) {
                result.put(cookie.getName(), cookie.getValue());
            }
        }
        return result;
    }

    public static String getCookie(HttpServletRequest request, String key){
        if (request == null){
            return "";
        }
        Map<String, String> cookies = getCookies(request);
        return cookies.get(key);
    }

    /**
     * 保存Cookies
     *
     * @param response
     *            servlet请求
     * @param value
     *            保存值
     */
    public static HttpServletResponse setCookie(HttpServletResponse response, String name, String value, int seconds) {
        // new一个Cookie对象,键值对为参数
        Cookie cookie = new Cookie(name, value);
        // tomcat下多应用共享
        cookie.setPath("/");
        // 如果cookie的值中含有中文时，需要对cookie进行编码，不然会产生乱码
        try {
            URLEncoder.encode(value, "utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error(e.toString(), e);
        }
        cookie.setMaxAge(seconds);
        if (response != null) {
            // 将Cookie添加到Response中,使之生效
            response.addCookie(cookie); // addCookie后，如果已经存在相同名字的cookie，则最新的覆盖旧的cookie
        }
        return response;
    }

    public static Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

    public static Map<String, Object> httpInfo(HttpServletRequest request){
        Map<String, Object> result = new HashMap<>();
        result.put("url", HttpRequestUtils.getFullUrl(request));
        result.put("headers", HttpRequestUtils.getHeadersInfo(request));
        result.put("cookies", HttpRequestUtils.getCookies(request));
        return result;
    }
    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
     *
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
     * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
     *
     * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
     * 192.168.1.100
     *
     * 用户真实IP为： 192.168.1.110
     *
     * @param request
     * @return
     */
    public static String getClientIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    public static HttpServletRequest getRequest(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null){
            return null;
        }
        return ((ServletRequestAttributes)requestAttributes).getRequest();
    }

    public static HttpServletResponse getResponse(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null){
            return null;
        }
        return ((ServletRequestAttributes)requestAttributes).getResponse();
    }


}
