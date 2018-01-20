package me.vioao.wechat.bean.entity.message.massmsg;

import lombok.Builder;

import java.util.Set;

/**
 * 群发消息.
 *
 * @author vioao
 */
@Builder
public class MassMessage {
    //群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
    private String msgtype;
    private Filter filter;//用于设定图文消息的接收者
    private Set<String> touser; //填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个

    // 用于设定是否向全部用户发送，值为true或false，
    // 选择true该消息群发给所有用户，选择false可根据tag_id发送给指定群组的用户
    private Boolean isToAll;

    // 群发到的标签的tag_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id
    private String tagId;

    // 开发者侧群发msgid，长度限制64字节，如不填，则后台默认以群发范围和群发内容的摘要值做为clientmsgid
    private String clientmsgid;

    public MassMessage(String msgtype) {
        this.msgtype = msgtype;
    }

    public MassMessage(String msgtype, Filter filter, Set<String> touser,
                       boolean isToAll, String tagId, String clientmsgid) {
        this.msgtype = msgtype;
        this.filter = filter;
        this.touser = touser;
        this.isToAll = isToAll;
        this.tagId = tagId;
        this.clientmsgid = clientmsgid;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public Set<String> getTouser() {
        return touser;
    }

    public void setTouser(Set<String> touser) {
        this.touser = touser;
    }

    public Boolean isToAll() {
        return isToAll;
    }

    public void setToAll(Boolean toAll) {
        isToAll = toAll;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getClientmsgid() {
        return clientmsgid;
    }

    public void setClientmsgid(String clientmsgid) {
        this.clientmsgid = clientmsgid;
    }

    @Override
    public String toString() {
        return "MassMessage{" +
                "msgtype='" + msgtype + '\'' +
                ", filter=" + filter +
                ", touser=" + touser +
                ", isToAll=" + isToAll +
                ", tagId='" + tagId + '\'' +
                ", clientmsgid='" + clientmsgid + '\'' +
                '}';
    }
}
