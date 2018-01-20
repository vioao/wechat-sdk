package me.vioao.wechat.bean.response.component;


import me.vioao.wechat.bean.response.BaseResponse;

public class GetComponentTokenResponse extends BaseResponse {
    private String componentAccessToken;
    private int expiresIn;

    public String getComponentAccessToken() {
        return componentAccessToken;
    }

    public void setComponentAccessToken(String componentAccessToken) {
        this.componentAccessToken = componentAccessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
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
