package vip.sujianfeng.admin.utils;

import vip.sujianfeng.utils.comm.StringUtilsEx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class CtxProvider implements ApplicationContextAware {
    private static ApplicationContext ctx;

    @PostConstruct
    public void init() throws Exception {

    }

    public static ApplicationContext getCtx(){
        return CtxProvider.ctx;
        /*if (ctx == null){
            return null;
        }
        WebApplicationContext ctx1;
        if (ctx instanceof GenericWebApplicationContext){
            ctx1 = WebApplicationContextUtils.getRequiredWebApplicationContext(((GenericWebApplicationContext) ctx).getServletContext());
        }else if (ctx instanceof XmlWebApplicationContext){
            ctx1 = WebApplicationContextUtils.getRequiredWebApplicationContext(((XmlWebApplicationContext) ctx).getServletContext());
        }else{
            return ctx;
        }
        return ctx1;*/
    }

    /* 日志记录器 */
    protected static Logger logger = LoggerFactory.getLogger(CtxProvider.class);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CtxProvider.ctx = applicationContext;
    }

    /**
     * 从Spring容器中获取Bean，其类型为clazz。Spring容器中必须包含且只包含一个该类型的Bean，
     * <p/>
     * <p/>
     * 否则返回null
     *
     * @param clazz Bean的类型
     * @return Bean实例
     * @throws IllegalAccessException
     */
    public static <T> T getBeanByType(Class<T> clazz) {
        Assert.notNull(getCtx(), "必须在初始化Spring容器时设置好ApplicationContext");
        return getCtx().getBean(clazz);
    }

    public static <T> Map<String, T> getBeans(Class<T> clazz){
        return getCtx().getBeansOfType(clazz);
    }

    /**
     * 从Spring容器中获取Bean，其类型为clazz。Spring容器中必须至少包含一个该类型的Bean，
     * <p/>
     * <p/>
     * 否则返回null
     *
     * @param clazz Bean的类型
     * @return Bean实例
     * @throws IllegalAccessException
     */
    public static Object[] getBeansByType(Class clazz) {
        Assert.notNull(getCtx(), "必须在初始化Spring容器时设置好ApplicationContext");
        Map map = getCtx().getBeansOfType(clazz);
        if (map.size() >= 1) {
            return map.values().toArray();
        } else {
            logger.error("在Spring容器中没有类型为" + clazz.getName() + "的Bean");
            return null;
        }
    }

    /**
     * 从Spring容器中获取Bean
     *
     * @param beanName Bean的名称
     * @return Bean
     */
    public static Object getBeanByName(String beanName) {
        if (StringUtilsEx.isEmpty(beanName))
            return null;
        Assert.notNull(getCtx(), "必须在初始化Spring容器时设置好ApplicationContext");
        try {
            return getCtx().getBean(beanName);
        } catch (BeansException e) {
            return null;
        }
    }

    /**
     * 从Spring容器中获取Bean
     *
     * @param beanName Bean的名称
     * @return Bean
     */
    public static <T> T getBeanByName(String beanName, Class<T> clazz) {
        return (T) getBeanByName(beanName);
    }

    /**
     * 获取Spring容器的引用
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return ctx;
    }

    /**
     * 向应用程序上下文发布一个事件
     *
     * @param event
     */
    public static void publishEvent(ApplicationEvent event) {
        ctx.publishEvent(event);
    }
}