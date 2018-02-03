package com.github.vioao.wechat.bean.entity.card.base;

/**
 * 优惠券.
 *
 * @author vioao
 */
public class GeneralCoupon extends AbstractInfo {
    /**
     * 优惠券专用，填写优惠详情.<br>
     * 添加必填，不支持修改
     */
    private String defaultDetail;

    public String getDefaultDetail() {
        return defaultDetail;
    }

    public void setDefaultDetail(String defaultDetail) {
        this.defaultDetail = defaultDetail;
    }

    @Override
    public String toString() {
        return "GeneralCoupon{" +
                "defaultDetail='" + defaultDetail + '\'' +
                ", advancedInfo=" + getAdvancedInfo() +
                ", baseInfo=" + getBaseInfo() +
                '}';
    }
}
