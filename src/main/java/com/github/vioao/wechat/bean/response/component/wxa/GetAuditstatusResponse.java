package com.github.vioao.wechat.bean.response.component.wxa;

import com.github.vioao.wechat.bean.response.BaseResponse;


public class GetAuditstatusResponse extends BaseResponse {
    private Integer status; //审核状态，其中0为审核成功，1为审核失败，2为审核中
    private String reason; // 当status=1，审核被拒绝时，返回的拒绝原因

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "GetAuditstatusResponse{"
                + "status=" + status
                + ", reason='" + reason + '\''
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
