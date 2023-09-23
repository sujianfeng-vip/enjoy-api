package vip.sujianfeng.enjoyapi.config;


import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;
import vip.sujianfeng.redis.TbRedisCache;
import vip.sujianfeng.redis.TbRedisConfig;
import vip.sujianfeng.utils.cache.DataCacheHandler;

/**
 * @author SuJianFeng
 * @date 2020/6/24 11:05
 **/
@Configuration
public class TbRedisService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Bean
    @ConfigurationProperties("spring.redis")
    public TbRedisConfig tbRedisConfig(){
        return new TbRedisConfig();
    }

    @Autowired
    private TbRedisConfig redisConfig;

    @Bean
    public TbRedisCache tbRedisCache(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(2000);
        logger.info("redis config-> {}", JSON.toJSONString(redisConfig));
        TbRedisCache result = new TbRedisCache(redisConfig, jedisPoolConfig);
        try{
            result.getObj("aaa", String.class);
            logger.info("redis连接成功!");
        }catch (Exception e){
            logger.error("redis连接失败!", e);
        }
        return result;
    }

    @Autowired
    private TbRedisCache tbRedisCache;

    @Bean
    public DataCacheHandler defaultDataCacheHandler(){
        return new DataCacheHandler(tbRedisCache);
    }
}
