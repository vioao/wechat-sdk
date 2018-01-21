package com.github.vioao.wechat.bean.entity.message.msg;

public abstract class Message {
    private String touser;
    private String msgtype;

    public Message() {
    }

    /**
     * 构造基本消息对象.
     */
    Message(String touser, String msgtype) {
        this.touser = touser;
        this.msgtype = msgtype;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    protected void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
}
