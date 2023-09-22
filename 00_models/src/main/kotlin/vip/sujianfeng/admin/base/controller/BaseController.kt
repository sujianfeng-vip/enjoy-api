package vip.sujianfeng.admin.base.controller

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import vip.sujianfeng.redis.TbRedisCache
import vip.sujianfeng.enjoydao.handler.intf.MasterDoAction
import vip.sujianfeng.enjoydao.interfaces.JdbcTbDao
import vip.sujianfeng.enums.EnvType
import vip.sujianfeng.admin.dbconn.MyModelBase
import vip.sujianfeng.admin.dbconn.MyJdbcDao
import vip.sujianfeng.admin.utils.UserUtils
import vip.sujianfeng.utils.define.CallResult

open class BaseController {

    @Value("\${spring.profiles.active:dev}")
    var profile: String?= null

    fun currEnv(): EnvType {
        return EnvType.valueOfProfile(this.profile);
    }

    fun addOpLog(bizId: String, bizData: String, content: String) {
        MyModelBase.addOpLog(bizId, bizData, content)
    }

    fun currTime(): Long {
        return System.currentTimeMillis() / 1000;
    }
    fun require(condition: Boolean, msg: String) {
        if (!condition){
            throw Exception(msg)
        }
    }

    fun require(op: CallResult<*>, condition: Boolean, msg: String): Boolean {
        if (!condition) {
            op.error(msg)
        }
        return op.isSuccess
    }

    fun tbRedisCache(): TbRedisCache {
        return MyModelBase.tbRedisCache()
    }

    fun currUserId(): String {
        return UserUtils.getCurrUserId()
    }

    fun jdbcTbDao(): MyJdbcDao {
        return MyModelBase.jdbcDao()
    }

    open fun <K> proc(jdbcDao: JdbcTbDao, action: MasterDoAction<K>): CallResult<K> {
        return CallResult.opCall { jdbcDao.doTrans {
            action.proc(it)
            true
        } }
    }

    companion object {

    }

    val logger = LoggerFactory.getLogger(this.javaClass)
}