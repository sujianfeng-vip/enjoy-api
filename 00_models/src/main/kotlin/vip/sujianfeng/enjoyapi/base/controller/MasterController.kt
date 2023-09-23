package vip.sujianfeng.enjoyapi.base.controller

import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import vip.sujianfeng.enjoydao.handler.MasterDataHandler
import vip.sujianfeng.enjoydao.handler.consts.MasterConst
import vip.sujianfeng.enjoydao.handler.intf.MasterEvent
import vip.sujianfeng.enjoydao.handler.model.BatchUpdateFieldParam
import vip.sujianfeng.enjoydao.handler.model.ManyIdParam
import vip.sujianfeng.enjoydao.handler.model.OneIdParam
import vip.sujianfeng.enjoydao.handler.model.PageParam
import vip.sujianfeng.enjoydao.interfaces.JdbcTbDao
import vip.sujianfeng.enjoydao.sqlbuilder.TbPageRows
import vip.sujianfeng.enjoydao.utils.TypeMapUtils
import vip.sujianfeng.enjoyapi.dbconn.MyModelBase
import vip.sujianfeng.utils.define.CallResult
import java.lang.reflect.ParameterizedType

/**
 * 主数据增删改查基类
 */
abstract class MasterController<T: MyModelBase, P: PageParam>: MasterEvent<T, P>, BaseController() {

    var handler: MasterDataHandler<T, P>? = null

    private fun masterHandler(): MasterDataHandler<T, P> {
        if (handler == null) {
            handler = MasterDataHandler<T, P>(modelClass(), this)
        }
        return handler!!
    }

    init {
        val genType = javaClass.genericSuperclass
        val params = (genType as ParameterizedType).actualTypeArguments
        TypeMapUtils.add(this, "T", params[0])
        TypeMapUtils.add(this, "P", params[1])
    }

    fun modelClass(): Class<T> {
        return TypeMapUtils.get(this, "T") as Class<T>
    }

    fun pageParamClass(): Class<P> {
        return TypeMapUtils.get(this, "P") as Class<P>
    }

    @ApiOperation(MasterConst.REST_MAP_SAVE_NAME)
    @PostMapping(MasterConst.REST_MAP_SAVE_URI)
    fun save(@RequestBody item: T): CallResult<T> { return this.masterHandler().save(jdbcTbDao(), item) }

    @ApiOperation(MasterConst.REST_MAP_ADD_NAME)
    @PostMapping(MasterConst.REST_MAP_ADD_URI)
    fun add(@RequestBody item: T): CallResult<T> { return this.masterHandler().add(jdbcTbDao(), item) }

    @ApiOperation(MasterConst.REST_MAP_UPDATE_NAME)
    @PostMapping(MasterConst.REST_MAP_UPDATE_URI)
    fun update(@RequestBody item: T): CallResult<T> { return this.masterHandler().update(jdbcTbDao(), item) }

    @ApiOperation(MasterConst.REST_MAP_DELETE_NAME)
    @PostMapping(MasterConst.REST_MAP_DELETE_URI)
    fun delete(@RequestBody param: ManyIdParam): CallResult<Int> { return this.masterHandler().delete(jdbcTbDao(), param) }

    @ApiOperation(MasterConst.REST_MAP_QUERY_ONE_NAME)
    @PostMapping(MasterConst.REST_MAP_QUERY_ONE_URI)
    fun queryOne(@RequestBody param: OneIdParam): CallResult<T> { return this.masterHandler().queryOne(jdbcTbDao(), param) }

    @ApiOperation(MasterConst.REST_MAP_QUERY_PAGE_NAME)
    @PostMapping(MasterConst.REST_MAP_QUERY_PAGE_URI)
    fun queryPage(@RequestBody param: P): CallResult<TbPageRows<T>> { return this.masterHandler().queryPage(jdbcTbDao(), param) }

    @ApiOperation(MasterConst.REST_MAP_BATCH_UPDATE_NAME)
    @PostMapping(MasterConst.REST_MAP_BATCH_UPDATE_URI)
    fun batchUpdateField(@RequestBody param: BatchUpdateFieldParam): CallResult<Int> {
        return this.masterHandler().batchUpdateField(jdbcTbDao(), param);
    }

    override fun beforeAdd(op: CallResult<*>, jdbcDao: JdbcTbDao, item: T) {

    }

    override fun afterAdd(op: CallResult<*>, jdbcDao: JdbcTbDao, item: T) {

    }

    override fun beforeUpdate(op: CallResult<*>, jdbcDao: JdbcTbDao, item: T) {

    }

    override fun afterUpdate(op: CallResult<*>, jdbcDao: JdbcTbDao, item: T) {

    }

    override fun afterQueryOne(op: CallResult<*>, jdbcDao: JdbcTbDao, item: T) {

    }

    override fun beforeQueryPage(op: CallResult<*>, jdbcDao: JdbcTbDao, param: P) {

    }

    override fun afterQueryPage(op: CallResult<*>, jdbcDao: JdbcTbDao, param: P, pageRows: TbPageRows<T>) {

    }

    override fun beforeDelete(
        op: CallResult<*>,
        jdbcDao: JdbcTbDao,
        manyIdParam: ManyIdParam,
        rows: MutableList<T>
    ) {

    }

    override fun afterDelete(
        op: CallResult<*>,
        jdbcDao: JdbcTbDao,
        manyIdParam: ManyIdParam,
        rows: MutableList<T>
    ) {

    }
}