package com.github.vioao.wechat.bean.response.kf;

import com.github.vioao.wechat.bean.entity.kf.WaitCase;
import com.github.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 未接入会话接口返回信息.
 *
 * @author vioao
 */
public class WaitCaseResponse extends BaseResponse {
    private Integer count; //未接入会话数量
    private List<WaitCase> waitcaselist; //未接入会话列表，最多返回100条数据，按照来访顺序

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<WaitCase> getWaitcaselist() {
        return waitcaselist;
    }

    public void setWaitcaselist(List<WaitCase> waitcaselist) {
        this.waitcaselist = waitcaselist;
    }

    @Override
    public String toString() {
        return "WaitCaseResponse{"
                + "count=" + count
                + ", waitcaselist=" + waitcaselist
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
