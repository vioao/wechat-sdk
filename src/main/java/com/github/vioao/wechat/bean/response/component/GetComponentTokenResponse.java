package com.github.vioao.wechat.bean.response.component;


import com.github.vioao.wechat.bean.response.BaseResponse;

public class GetComponentTokenResponse extends BaseResponse {
    private String componentAccessToken;
    private Integer expiresIn;

    public String getComponentAccessToken() {
        return componentAccessToken;
    }

    public void setComponentAccessToken(String componentAccessToken) {
        this.componentAccessToken = componentAccessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "GetComponentTokenResponse{"
                + "componentAccessToken='" + componentAccessToken + '\''
                + ", expiresIn=" + expiresIn
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
