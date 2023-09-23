package vip.sujianfeng.enjoyapi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vip.sujianfeng.enjoyapi.base.controller.BaseController;
import vip.sujianfeng.enjoyapi.vo.rbac.*;
import vip.sujianfeng.rbac.intf.IDataLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author SuJianFeng
 * @Date 2022/5/9
 * @Description
 **/
@Configuration
public class MyRbacConfig extends BaseController {

    @Bean
    public MyRbacHandler myRbacHander() {
        return new MyRbacHandler(new IDataLoader<RbacUserVO, RbacRoleVO, RbacPermissionVO, RbacRoleUserVO, RbacRolePermissionVO, RbacMenuVO>() {
            @Override
            public void putCache(String key, String value) {
                tbRedisCache().addCache(key, value);
            }

            @Override
            public String getCache(String key) {
                return tbRedisCache().getObj(key, String.class);
            }

            @Override
            public void clearCache(String key) {
                tbRedisCache().removeCache(key);
            }

            @Override
            public List<RbacUserVO> loadUsers() {
                return loadRows(RbacUserVO.class, "", "");
            }

            @Override
            public List<RbacRoleVO> loadRoles() {
                return loadRows(RbacRoleVO.class, " and a.biz_status = 0", "");
            }

            @Override
            public List<RbacPermissionVO> loadPermissions() {
                return loadRows(RbacPermissionVO.class, " and a.biz_status = 0 ", "");
            }

            @Override
            public List<RbacRoleUserVO> loadRoleUsers() {
                return loadRows(RbacRoleUserVO.class, " and a.allow = 1", "");
            }

            @Override
            public List<RbacRolePermissionVO> loadRolePermissions() {
                return loadRows(RbacRolePermissionVO.class, " and a.allow = 1", "");
            }

            @Override
            public List<RbacMenuVO> loadMenus() {
                return loadRows(RbacMenuVO.class, " and a.biz_status = 0 ", "a.sort_no");
            }

            public <T> List<T> loadRows(Class<T> t, String condition, String orderBy) {
                try {
                    return jdbcTbDao().selectList(t, String.format(" and a.state = 0 %s", condition), 1, 10000, orderBy);
                } catch (Exception e) {
                    logger.error(e.toString(), e);
                }
                return new ArrayList<>();
            }
        });
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());
}
