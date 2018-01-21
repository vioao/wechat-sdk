package com.github.vioao.wechat.utils.signature;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 * 微信消息加密解密测试.
 *
 * @author vioao
 */
public class MsgCryptTest {
    private String encodingAesKey = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFG";
    private String token = "pamtest";
    private String timestamp = "1409304348";
    private String nonce = "xxxxxx";
    private String appId = "wxb11529c136998cb6";
    private String replyMsg = "我是中文abcd123";
    private String xmlFormat = "<xml><ToUserName><![CDATA[toUser]]></ToUserName>" +
            "<Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
    private String afterAesEncrypt = "jn1L23DB+6ELqJ+6bruv21Y6MD7KeIfP82D6gU39rmkgczbWw" +
            "t5+3bnyg5K55bgVtVzd832WzZGMhkP72vVOfg==";
    private String randomStr = "aaaabbbbccccdddd";

    private String replyMsg2 = "<xml><ToUserName><![CDATA[oia2Tj我是中文jewbmiOUlr6X-1crbLOvLw]]></ToUserName>" +
            "<FromUserName><![CDATA[gh_7f083739789a]]></FromUserName><CreateTime>1407743423</CreateTime>" +
            "<MsgType><![CDATA[video]]></MsgType><Video>" +
            "<MediaId><![CDATA[eYJ1MbwPRJtOvIEabaxHs7TX2D-HV71s79GUxqdUkjm6Gs2Ed1KF3ulAOA9H1xG0]]></MediaId>" +
            "<Title><![CDATA[testCallBackReplyVideo]]></Title>" +
            "<Description><![CDATA[testCallBackReplyVideo]]></Description></Video></xml>";
    private String afterAesEncrypt2 = "jn1L23DB+6ELqJ+6bruv23M2GmYfkv0xBh2h+XTBOKVKcgDFHle6gqcZ1cZrk3e1qjPQ1F4RsLWzQ" +
            "RG9udbKWesxlkupqcEcW7ZQweImX9+wLMa0GaUzpkycA8+IamDBxn5loLgZpnS7fVAbExOkK5DYHBmv5tptA9tklE/fTIILHR8HLXa" +
            "5nQvFb3tYPKAlHF3rtTeayNf0QuM+UW/wM9enGIDIJHF7CLHiDNAYxr+r+OrJCmPQyTy8cVWlu9iSvOHPT/77bZqJucQHQ04sq7KZ" +
            "I27OcqpQNSto2OdHCoTccjggX5Z9Mma0nMJBU+jLKJ38YB1fBIz+vBzsYjrTmFQ44YfeEuZ+xRTQwr92vhA9OxchWVINGC50qE/6lmk" +
            "wWTwGX9wtQpsJKhP+oS7rvTY8+VdzETdfakjkwQ5/Xka042OlUb1/slTwo4RscuQ+RdxSGvDahxAJ6+EAjLt9d8igHngxIbf6YyqqRO" +
            "xuxqIeIch3CssH/LqRs+iAcILvApYZckqmA7FNERspKA5f8GoJ9sv8xmGvZ9Yrf57cExWtnX8aCMMaBropU/1k+hKP5LVdzbWCG0hGw" +
            "x/dQudYR/eXp3P0XxjlFiy+9DMlaFExWUZQDajPkdPrEeOwofJb";

    @Test
    public void testNormal() throws ParserConfigurationException, IOException, SAXException {
        String afterEncrpt = MsgCrypt.encryptMsg(appId, encodingAesKey, token, replyMsg, timestamp, nonce);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        StringReader sr = new StringReader(afterEncrpt);
        InputSource is = new InputSource(sr);
        Document document = db.parse(is);

        Element root = document.getDocumentElement();
        NodeList nodelist1 = root.getElementsByTagName("Encrypt");
        NodeList nodelist2 = root.getElementsByTagName("MsgSignature");

        String encrypt = nodelist1.item(0).getTextContent();
        String msgSignature = nodelist2.item(0).getTextContent();
        String fromXML = String.format(xmlFormat, encrypt);

        boolean check = SignatureUtil.check(msgSignature, timestamp, nonce, token, encrypt);
        assertEquals(true, check);

        // 第三方收到公众号平台发送的消息
        String afterDecrpt = MsgCrypt.decryptMsg(appId, encodingAesKey, token, msgSignature, timestamp, nonce, fromXML);
        assertEquals(replyMsg, afterDecrpt);
    }
}
