package com.github.vioao.wechat.bean.response.user;

import com.github.vioao.wechat.bean.entity.user.OpenIdList;
import com.github.vioao.wechat.bean.response.BaseResponse;

/**
 * 关注用户列表接口返回信息.
 *
 * @author vioao
 */
public class FollowResponse extends BaseResponse {
    private Integer total; //关注该公众账号的总用户数
    private Integer count; //拉取的OPENID个数，最大值为10000
    private String nextOpenid; //拉取列表的最后一个用户的OPENID
    private OpenIdList data; //列表数据，OPENID的列表

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNextOpenid() {
        return nextOpenid;
    }

    public void setNextOpenid(String nextOpenid) {
        this.nextOpenid = nextOpenid;
    }

    public OpenIdList getData() {
        return data;
    }

    public void setData(OpenIdList data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FollowResultResponse{"
                + "total=" + total
                + ", count=" + count
                + ", nextOpenid='" + nextOpenid + '\''
                + ", data=" + data
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
