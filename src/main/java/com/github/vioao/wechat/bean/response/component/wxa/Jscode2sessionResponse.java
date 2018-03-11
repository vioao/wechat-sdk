package com.github.vioao.wechat.bean.response.component.wxa;

import com.github.vioao.wechat.bean.response.BaseResponse;

/**
 * code 换取 session_key的返回.
 *
 * @author vioao
 */
public class JsCode2sessionResponse extends BaseResponse {
    private String openid; // 用户唯一标识的openid
    private String sessionKey; // 会话密钥

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    @Override
    public String toString() {
        return "JsCode2sessionResponse{"
                + "openid='" + openid + '\''
                + ", sessionKey='" + sessionKey + '\''
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
