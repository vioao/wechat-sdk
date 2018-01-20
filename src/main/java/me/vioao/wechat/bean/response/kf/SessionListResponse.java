package me.vioao.wechat.bean.response.kf;

import me.vioao.wechat.bean.entity.kf.Session;
import me.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 客服会话列表.
 *
 * @author vioao
 */
public class SessionListResponse extends BaseResponse {
    private List<Session> sessionlist;

    public List<Session> getSessionlist() {
        return sessionlist;
    }

    public void setSessionlist(List<Session> sessionlist) {
        this.sessionlist = sessionlist;
    }

    @Override
    public String toString() {
        return "SessionListResponse{"
                + "sessionlist=" + sessionlist
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
