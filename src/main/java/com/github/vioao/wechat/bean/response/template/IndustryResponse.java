package com.github.vioao.wechat.bean.response.template;

import com.github.vioao.wechat.bean.entity.template.Industry;
import com.github.vioao.wechat.bean.response.BaseResponse;

/**
 * 行业信息接口返回信息.
 *
 * @author vioao
 */
public class IndustryResponse extends BaseResponse {
    private Industry primaryIndustry; //帐号设置的主营行业
    private Industry secondaryIndustry; //帐号设置的副营行业

    public Industry getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(Industry primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public Industry getSecondaryIndustry() {
        return secondaryIndustry;
    }

    public void setSecondaryIndustry(Industry secondaryIndustry) {
        this.secondaryIndustry = secondaryIndustry;
    }

    @Override
    public String toString() {
        return "IndustryResponse{"
                + "primaryIndustry=" + primaryIndustry
                + ", secondaryIndustry=" + secondaryIndustry
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
