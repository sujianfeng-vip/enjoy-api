package vip.sujianfeng.admin.enums

/**
 * 代码块类型
 * @Author SuJianFeng
 * @Date 2022/6/6
 * @Description
 **/
enum class WebCodeBlockType(var code: Int, var language: String, var label: String) {
    PageCode(0, "html","页面(html)"),
    PageDataBinding(1,"javascript","页面数据绑定(js)"),
    ApiCode(2,"javascript","后端Api(js)"),
    Sql(3,"sql","数据库(sql)"),
    Css(4,"css","页面样式(css)"),
    JavaScript(5,"javascript","页面脚本(js)");

    companion object {
        fun valueByCode(code: Int?): WebCodeBlockType? {
            if (code == null){
                return null
            }
            WebCodeBlockType.values().forEach {
                if (it.ordinal == code) {
                    return it
                }
            }
            return null
        }
    }
}