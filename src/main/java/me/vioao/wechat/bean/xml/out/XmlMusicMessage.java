package me.vioao.wechat.bean.xml.out;

public class XmlMusicMessage extends XmlMessage {
    private String title;
    private String description;
    private String musicUrl;
    private String hqMusicUrl;
    private String thumbMediaId;

    /**
     * @param toUserName
     * @param fromUserName
     * @param title        [可以为空]
     * @param description  [可以为空]
     * @param musicUrl     [可以为空] 音乐链接
     * @param hqMusicUrl   [可以为空] 高质量音乐链接，WIFI环境优先使用该链接播放音乐
     * @param thumbMediaId 缩略图的媒体id，通过上传多媒体文件，得到的id
     */
    public XmlMusicMessage(String toUserName, String fromUserName, String title, String description,
                           String musicUrl, String hqMusicUrl, String thumbMediaId) {
        super(toUserName, fromUserName, "music");
        this.title = title;
        this.description = description;
        this.musicUrl = musicUrl;
        this.hqMusicUrl = hqMusicUrl;
        this.thumbMediaId = thumbMediaId;
    }

    @Override
    public String subXml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<Music>");
        sb.append("<Title><![CDATA[" + (title == null ? "" : title) + "]]></Title>");
        sb.append("<Description><![CDATA[" + (description == null ? "" : description) + "]]></Description>");
        sb.append("<MusicUrl><![CDATA[" + (musicUrl == null ? "" : musicUrl) + "]]></MusicUrl>");
        sb.append("<HQMusicUrl><![CDATA[" + (hqMusicUrl == null ? "" : hqMusicUrl) + "]]></HQMusicUrl>");
        sb.append("<ThumbMediaId><![CDATA[" + thumbMediaId + "]]></ThumbMediaId>");
        sb.append("</Music>");
        return sb.toString();
    }
}
