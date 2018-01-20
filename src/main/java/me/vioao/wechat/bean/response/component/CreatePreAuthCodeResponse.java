package me.vioao.wechat.bean.response.component;


import me.vioao.wechat.bean.response.BaseResponse;

public class CreatePreAuthCodeResponse extends BaseResponse {
    private String preAuthCode;
    private int expiresIn;

    public String getPreAuthCode() {
        return preAuthCode;
    }

    public void setPreAuthCode(String preAuthCode) {
        this.preAuthCode = preAuthCode;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "CreatePreAuthCodeResponse{"
                + "preAuthCode='" + preAuthCode + '\''
                + ", expiresIn=" + expiresIn
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
