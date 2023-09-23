# enjoy-api
    【乐享后端】一款开箱即用的开源后端接口基础框架
    如果你是一名程序员，使用该基础框架，能让你工作效率提高百倍，特别是它能让你1分钟搭建一个包含登录、权限、菜单管理等基础功能的后端api工程；
    （1）集成了基于redis的jwt鉴权机制；
    （2）集成了高效简便的enjoy-dao数据库操作框架；
    （3）集成了基于rbac的权限管理整套api接口，包含用户、角色、权限、用户角色分配、角色权限分配、菜单管理；
    （4）集成了swagger接口文档；
    （5）集成了代码生成器（tools/enjoy-dao-ui.bat），一键生成单个模块的后端api代码；
# 1. 项目环境
    JDK 1.8 +
    Gradle 7.0 +
    MySql 8.0 +
    建议使用IDE：IntelliJ IDEA
# 2. 项目初始化
    下载代码
    （1）git clone https://github.com/sujianfeng-vip/enjoy-api.git
    （2）git clone https://gitee.com/sujianfeng/enjoy-api.git
## （1）数据库初始化
    创建数据库，并运行 doc/mysql_db_init.sql
## （2）配置文件 
    配置文件：    
    80_web/src/main/resources/application-dev.yml （开发环境）
    80_web/src/main/resources/application-test.yml （测试环境）
    80_web/src/main/resources/application-prod.yml （生产环境）
## （3）数据库配置
    配置文件中，注意有两处不要遗漏了database的数据库名称修改（此文档是enjoy_api为例）
    spring: 
      datasource:
        url: jdbc:mysql://127.0.0.1:3306/enjoy_api?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false
        username: root
        password: 960720
        database: enjoy_api
## （4）配置缓存库
    spring:
      redis:
        database: 12
        host: 127.0.0.1
        port: 6379
# 3. 项目启动
## (1) 项目编译打包
    gradle build -x test
## (2) 项目启动
    开发环境启动
    java -jar ./output/jars/80_web-1.0.0-SNAPSHOT.jar --spring.profiles.active=dev
## (3) 查看接口文档
    http://127.0.0.1:8080/doc.html
# 4. 开发新功能接口案例
## (1) 案例描述
    我们以开发一个【课程定义】模块，包含课程的增删改查等接口api
## (2) 创建表结构SQL
    -- ----------------------------
    -- Table structure for `demo_course`
    -- 约定：id、biz_status、create_time、update_time、state、remark、create_user_id、update_user_id是所有表固定有的字段
    -- ----------------------------
    DROP TABLE IF EXISTS `demo_course`;
    CREATE TABLE `demo_course` (
    `id` varchar(50) NOT NULL,
    `code` varchar(50) DEFAULT NULL COMMENT '课程编号',
    `name` varchar(50) DEFAULT NULL COMMENT '课程名称',  
    `biz_status` int DEFAULT NULL COMMENT '业务类型：0-启用，1-禁用',
    `create_time` bigint DEFAULT NULL COMMENT '创建时间',
    `update_time` bigint DEFAULT NULL COMMENT '最后修改时间',
    `state` int DEFAULT NULL COMMENT '数据状态：0-正常，1-删除',
    `remark` text,
    `create_user_id` varchar(50) DEFAULT NULL,
    `update_user_id` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='课程定义';
![创建课程表](https://hougu-erp2.oss-cn-shanghai.aliyuncs.com/enjoy-api/create-table.jpg)
## (3) 配置代码生成工具的数据库链接
    注意：有两处数据库名称（此文档是enjoy_api为例）需要修改
![代码生成工具的数据库链接](https://hougu-erp2.oss-cn-shanghai.aliyuncs.com/enjoy-api/tools-db.jpg)
## (4) 启动代码生成工具
    进入项目中的tools目录，windows运行enjoy-dao-ui.bat，liunx或mac运行enjoy-dao-ui.sh
![启动代码生成工具](https://hougu-erp2.oss-cn-shanghai.aliyuncs.com/enjoy-api/start-code-tools.jpg)    
## (5) 代码生成工具启动时自动创建表对应的实体模型
![创建表对应的实体模型文件](https://hougu-erp2.oss-cn-shanghai.aliyuncs.com/enjoy-api/model-code-file.jpg)
## (6) 【课程定义】模型代码
![模型代码](https://hougu-erp2.oss-cn-shanghai.aliyuncs.com/enjoy-api/model-code-class.jpg)
## (7) 代码生成工具生成【课程定义】的后端接口api代码
![生成后端代码](https://hougu-erp2.oss-cn-shanghai.aliyuncs.com/enjoy-api/build-back-code.jpg)
![生成后端代码](https://hougu-erp2.oss-cn-shanghai.aliyuncs.com/enjoy-api/demo-back-code.jpg)
## (8) 项目打包
    gradle build -x test
## (9) 启动项目，查看下接口文档
    运行 start-dev.bat
    http://127.0.0.1:8080/doc.html
![生成后端代码](https://hougu-erp2.oss-cn-shanghai.aliyuncs.com/enjoy-api/course-api-docs.jpg)    