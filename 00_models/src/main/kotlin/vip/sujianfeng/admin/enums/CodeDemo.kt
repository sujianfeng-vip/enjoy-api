package vip.sujianfeng.admin.enums

/**
 * 代码案例，帮助用户新建报表定义时，引导用户使用方式
 * @Author SuJianFeng
 * @Date 2023/6/28
 * @Description
 **/
enum class CodeDemo(var content: String) {
    BuildDataset("""
/**
 * 通过js创建自定义二维表数据集
 * params: {pageNo, pageSize, extendParams}
 **/
function buildDataset(params) {
    var rows = [];    
    return rows;
}

/**
 * 数据加载后触发
 * dataset: 行数据
 **/
function afterLoadData(rows) {

}

    """.trimIndent()),

    ConditoinHtml("""
<form-item>
 <i-input v-model="keyword" placeholder="请输入查询关键字..." style="width: 200px"/>
</form-item>                
    """.trimIndent()),

    FieldsJs("""
//如果清空这里代码或者columns赋值为空数组，系统将根据查询结构自动创建        
store.columns = [
    {"title": "字段1", "key": "field1"},
    {"title": "字段2", "key": "field2"}
]                
    """.trimIndent()),

    FrontJs("""        
//store存储vue数据对象
store.xxx = 123

//数据加载前处理逻辑--主要是用于准备组合查询条件给后端
window.beforeLoadPage = function(param) {
   
}

//数据加载后处理逻辑--主要用于数据从后端取回后的二次加工
window.afterLoadPage = function(rows) {
   
}                
    """.trimIndent()),

    BackJs("""
        
//自定义视图参数数据
function buildViewParams(viewParams) {    
    //var dbApi = dbMng.getDbApi("F2A05EA24074E8ABF4ED4A719A8795F2")    
    //viewParams.test1 = dbApi.queryValue("select 1 + {p1}", {p1: 3})
}   
        
//组合自定义SQL条件,extendParams: 固定sqlCondition参数、其它自定义参数
//使用案例： extendParams.sqlCondition = " and fieldxxx = {xxxValue}"; extendParams.xxxValue = "aaa"
function buildSqlCondition(extendParams) {    

}               
    """.trimIndent()),

    MergeFieldJson("""
[
    {
        "srcField": "来源值字段",
        "destField": "赋值目标字段",
        "mergeType": "Sync"
    }

]                
    """.trimIndent()),

    AutoPageMainHtml("""
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>页面标题</title>        
    <!-- 页面head部分内容 -->
    <partHtml>head-part</partHtml>
</head>
<body>

<div id="app">
    
</div>

</body>
</html>               
    """.trimIndent()),

    RowMergeJs ("""
//拦截行合并，可以业务逻辑，将子数据行（subRow）的数据转换写入主数据行（mainRow）        
function rowMerge(mainRow, subRow) {
}        
    """.trimIndent()),

    ApiJs ("""

//api接口演示函数        
function apiFunc1(param) {
  return {
      name: "张三"
  }
}        
        
    """.trimIndent())
}