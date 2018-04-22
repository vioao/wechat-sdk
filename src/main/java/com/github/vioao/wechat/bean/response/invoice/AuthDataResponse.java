package com.github.vioao.wechat.bean.response.invoice;

import com.github.vioao.wechat.bean.response.BaseResponse;
import lombok.Builder;

/**
 * 查询授权完成状态-接口返回.
 *
 * @author vioao
 */
@Builder
public class AuthDataResponse extends BaseResponse {
    private String invoiceStatus; // 订单授权状态，当errcode为0时会出现
    private Integer authTime; // 授权时间，为十位时间戳（utc+8），当errcode为0时会出现
    private UserAuthInfo userAuthInfo; // 用户授权信息结构体，仅在授权页为type=1时出现

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public Integer getAuthTime() {
        return authTime;
    }

    public void setAuthTime(Integer authTime) {
        this.authTime = authTime;
    }

    public UserAuthInfo getUserAuthInfo() {
        return userAuthInfo;
    }

    public void setUserAuthInfo(UserAuthInfo userAuthInfo) {
        this.userAuthInfo = userAuthInfo;
    }

    @Override
    public String toString() {
        return "AuthDataResponse{"
                + "errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + ", invoiceStatus='" + invoiceStatus + '\''
                + ", authTime=" + authTime
                + ", userAuthInfo=" + userAuthInfo
                + '}';
    }

    static class UserAuthInfo {

    }
}
