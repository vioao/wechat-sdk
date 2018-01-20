package me.vioao.wechat.bean.response.component;

import me.vioao.wechat.bean.response.BaseResponse;

public class GetAuthorizerTokenResponse extends BaseResponse {
    private String authorizerAccessToken;
    private Integer expiresIn;
    private String authorizerRefreshToken;

    public String getAuthorizerAccessToken() {
        return authorizerAccessToken;
    }

    public void setAuthorizerAccessToken(String authorizerAccessToken) {
        this.authorizerAccessToken = authorizerAccessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getAuthorizerRefreshToken() {
        return authorizerRefreshToken;
    }

    public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
        this.authorizerRefreshToken = authorizerRefreshToken;
    }

    @Override
    public String toString() {
        return "GetAuthorizerTokenResponse{"
                + "authorizerAccessToken='" + authorizerAccessToken + '\''
                + ", expiresIn=" + expiresIn
                + ", authorizerRefreshToken='" + authorizerRefreshToken + '\''
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
