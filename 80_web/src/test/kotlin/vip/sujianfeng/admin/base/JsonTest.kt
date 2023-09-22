package vip.sujianfeng.admin.base

import com.alibaba.fastjson.JSON
import org.junit.Test
import vip.sujianfeng.utils.dataset.MergeFieldDefine


/**
 * @Author SuJianFeng
 * @Date 2023/6/28
 * @Description
 **/
class JsonTest {

    @Test
    fun test() {
        val json = """
            [
                {
                    "srcField": "收款金额",
                    "destField": "allReceiveAmount",
                    "mergeType": "Sync"
                }
            ]                        
        """.trimIndent()
        val mergeFields = JSON.parseArray(json, MergeFieldDefine::class.java)
        println(mergeFields)
    }
}