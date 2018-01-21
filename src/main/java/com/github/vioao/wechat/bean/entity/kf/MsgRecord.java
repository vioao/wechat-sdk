package com.github.vioao.wechat.bean.entity.kf;

/**
 * 客服聊天记录信息.
 *
 * @author vioao
 */
public class MsgRecord {
    private String openid; //用户标识
    private Integer opercode; //操作码，2002（客服发送信息），2003（客服接收消息）
    private String text; //聊天记录
    private Long time; //操作时间，unix时间戳
    private String worker; //完整客服帐号，格式为：帐号前缀@公众号微信号

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getOpercode() {
        return opercode;
    }

    public void setOpercode(Integer opercode) {
        this.opercode = opercode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }
}
