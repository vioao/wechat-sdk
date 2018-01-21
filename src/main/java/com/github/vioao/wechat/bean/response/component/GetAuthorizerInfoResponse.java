package com.github.vioao.wechat.bean.response.component;

import com.github.vioao.wechat.bean.entity.component.AuthorizerInfo;
import com.github.vioao.wechat.bean.response.BaseResponse;

/**
 * 授权方总的的账户信息.
 *
 * @author vioao
 */
public class GetAuthorizerInfoResponse extends BaseResponse {
    private AuthorizerInfo authorizerInfo;
    private String qrcodeUrl; //二维码图片链接
    private QueryAuthResponse authorizationInfo;

    public AuthorizerInfo getAuthorizerInfo() {
        return authorizerInfo;
    }

    public void setAuthorizerInfo(AuthorizerInfo authorizerInfo) {
        this.authorizerInfo = authorizerInfo;
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    public QueryAuthResponse getAuthorizationInfo() {
        return authorizationInfo;
    }

    public void setAuthorizationInfo(QueryAuthResponse authorizationInfo) {
        this.authorizationInfo = authorizationInfo;
    }

    @Override
    public String toString() {
        return "GetAuthorizerInfoResponse{"
                + "authorizerInfo=" + authorizerInfo
                + ", qrcodeUrl='" + qrcodeUrl + '\''
                + ", authorizationInfo=" + authorizationInfo
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
