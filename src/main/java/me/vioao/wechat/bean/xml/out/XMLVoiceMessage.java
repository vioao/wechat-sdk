package me.vioao.wechat.bean.xml.out;

public class XMLVoiceMessage extends XmlMessage {
    private String mediaId;

    public XMLVoiceMessage(String toUserName, String fromUserName, String mediaId) {
        super(toUserName, fromUserName, "voice");
        this.mediaId = mediaId;
    }

    @Override
    public String subXml() {
        return "<Voice><MediaId><![CDATA[" + mediaId + "]]></MediaId></Voice>";
    }
}
