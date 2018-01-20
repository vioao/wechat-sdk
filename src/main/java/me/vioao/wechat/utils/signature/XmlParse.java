/**
 * 对公众平台发送给公众账号的消息加解密示例代码.
 *
 * @copyright Copyright (c) 1998-2014 Tencent Inc.
 */

// ------------------------------------------------------------------------

package me.vioao.wechat.utils.signature;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

/**
 * 提供提取消息格式中的密文及生成回复消息格式的接口.
 */
public class XmlParse {
    /**
     * 提取出xml数据包中的加密消息.
     *
     * @param xml 待提取的xml字符串
     * @return 提取出的加密消息字符串
     */
    public static String[] extractToUserNameAndEncrypt(String xml) {
        String[] result = new String[2];
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            StringReader sr = new StringReader(xml);
            InputSource is = new InputSource(sr);
            Document document = db.parse(is);

            Element root = document.getDocumentElement();
            NodeList encryptNodeList = root.getElementsByTagName("Encrypt");
            NodeList toUserNameNodeList = root.getElementsByTagName("ToUserName");
            result[0] = toUserNameNodeList.item(0).getTextContent();
            result[1] = "";
            if (encryptNodeList.getLength() > 0) {
                result[1] = encryptNodeList.item(0).getTextContent();
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException("xml解析失败", e);
        }
    }

    /**
     * 生成xml消息.
     *
     * @param encrypt   加密后的消息密文
     * @param signature 安全签名
     * @param timestamp 时间戳
     * @param nonce     随机字符串
     * @return 生成的xml字符串
     */
    public static String generate(String encrypt, String signature, String timestamp, String nonce) {
        String format = "<xml>\n" + "<Encrypt><![CDATA[%1$s]]></Encrypt>\n"
                + "<MsgSignature><![CDATA[%2$s]]></MsgSignature>\n"
                + "<TimeStamp>%3$s</TimeStamp>\n" + "<Nonce><![CDATA[%4$s]]></Nonce>\n" + "</xml>";
        return String.format(format, encrypt, signature, timestamp, nonce);
    }
}
