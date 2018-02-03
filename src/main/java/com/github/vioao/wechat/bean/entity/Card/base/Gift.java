package com.github.vioao.wechat.bean.entity.card.base;

/**
 * 兑换券.
 *
 * @author vioao
 */
public class Gift extends AbstractInfo {

    /**
     * 填写兑换内容的名称。<br>
     * 添加必填，不支持修改
     */
    private String gift;

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "gift='" + gift + '\'' +
                ", advancedInfo=" + getAdvancedInfo() +
                ", baseInfo=" + getBaseInfo() +
                '}';
    }
}
