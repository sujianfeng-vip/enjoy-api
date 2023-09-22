/*
Navicat MySQL Data Transfer

Source Server         : 乐享后台
Source Server Version : 80028
Source Host           : 127.0.0.1:3306
Source Database       : enjoy_admin

Target Server Type    : MYSQL
Target Server Version : 80028
File Encoding         : 65001

Date: 2023-09-09 21:05:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `op_log`
-- ----------------------------
DROP TABLE IF EXISTS `op_log`;
CREATE TABLE `op_log` (
  `id` varchar(50) NOT NULL,
  `user_id` varchar(50) DEFAULT NULL COMMENT '操作用户id',
  `biz_id` varchar(50) DEFAULT NULL COMMENT '业务单据id',
  `biz_data` longtext COMMENT '业务单据数据',
  `content` varchar(100) DEFAULT NULL COMMENT '操作内容',
  `biz_status` int DEFAULT NULL COMMENT '业务类型：0-启用，1-禁用',
  `create_time` bigint DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint DEFAULT NULL COMMENT '最后修改时间',
  `state` int DEFAULT NULL COMMENT '数据状态：0-正常，1-删除',
  `remark` text,
  `create_user_id` varchar(50) DEFAULT NULL,
  `update_user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='操作日志'; 

-- ----------------------------
-- Table structure for `rbac_menu`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_menu`;
CREATE TABLE `rbac_menu` (
  `id` varchar(50) NOT NULL,
  `system_id` varchar(50) DEFAULT NULL COMMENT '系统ID',
  `parent_id` varchar(50) DEFAULT NULL COMMENT '上级菜单',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `permission_id` varchar(50) DEFAULT NULL COMMENT '绑定权限',
  `url` varchar(500) DEFAULT '' COMMENT 'URL',
  `sort_no` int DEFAULT NULL COMMENT '排序号',
  `window_type` int DEFAULT '0' COMMENT '窗口显示类型：0-子页面，1-新页面，2-对话框',
  `biz_status` int DEFAULT NULL COMMENT '业务类型：0-启用，1-禁用',
  `create_time` bigint DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint DEFAULT NULL COMMENT '最后修改时间',
  `state` int DEFAULT NULL COMMENT '数据状态：0-正常，1-删除',
  `remark` text,
  `create_user_id` varchar(50) DEFAULT NULL,
  `update_user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单定义';

-- ----------------------------
-- Records of rbac_menu
-- ----------------------------

INSERT INTO `rbac_menu` VALUES ('0178FD8D949F6972867A2CE7DF684B1A', 'SYS_ADMIN', null, '基础数据', null, '', '18', '0', '1', '1688010023', '1688437775', '0', null, '192B7C741E2EF4CD6A4E7B7FEBF3F7A8', '192B7C741E2EF4CD6A4E7B7FEBF3F7A8');
INSERT INTO `rbac_menu` VALUES ('02', 'SYS_ADMIN', null, '基础配置', null, '', '60', '0', '0', '0', '1689684893', '0', null, null, '192B7C741E2EF4CD6A4E7B7FEBF3F7A8');
INSERT INTO `rbac_menu` VALUES ('0201', 'SYS_ADMIN', '03', '用户定义', null, '/rbac/user/list', '0', '0', '0', '0', '1687486667', '0', null, null, '192B7C741E2EF4CD6A4E7B7FEBF3F7A8');
INSERT INTO `rbac_menu` VALUES ('03', 'SYS_ADMIN', null, '系统管理', null, '', '70', '0', '0', '0', '1687320256', '0', null, null, '192B7C741E2EF4CD6A4E7B7FEBF3F7A8');
INSERT INTO `rbac_menu` VALUES ('0301', 'SYS_ADMIN', '03', '系统定义', null, '/rbac/system/list', '0', '0', '0', '0', '0', '0', null, null, null);
INSERT INTO `rbac_menu` VALUES ('0302', 'SYS_ADMIN', '03', '角色定义', null, '/rbac/role/list', '0', '0', '0', '0', '0', '0', null, null, null);
INSERT INTO `rbac_menu` VALUES ('0303', 'SYS_ADMIN', '03', '权限定义', null, '/rbac/permission/list', '0', '0', '0', '0', '0', '0', null, null, null);
INSERT INTO `rbac_menu` VALUES ('0304', 'SYS_ADMIN', '03', '菜单定义', null, '/rbac/menu/list', '0', '0', '0', '0', '0', '0', null, null, null);
INSERT INTO `rbac_menu` VALUES ('0305', 'SYS_ADMIN', '03', '操作日志', null, '/module/op-log/list', '0', '0', '0', '0', '1654440931', '0', null, null, '192B7C741E2EF4CD6A4E7B7FEBF3F7A8');
INSERT INTO `rbac_menu` VALUES ('06', 'SYS_ADMIN', null, '个人中心', null, '', '100', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `rbac_menu` VALUES ('0601', 'SYS_ADMIN', '06', '个人资料', null, '/rbac/user-info/edit', '0', '2', '0', '0', '0', '1', null, null, null);
INSERT INTO `rbac_menu` VALUES ('0602', 'SYS_ADMIN', '06', '密码修改', null, '/rbac/user-password/edit', '0', '2', '0', '0', '0', '1', null, null, null);

-- ----------------------------
-- Table structure for `rbac_permission`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_permission`;
CREATE TABLE `rbac_permission` (
  `id` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `parent_id` varchar(100) DEFAULT NULL COMMENT '上级ID',
  `system_id` varchar(50) DEFAULT NULL COMMENT '系统ID',
  `type` int DEFAULT NULL COMMENT '权限类型',
  `sort_no` int DEFAULT '0' COMMENT '排序号',
  `biz_status` int DEFAULT NULL COMMENT '业务类型：0-启用，1-禁用',
  `create_time` bigint DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint DEFAULT NULL COMMENT '最后修改时间',
  `state` int DEFAULT NULL COMMENT '数据状态：0-正常，1-删除',
  `remark` text,
  `create_user_id` varchar(50) DEFAULT NULL,
  `update_user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限定义';

-- ----------------------------
-- Records of rbac_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `rbac_role`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_role`;
CREATE TABLE `rbac_role` (
  `id` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `remark` text COMMENT '备注',
  `system_id` varchar(50) DEFAULT NULL COMMENT '系统ID',
  `biz_status` int DEFAULT NULL COMMENT '业务类型：0-启用，1-禁用',
  `create_time` bigint DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint DEFAULT NULL COMMENT '最后修改时间',
  `state` int DEFAULT NULL COMMENT '数据状态：0-正常，1-删除',
  `create_user_id` varchar(50) DEFAULT NULL,
  `update_user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色定义';

-- ----------------------------
-- Records of rbac_role
-- ----------------------------
INSERT INTO `rbac_role` VALUES ('157D2496A16AB265A33EE855059A9CAE', '信息管理专员', null, 'SYS_ADMIN', '0', '1689923514', '1689923514', '1', '192B7C741E2EF4CD6A4E7B7FEBF3F7A8', '192B7C741E2EF4CD6A4E7B7FEBF3F7A8');
INSERT INTO `rbac_role` VALUES ('1A2B8667FEA2FD7CA1795130D979F289', '系统运营专员', null, 'SYS_ADMIN', '0', '1688009629', '1688009629', '1', '192B7C741E2EF4CD6A4E7B7FEBF3F7A8', '192B7C741E2EF4CD6A4E7B7FEBF3F7A8');
INSERT INTO `rbac_role` VALUES ('6607316B669515DE505C15128E60DD24', '财务人员', null, 'SYS_ADMIN', '0', '1688009602', '1688009602', '1', '192B7C741E2EF4CD6A4E7B7FEBF3F7A8', '192B7C741E2EF4CD6A4E7B7FEBF3F7A8');

-- ----------------------------
-- Table structure for `rbac_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_role_permission`;
CREATE TABLE `rbac_role_permission` (
  `id` varchar(50) NOT NULL,
  `role_id` varchar(50) DEFAULT NULL COMMENT '角色id',
  `system_id` varchar(50) DEFAULT NULL COMMENT '系统ID',
  `permission_id` varchar(50) DEFAULT NULL COMMENT '权限id',
  `allow` int DEFAULT NULL COMMENT '是否分配：0-否，1-是',
  `biz_status` int DEFAULT NULL COMMENT '业务类型：0-启用，1-禁用',
  `create_time` bigint DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint DEFAULT NULL COMMENT '最后修改时间',
  `state` int DEFAULT NULL COMMENT '数据状态：0-正常，1-删除',
  `remark` text,
  `create_user_id` varchar(50) DEFAULT NULL,
  `update_user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色权限';

-- ----------------------------
-- Table structure for `rbac_role_user`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_role_user`;
CREATE TABLE `rbac_role_user` (
  `id` varchar(50) NOT NULL,
  `role_id` varchar(50) DEFAULT NULL COMMENT '角色id',
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户id',
  `system_id` varchar(50) DEFAULT NULL COMMENT '系统ID',
  `allow` int DEFAULT '0' COMMENT '是否分配：0-否，1-是',
  `biz_status` int DEFAULT NULL COMMENT '业务类型：0-启用，1-禁用',
  `create_time` bigint DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint DEFAULT NULL COMMENT '最后修改时间',
  `state` int DEFAULT NULL COMMENT '数据状态：0-正常，1-删除',
  `remark` text,
  `create_user_id` varchar(50) DEFAULT NULL,
  `update_user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色用户'; 

-- ----------------------------
-- Table structure for `rbac_system`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_system`;
CREATE TABLE `rbac_system` (
  `id` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `sort_no` int DEFAULT '0' COMMENT '排序号',
  `remark` text COMMENT '备注',
  `create_user_id` varchar(50) DEFAULT NULL,
  `update_user_id` varchar(50) DEFAULT NULL,
  `biz_status` int DEFAULT NULL COMMENT '业务类型：0-启用，1-禁用',
  `create_time` bigint DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint DEFAULT NULL COMMENT '最后修改时间',
  `state` int DEFAULT NULL COMMENT '数据状态：0-正常，1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统定义';

-- ----------------------------
-- Records of rbac_system
-- ----------------------------
INSERT INTO `rbac_system` VALUES ('SYS_ADMIN', '后台管理', '1', '', '192B7C741E2EF4CD6A4E7B7FEBF3F7A8', '192B7C741E2EF4CD6A4E7B7FEBF3F7A8', '0', '1654666576', '1690850531', '0');
INSERT INTO `rbac_system` VALUES ('SYS_NEW', '新建模块', '2', null, '192B7C741E2EF4CD6A4E7B7FEBF3F7A8', '192B7C741E2EF4CD6A4E7B7FEBF3F7A8', '0', '1690850515', '1690850515', '0');

-- ----------------------------
-- Table structure for `rbac_user`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user`;
CREATE TABLE `rbac_user` (
  `id` varchar(50) NOT NULL,
  `user_type` int DEFAULT NULL COMMENT '0-游客，1-普通用户, 99-管理员',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `system_id` varchar(50) DEFAULT NULL COMMENT '系统ID',
  `open_id` varchar(50) DEFAULT NULL COMMENT '微信openId',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录名称',
  `avatar_url` varchar(500) DEFAULT NULL COMMENT '头像URL',
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '手机',
  `password` varchar(50) DEFAULT '' COMMENT '登录密码',
  `biz_status` int DEFAULT NULL COMMENT '业务类型：0-启用，1-禁用',
  `theme` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '界面主题',
  `create_time` bigint DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint DEFAULT NULL COMMENT '最后修改时间',
  `state` int DEFAULT NULL COMMENT '数据状态：0-正常，1-删除',
  `remark` text COMMENT '备注',
  `create_user_id` varchar(50) DEFAULT NULL,
  `update_user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户';

-- ----------------------------
-- Records of rbac_user
-- ----------------------------
INSERT INTO `rbac_user` VALUES ('192B7C741E2EF4CD6A4E7B7FEBF3F7A8', '99', '管理员', 'AUTO_REPORT', 'odJVz5b425lAKvC9B3L-Aq8SDpGY', 'admin', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLpnUF16DqydlzVAcCktEquqGSpJVOlscXFvhSEAdm2QHJRlia6aB7Jwgo6chOCdkvyiawlBxdAN08A/132', null, '123456', '0', 'light-css', '1653788938', '1693894707', '0', null, null, null);

-- ----------------------------
-- Table structure for `ws_login_session`
-- ----------------------------
DROP TABLE IF EXISTS `ws_login_session`;
CREATE TABLE `ws_login_session` (
  `id` varchar(50) NOT NULL,
  `channel_id` varchar(50) DEFAULT NULL COMMENT 'ws通讯通道id',
  `qr_code` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '浜岀淮鐮佹暟鎹?',
  `telephone` varchar(50) DEFAULT NULL COMMENT '手机号',
  `biz_status` int DEFAULT NULL COMMENT '业务类型：0-启用，1-禁用',
  `create_time` bigint DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint DEFAULT NULL COMMENT '最后修改时间',
  `state` int DEFAULT NULL COMMENT '数据状态：0-正常，1-删除',
  `remark` text,
  `create_user_id` varchar(50) DEFAULT NULL,
  `update_user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='微信登录会话';

-- ----------------------------
-- Records of ws_login_session
-- ----------------------------
