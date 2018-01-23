package com.github.vioao.wechat.bean.entity.poi;

/**
 * 门店信息.
 *
 * @author vioao
 */
public class Business {
    private BaseInfo baseInfo;

    public Business(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    @Override
    public String toString() {
        return "Business{" +
                "baseInfo=" + baseInfo +
                '}';
    }
}
