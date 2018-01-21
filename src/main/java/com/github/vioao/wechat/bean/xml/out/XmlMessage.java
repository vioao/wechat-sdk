package com.github.vioao.wechat.bean.xml.out;

public abstract class XmlMessage {

    private String toUserName;
    private String fromUserName;
    private String msgType;

    protected XmlMessage(String toUserName, String fromUserName, String msgType) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.msgType = msgType;
    }

    /**
     * 子类自定义XML.
     */
    public abstract String subXml();

    /**
     * 转成XML字符串.
     */
    public String toXml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + toUserName + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + fromUserName + "]]></FromUserName>");
        sb.append("<CreateTime>" + System.currentTimeMillis() / 1000 + "</CreateTime>");
        sb.append("<MsgType><![CDATA[" + msgType + "]]></MsgType>");
        sb.append(subXml());
        sb.append("</xml>");
        return sb.toString();
    }
}
