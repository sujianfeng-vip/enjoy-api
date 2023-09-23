package vip.sujianfeng.enjoyapi.config;

import vip.sujianfeng.enjoyapi.vo.rbac.*;
import vip.sujianfeng.rbac.RbacHandler;
import vip.sujianfeng.rbac.intf.IDataLoader;

/**
 * @Author SuJianFeng
 * @Date 2022/5/9
 * @Description
 **/
public class MyRbacHandler extends RbacHandler<RbacUserVO, RbacRoleVO, RbacPermissionVO, RbacRoleUserVO, RbacRolePermissionVO, RbacMenuVO> {

    public MyRbacHandler(IDataLoader<RbacUserVO, RbacRoleVO, RbacPermissionVO, RbacRoleUserVO, RbacRolePermissionVO, RbacMenuVO> dataLoader) {
        super(RbacUserVO.class, RbacRoleVO.class, RbacPermissionVO.class, RbacRoleUserVO.class, RbacRolePermissionVO.class, RbacMenuVO.class, dataLoader);
    }
}
