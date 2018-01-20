package me.vioao.wechat.bean.response.kf;

import me.vioao.wechat.bean.entity.kf.MsgRecord;
import me.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 客服聊天记录接口返回信息.
 *
 * @author vioao
 */
public class MsgRecordResponse extends BaseResponse {
    private List<MsgRecord> recordlist;
    private Integer number;
    private Integer msgid;

    public List<MsgRecord> getRecordlist() {
        return recordlist;
    }

    public void setRecordlist(List<MsgRecord> recordlist) {
        this.recordlist = recordlist;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getMsgid() {
        return msgid;
    }

    public void setMsgid(Integer msgid) {
        this.msgid = msgid;
    }

    @Override
    public String toString() {
        return "MsgRecordResponse{"
                + "recordlist=" + recordlist
                + ", number=" + number
                + ", msgid=" + msgid
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
