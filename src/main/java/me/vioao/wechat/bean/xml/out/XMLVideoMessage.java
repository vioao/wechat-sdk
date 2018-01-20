package me.vioao.wechat.bean.xml.out;

public class XMLVideoMessage extends XmlMessage {
    private String mediaId;
    private String title;
    private String description;

    public XMLVideoMessage(String toUserName, String fromUserName, String mediaId, String title, String description) {
        super(toUserName, fromUserName, "video");
        this.mediaId = mediaId;
        this.title = title;
        this.description = description;
    }

    @Override
    public String subXml() {
        return "<Video><MediaId><![CDATA[" + mediaId + "]]></MediaId><Title>" +
                "<![CDATA[" + (title == null ? "" : title) + "]]></Title><Description>" +
                "<![CDATA[" + (description == null ? "" : description) + "]]></Description></Video>";
    }
}
