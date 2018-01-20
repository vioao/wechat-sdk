package me.vioao.wechat.bean.response.component;


import me.vioao.wechat.bean.entity.component.FuncInfo;
import me.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 使用授权码换取公众号的授权信息接口的返回信息.
 *
 * @author vioao
 */
public class QueryAuthResponse extends BaseResponse {
    private String appid;
    private String authorizerAppid; //授权方appid
    private String authorizerAccessToken; //授权方令牌（在授权的公众号具备API权限时，才有此返回值）。
    private Integer expiresIn; //有效期（在授权的公众号具备API权限时，才有此返回值）

    // 刷新令牌（在授权的公众号具备API权限时，才有此返回值），刷新令牌主要用于公众号第三方平台获取和刷新已授权用户的access_token，
    // 只会在授权时刻提供，请妥善保存。 一旦丢失，只能让用户重新授权，才能再次拿到新的刷新令牌
    private String authorizerRefreshToken;
    private List<FuncInfo> funcInfo; //公众号授权给开发者的权限集列表

    public String getAuthorizerAppid() {
        return authorizerAppid;
    }

    public void setAuthorizerAppid(String authorizerAppid) {
        this.authorizerAppid = authorizerAppid;
    }

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

    public List<FuncInfo> getFuncInfo() {
        return funcInfo;
    }

    public void setFuncInfo(List<FuncInfo> funcInfo) {
        this.funcInfo = funcInfo;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    @Override
    public String toString() {
        return "QueryAuthResponse{"
                + "appid='" + appid + '\''
                + ", authorizerAppid='" + authorizerAppid + '\''
                + ", authorizerAccessToken='" + authorizerAccessToken + '\''
                + ", expiresIn=" + expiresIn
                + ", authorizerRefreshToken='" + authorizerRefreshToken + '\''
                + ", funcInfo=" + funcInfo
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
