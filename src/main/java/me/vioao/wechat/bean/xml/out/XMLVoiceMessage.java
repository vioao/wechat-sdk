package me.vioao.wechat.bean.xml.out;

import me.vioao.wechat.bean.entity.message.MsgType;

public class XMLVoiceMessage extends XmlMessage {
    private String mediaId;

    public XMLVoiceMessage(String toUserName, String fromUserName, String mediaId) {
        super(toUserName, fromUserName, MsgType.VOICE.name().toLowerCase());
        this.mediaId = mediaId;
    }

    @Override
    public String subXml() {
        return "<Voice><MediaId><![CDATA[" + mediaId + "]]></MediaId></Voice>";
    }
}
