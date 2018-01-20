package me.vioao.wechat.bean.xml.out;

import me.vioao.wechat.Const;

import java.io.IOException;
import java.io.OutputStream;

public abstract class XmlMessage {

    private String toUserName;
    private String fromUserName;
    private String msgType;

    protected XmlMessage(String toUserName, String fromUserName, String msgType) {
        super();
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.msgType = msgType;
    }

    /**
     * 子类自定义XML.
     *
     * @return
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

    public boolean outputStreamWrite(OutputStream outputStream) {
        try {
            outputStream.write(toXml().getBytes(Const.Charset.UTF_8));
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
