package com.github.vioao.wechat.bean.entity.card.base;

/**
 * 折扣券.
 *
 * @author vioao
 */
public class Discount extends AbstractInfo {

    /**
     * 表示打折额度（百分比）。填30就是七折。<br>
     * 添加必填，不支持修改
     */
    private Integer discount;

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discount=" + discount +
                ", advancedInfo=" + getAdvancedInfo() +
                ", baseInfo=" + getBaseInfo() +
                "}";
    }
}
