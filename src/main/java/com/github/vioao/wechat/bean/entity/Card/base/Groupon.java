package com.github.vioao.wechat.bean.entity.card.base;

/**
 * 团购券.
 *
 * @author vioao
 */
public class Groupon extends AbstractInfo {

    /**
     * 团购详情<br>
     * 添加必填，不支持修改
     */
    private String dealDetail;

    public String getDealDetail() {
        return dealDetail;
    }

    public void setDealDetail(String dealDetail) {
        this.dealDetail = dealDetail;
    }

    @Override
    public String toString() {
        return "Groupon{" +
                "dealDetail='" + dealDetail + '\'' +
                ", advancedInfo=" + getAdvancedInfo() +
                ", baseInfo=" + getBaseInfo() +
                '}';
    }
}
