package vip.sujianfeng.enjoyapi.enums

/**
 * @author SuJianFeng
 * @date 2022/5/8
 * @Description 部署状态
 */
enum class DeployStatus(var label: String) {
    New("新增部署"), Ready("待部署"), Deploying("部署中"), Fail("部署失败"), Success("部署成功"), UnKnown("未知")
}

fun instanceDeployStatusBy(value: Int?): DeployStatus {
    if (value == null) {
        return DeployStatus.UnKnown
    }
    for (item in DeployStatus.values()) {
        if (item.ordinal == value) {
            return item
        }
    }
    return DeployStatus.UnKnown
}