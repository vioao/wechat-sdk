package com.github.vioao.wechat.bean.response.message;


import com.github.vioao.wechat.bean.response.BaseResponse;

/**
 * 群发消息状态.
 *
 * @author vioao
 */
public class MessageSendStatusResponse extends BaseResponse {
    private String msgId; //群发消息后返回的消息id
    private String msgStatus; //消息发送后的状态，SEND_SUCCESS表示发送成功，SENDING表示发送中，SEND_FAIL表示发送失败，DELETE表示已删除

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus;
    }

    @Override
    public String toString() {
        return "MessageSendStatusResponse{"
                + "msgId='" + msgId + '\''
                + ", msgStatus='" + msgStatus + '\''
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
