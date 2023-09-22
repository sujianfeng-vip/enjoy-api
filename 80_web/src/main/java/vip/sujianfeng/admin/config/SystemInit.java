package vip.sujianfeng.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author SuJianFeng
 * @date 2022/5/11
 * @Description
 */
@Component
@Order(1)
public class SystemInit implements CommandLineRunner, EnvironmentAware {
    @Autowired
    private MyRbacHandler myRbacHandler;

    @Override
    public void run(String... args) throws Exception {
        //启动系统自动刷新缓存
        myRbacHandler.clearCache();
    }

    @Override
    public void setEnvironment(Environment environment) {

    }
}
