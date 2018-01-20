package me.vioao.wechat.bean.response.message;


import me.vioao.wechat.bean.response.BaseResponse;

/**
 * 群发消息结果.
 *
 * @author vioao
 */
public class MessageSendResponse extends BaseResponse {
    private String type; //媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），次数为news，即图文消息
    private String msgId; //消息发送任务的ID
    // 消息的数据ID，，该字段只有在群发图文消息时，才会出现。可以用于在图文分析数据接口中，获取到对应的图文消息的数据，
    // 是图文分析数据接口中的msgid字段中的前半部分，详见图文分析数据接口中的msgid字段的介绍。
    private String msgDataId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgDataId() {
        return msgDataId;
    }

    public void setMsgDataId(String msgDataId) {
        this.msgDataId = msgDataId;
    }

    @Override
    public String toString() {
        return "MessageSendResponse{" +
                "type='" + type + '\'' +
                ", msgId='" + msgId + '\'' +
                ", msgDataId='" + msgDataId + '\'' +
                '}';
    }
}
