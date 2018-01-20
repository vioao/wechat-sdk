package me.vioao.wechat.bean.entity.autoreplay;

/**
 * 自动回复的信息.
 *
 * @author vioao
 */
public class ReplyInfo {
    // 自动回复的类型。关注后自动回复和消息自动回复的类型仅支持文本（text）、图片（img）、语音（voice）、视频（video），
    // 关键词自动回复则还多了图文消息（news）
    private String type;
    //对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID
    private String content;
    private NewsInfo newsInfo; //图文消息的信息
    private String matchMode; //匹配模式，contain代表消息中含有该关键词即可，equal表示消息内容必须和关键词严格相同

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NewsInfo getNewsInfo() {
        return newsInfo;
    }

    public void setNewsInfo(NewsInfo newsInfo) {
        this.newsInfo = newsInfo;
    }

    public String getMatchMode() {
        return matchMode;
    }

    public void setMatchMode(String matchMode) {
        this.matchMode = matchMode;
    }

    @Override
    public String toString() {
        return "ReplyInfo{" +
                "type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", newsInfo=" + newsInfo +
                ", matchMode='" + matchMode + '\'' +
                '}';
    }
}
