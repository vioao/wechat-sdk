package me.vioao.wechat.bean.xml.out;

public class XmlImageMessage extends XmlMessage {
    private String mediaId;

    public XmlImageMessage(String toUserName, String fromUserName, String mediaId) {
        super(toUserName, fromUserName, "image");
        this.mediaId = mediaId;
    }

    @Override
    public String subXml() {
        return "<Image><MediaId><![CDATA[" + mediaId + "]]></MediaId></Image>";
    }
}
