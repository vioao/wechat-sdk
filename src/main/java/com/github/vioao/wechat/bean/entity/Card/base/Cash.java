package com.github.vioao.wechat.bean.entity.card.base;

/**
 * 代金券.
 *
 * @author vioao
 */
public class Cash extends AbstractInfo {

    /**
     * 表示起用金额（单位为分）,如果无起用门槛则填0。<br>
     * 添加必填，不支持修改
     */
    private Integer leastCost;

    /**
     * 表示减免金额。（单位为分）<br>
     * 添加必填，不支持修改
     */
    private Integer reduceCost;

    public Integer getLeastCost() {
        return leastCost;
    }

    public void setLeastCost(Integer leastCost) {
        this.leastCost = leastCost;
    }

    public Integer getReduceCost() {
        return reduceCost;
    }

    public void setReduceCost(Integer reduceCost) {
        this.reduceCost = reduceCost;
    }

    @Override
    public String toString() {
        return "Cash{" +
                "leastCost=" + leastCost +
                ", reduceCost=" + reduceCost +
                ", advancedInfo=" + getAdvancedInfo() +
                ", baseInfo=" + getBaseInfo() +
                '}';
    }
}
