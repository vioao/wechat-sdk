package com.github.vioao.wechat.bean.entity.datacube;

/**
 * 接口分析数据Item.
 *
 * @author vioao
 */
public class InterfaceDataCube {
    private String refDate; //数据的日期
    private Integer refHour; //数据的小时
    private Integer callbackCount; //通过服务器配置地址获得消息后，被动回复用户消息的次数
    private Integer failCount; //上述动作的失败次数
    private Integer totalTimeCost; //总耗时，除以callback_count即为平均耗时
    private Integer maxTimeCost; //最大耗时

    public String getRefDate() {
        return refDate;
    }

    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    public Integer getRefHour() {
        return refHour;
    }

    public void setRefHour(Integer refHour) {
        this.refHour = refHour;
    }

    public Integer getCallbackCount() {
        return callbackCount;
    }

    public void setCallbackCount(Integer callbackCount) {
        this.callbackCount = callbackCount;
    }

    public Integer getFailCount() {
        return failCount;
    }

    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }

    public Integer getTotalTimeCost() {
        return totalTimeCost;
    }

    public void setTotalTimeCost(Integer totalTimeCost) {
        this.totalTimeCost = totalTimeCost;
    }

    public Integer getMaxTimeCost() {
        return maxTimeCost;
    }

    public void setMaxTimeCost(Integer maxTimeCost) {
        this.maxTimeCost = maxTimeCost;
    }

    @Override
    public String toString() {
        return "InterfaceDataCube{" +
                "refDate='" + refDate + '\'' +
                ", refHour=" + refHour +
                ", callbackCount=" + callbackCount +
                ", failCount=" + failCount +
                ", totalTimeCost=" + totalTimeCost +
                ", maxTimeCost=" + maxTimeCost +
                '}';
    }
}
