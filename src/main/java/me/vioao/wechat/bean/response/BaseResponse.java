package me.vioao.wechat.bean.response;

import me.vioao.wechat.bean.ReturnCode;
import me.vioao.wechat.utils.StringUtils;

/**
 * 微信请求状态数据.
 *
 * @author vio
 */
public class BaseResponse {
    private static final Integer SUCCESS_CODE = 0;
    private Integer errcode;
    private String errmsg;

    public Integer getErrcode() {
        return errcode == null ? SUCCESS_CODE : errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        String msg = ReturnCode.get(getErrcode());
        return StringUtils.isEmpty(msg) ? errmsg : msg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public boolean isSuccess() {
        return getErrcode().equals(SUCCESS_CODE);
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "errcode=" + getErrcode() +
                ", errmsg='" + getErrmsg() + '\'' +
                '}';
    }
}
