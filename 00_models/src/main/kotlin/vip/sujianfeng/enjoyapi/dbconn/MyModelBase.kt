package vip.sujianfeng.enjoyapi.dbconn


import vip.sujianfeng.utils.define.CallResult
import vip.sujianfeng.utils.comm.ConvertUtils
import vip.sujianfeng.utils.comm.StringUtilsEx
import com.alibaba.fastjson.JSON
import com.fasterxml.jackson.annotation.JsonIgnore
import io.swagger.annotations.ApiModelProperty
import vip.sujianfeng.enjoydao.enums.TbDefineFieldType
import vip.sujianfeng.enjoydao.interfaces.JdbcTbDao
import vip.sujianfeng.enjoydao.model.AbstractBizModel
import vip.sujianfeng.redis.TbRedisCache
import vip.sujianfeng.enjoydao.annotations.*
import vip.sujianfeng.enjoyapi.vo.op.OpLogVO
import vip.sujianfeng.enjoyapi.utils.CtxProvider
import vip.sujianfeng.enjoyapi.utils.UserUtils

open class MyModelBase : AbstractBizModel() {

    @ApiModelProperty("创建人员")
    @TbFieldUuid(tableField = "create_user_id", label = "创建人员")
    var createUserId: String? = null

    @ApiModelProperty("创建人员名称")
    @TbRelationField(joinTable = "rbac_user", joinTableAlias = "cu", joinCondition = "a.create_user_id = cu.id", srcField = "cu.name")
    var createUserName: String? = null

    @ApiModelProperty("修改人员")
    @TbFieldUuid(tableField = "update_user_id", label = "修改人员")
    var updateUserId: String? = null

    @ApiModelProperty("修改人员名称")
    @TbRelationField(joinTable = "rbac_user", joinTableAlias = "uu", joinCondition = "a.create_user_id = uu.id", srcField = "uu.name")
    var updateUserName: String? = null

    @ApiModelProperty("备注")
    @TbField(fieldType = TbDefineFieldType.ftText, tableField = "remark", label = "备注")
    var remark: String? = null

    @ApiModelProperty("业务类型（业务自定义）")
    @TbFieldInt(tableField = "biz_status", label = "业务类型：0-启用，1-禁用")
    var bizStatus: Int? = null

    override fun beforeInsert() {
        super.beforeInsert()
        val currUser = UserUtils.getCurrUser()
        if (currUser != null) {
            this.createUserId = currUser.id
            this.updateUserId = currUser.id
        }
        if (this.bizStatus == null) {
            this.bizStatus = 0
        }
    }

    override fun beforeUpdate() {
        super.beforeUpdate()
        val currUser = UserUtils.getCurrUser()
        if (currUser != null) {
            this.updateUserId = currUser.id
        }
    }


    override fun afterDelete() {
        super.afterDelete()
        if (this.needOpLog()){
            addOpLog(this.id, JSON.toJSONString(this), "删除-${this.modelTableName()}")
        }
    }

    override fun afterInsert() {
        super.afterInsert()
        if (this.needOpLog()){
            addOpLog(this.id, JSON.toJSONString(this), "新增-${this.modelTableName()}")
        }
    }

    override fun afterUpdate() {
        super.afterUpdate()
        if (this.needOpLog()){
            addOpLog(this.id, JSON.toJSONString(this), "修改-${this.modelTableName()}")
        }
    }

    @JsonIgnore
    fun modelTableName(): String {
        val tbTableUuid: TbTableUuid = this.javaClass.getAnnotation(TbTableUuid::class.java)
        return tbTableUuid.table
    }

    fun checkNotRepeat(jdbcTbDao: JdbcTbDao, fieldName: String, value: String?, msg: String) {
        checkNotRepeat(jdbcTbDao, modelTableName(), fieldName, value, msg);
    }

    fun checkNotRepeat(jdbcTbDao: JdbcTbDao, tableName: String, fieldName: String, value: String?, msg: String) {
        if (StringUtilsEx.isEmpty(value)) {
            return
        }
        val count = jdbcTbDao.selectOneBySql("select count(*) from $tableName where state = 0 and id != ? and $fieldName = ? ", this.id, value)
        require(ConvertUtils.cInt(count) == 0, msg);
    }

    protected open fun needOpLog(): Boolean {
        return false
    }

    companion object {
        private var _jdbcTbDao: MyJdbcDao? = null
        private var _tbRedisCache: TbRedisCache? = null

        fun require(conditon: Boolean, msg: String) {
            if (!conditon) {
                throw Exception(msg);
            }
        }

        fun require(op: CallResult<*>, conditon: Boolean, msg: String): Boolean {
            if (!conditon) {
                op.error(msg)
            }
            return op.isSuccess
        }

        fun tbRedisCache(): TbRedisCache {
            if (_tbRedisCache == null) {
                _tbRedisCache = CtxProvider.getBeanByType(TbRedisCache::class.java)
            }
            return _tbRedisCache!!
        }

        fun jdbcDao(): MyJdbcDao {
            if (_jdbcTbDao == null) {
                _jdbcTbDao = CtxProvider.getBeanByType(MyJdbcDao::class.java)
            }
            return _jdbcTbDao!!
        }

        fun addOpLog(bizId: String, bizData: String, content: String) {
            val jdbcTbDao = CtxProvider.getBeanByType(MyJdbcDao::class.java)
            jdbcTbDao.insert(OpLogVO().apply {
                this.userId = UserUtils.getCurrUserId()
                this.bizId = bizId
                this.bizData = bizData
                this.content = content
            })
        }
    }



}