package vip.sujianfeng.admin.dbconn

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import vip.sujianfeng.enjoydao.MySqlEnjoyDao
import javax.sql.DataSource

class MyJdbcDao(dataSource: DataSource, dbName: String): MySqlEnjoyDao(dataSource, dbName) {

    companion object {
        //const val CURR_USER_PARAM_KEY = "{currUserId}"
        val logger: Logger = LoggerFactory.getLogger(MyJdbcDao::class.java)
    }


    override fun changeSql(sql: String?, params: MutableList<Any>?): String? {
        //var currUserId = TrmBase.currUser().id
        // currUserId = "C18F4C3807F6CCC29C120BFAB7904A76"
        //替换sql中当前用户占位符
        /*val result = sql.replace(CURR_USER_PARAM_KEY, "'$currUserId'", true)
        if (!"prod".equals(ConfigUtils.getProfile(), ignoreCase = true)) {
            logger.info("sql => {}", result)
        }*/
        return sql
    }
}