package com.github.vioao.wechat.bean.entity.datacube;

/**
 * 消息分析数据Item.
 *
 * @author vioao
 */
public class MessageDataCube {
    private String refDate; //	数据的日期，需在begin_date和end_date之间

    //	数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
    private Integer refHour;

    // 消息类型，代表含义如下： 1代表文字 2代表图片 3代表语音 4代表视频 6代表第三方应用消息（链接消息）
    private Integer msgType;

    private Integer msgUser; //	上行发送了（向公众号发送了）消息的用户数
    private Integer msgCount; // 上行发送了消息的消息总数

    // 当日发送消息量分布的区间，0代表 “0”，1代表“1-5”，2代表“6-10”，3代表“10次以上”
    private Integer countInterval;

    private Integer intPageReadCount; // 图文页的阅读次数
    private Integer oriPageReadUser; //	原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0

    public String getRefDate() {
        return refDate;
    }

    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    public Integer getRefHour() {
        return refHour;
    }

    public void setRefHour(Integer refHour) {
        this.refHour = refHour;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public Integer getMsgUser() {
        return msgUser;
    }

    public void setMsgUser(Integer msgUser) {
        this.msgUser = msgUser;
    }

    public Integer getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(Integer msgCount) {
        this.msgCount = msgCount;
    }

    public Integer getCountInterval() {
        return countInterval;
    }

    public void setCountInterval(Integer countInterval) {
        this.countInterval = countInterval;
    }

    public Integer getIntPageReadCount() {
        return intPageReadCount;
    }

    public void setIntPageReadCount(Integer intPageReadCount) {
        this.intPageReadCount = intPageReadCount;
    }

    public Integer getOriPageReadUser() {
        return oriPageReadUser;
    }

    public void setOriPageReadUser(Integer oriPageReadUser) {
        this.oriPageReadUser = oriPageReadUser;
    }

    @Override
    public String toString() {
        return "MessageDataCube{" +
                "refDate='" + refDate + '\'' +
                ", refHour=" + refHour +
                ", msgType=" + msgType +
                ", msgUser=" + msgUser +
                ", msgCount=" + msgCount +
                ", countInterval=" + countInterval +
                ", intPageReadCount=" + intPageReadCount +
                ", oriPageReadUser=" + oriPageReadUser +
                '}';
    }
}
