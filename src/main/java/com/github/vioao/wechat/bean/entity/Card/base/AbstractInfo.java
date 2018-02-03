package com.github.vioao.wechat.bean.entity.card.base;

/**
 * 卡券公共信息.
 *
 * @author vioao
 */
public abstract class AbstractInfo {

    /**
     * 基本信息
     */
    private BaseInfo baseInfo;

    /**
     * 高级信息<br>
     * 不支持修改
     */
    private AdvancedInfo advancedInfo;

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public AdvancedInfo getAdvancedInfo() {
        return advancedInfo;
    }

    public void setAdvancedInfo(AdvancedInfo advancedInfo) {
        this.advancedInfo = advancedInfo;
    }

    @Override
    public String toString() {
        return "AbstractInfo{" +
                "advancedInfo=" + advancedInfo +
                ", baseInfo=" + baseInfo +
                '}';
    }
}
