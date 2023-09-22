package vip.sujianfeng.admin.enums

/**
 * @author SuJianFeng
 * @date 2022/5/27
 * @Description
 */
enum class UserType(var code: Int, var title: String) {
    UnAudit(0, "未审核"),
    Normal(1, "普通用户"),
    SuperUser(99, "未审核")
}