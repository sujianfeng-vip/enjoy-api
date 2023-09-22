package vip.sujianfeng.admin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vip.sujianfeng.datasource.DruidConfig;
import vip.sujianfeng.datasource.DruidUtils;
import vip.sujianfeng.admin.dbconn.MyJdbcDao;

/**
 * @author SuJianFeng
 * @date 2022/3/19 8:53
 */
@Configuration
public class DbConnConfig {


    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidConfig druidConfig() {
        return new DruidConfig();
    }

    @Bean
    public MyJdbcDao jdbcTbDao() throws Exception {
        DruidConfig druidConfig = druidConfig();
        return new MyJdbcDao(DruidUtils.getDruidDataSource(druidConfig), druidConfig.getDatabase());
    }

}
