package com.github.vioao.wechat.bean.response.open;

import com.github.vioao.wechat.bean.response.BaseResponse;

/**
 * 开放平台接口返回.
 *
 * @author vioao
 */
public class OpenResponse extends BaseResponse {
    private String open_appid; //开放平台帐号的appid

    public String getOpen_appid() {
        return open_appid;
    }

    public void setOpen_appid(String open_appid) {
        this.open_appid = open_appid;
    }

    @Override
    public String toString() {
        return "OpenResponse{"
                + "open_appid='" + open_appid + '\''
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
