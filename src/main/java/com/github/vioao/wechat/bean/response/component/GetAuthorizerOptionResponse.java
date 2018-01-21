package com.github.vioao.wechat.bean.response.component;

import com.github.vioao.wechat.bean.response.BaseResponse;

public class GetAuthorizerOptionResponse extends BaseResponse {
    private String authorizerAppid;
    private String optionName;
    private String optionValue;

    public String getAuthorizerAppid() {
        return authorizerAppid;
    }

    public void setAuthorizerAppid(String authorizerAppid) {
        this.authorizerAppid = authorizerAppid;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    @Override
    public String toString() {
        return "GetAuthorizerOptionResponse{"
                + "authorizerAppid='" + authorizerAppid + '\''
                + ", optionName='" + optionName + '\''
                + ", optionValue='" + optionValue + '\''
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
