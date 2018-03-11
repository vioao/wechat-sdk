package com.github.vioao.wechat.bean.response.component.wxa;

import com.github.vioao.wechat.bean.response.BaseResponse;

/**
 * 查询小程序当前隐私设置接口的返回结果.
 *
 * @author vioao
 */
public class GetWxaSearchStatusResponse extends BaseResponse {
    private Integer status; // 1表示不可搜索，0表示可搜索

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GetWxaSearchStatusResponse{"
                + "status=" + status
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
