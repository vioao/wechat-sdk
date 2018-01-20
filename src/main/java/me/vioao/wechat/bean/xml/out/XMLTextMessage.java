package me.vioao.wechat.bean.xml.out;

public class XMLTextMessage extends XmlMessage {
    private String content;

    public XMLTextMessage(String toUserName, String fromUserName, String content) {
        super(toUserName, fromUserName, "text");
        this.content = content;
    }

    @Override
    public String subXml() {
        return "<Content><![CDATA[" + content + "]]></Content>";
    }
}
