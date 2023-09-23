package vip.sujianfeng.enjoyapi.config;

import vip.sujianfeng.utils.comm.ConfigUtils;
import org.springframework.context.annotation.Configuration;

/**
 * @author SuJianFeng
 * @date 2022/3/19 9:00
 */
@Configuration
public class CommConfig {


    public boolean isTest() {
        return !"prod".equalsIgnoreCase(ConfigUtils.getProfile());
    }
}
