# enjoy-admin
【乐享后台】一款开箱即用的开源后台管理系统
#1. 项目环境
    JDK 1.8 +
    Gradle 7.0 +
    MySql 8.0 +
#2. 项目初始化
##（1）数据库初始化
    运行 doc/mysql_db_init.sql
##（2）配置文件 
    配置文件：    
    80_web/src/main/resources/application-dev.yml （开发环境）
    80_web/src/main/resources/application-test.yml （测试环境）
    80_web/src/main/resources/application-prod.yml （生产环境）
##（3）数据库配置
    配置文件中：
    spring: 
      datasource:
        url: jdbc:mysql://127.0.0.1:3306/enjoy_admin?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false
        username: root
        password: 960720
        database: enjoy_admin
##（4）配置缓存库
    spring:
      redis:
        database: 12
        host: 127.0.0.1
        port: 6379
#3. 项目编译打包
    gradle build -x test
#4. 项目启动
    开发环境启动
    java -jar ./output/jars/80_web-1.0.0-SNAPSHOT.jar --spring.profiles.active=dev
#5. 浏览器打开
    http://127.0.0.1:38181
