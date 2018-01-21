package com.github.vioao.wechat.utils.serialize;

import com.github.vioao.wechat.bean.entity.kf.KfAccount;
import com.github.vioao.wechat.bean.xml.in.InMessage;
import org.junit.Assert;
import org.junit.Test;

/**
 * 序列化/反序列化测试.
 *
 * @author vioao
 */
public class SerializeTest {
    @Test
    public void testJsonToBeanAndBeanToJson() {
        String kfString = "{" +
                "\"kf_account\":\"test2@test\"," +
                "\"kf_nick\":\"ntest2\"," +
                "\"kf_id\":\"1002\"," +
                "\"kf_headimgurl\":" +
                "\"http://mmbiz.qpic.cn/mmbiz/4whpV1VZl2iccsvYbHvnphkyGtnvjfUS8Ym0GSaLic0FD3vN0V8PILcibEGb2fPfEOmw/0\"," +
                "\"kf_wx\":\"kfwx2\"" +
                "}";
        KfAccount kfAccount = SerializeUtil.jsonToBean(kfString, KfAccount.class);
        Assert.assertEquals("test2@test", kfAccount.getKfAccount());

        String kfStringAfter = SerializeUtil.beanToJson(kfAccount);
        Assert.assertEquals(kfString, kfStringAfter);
    }

    @Test
    public void testXmlToBeanAndBeanToXml() {
        String xml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName>" +
                "<FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1348831860</CreateTime>" +
                "<MsgType><![CDATA[text]]></MsgType><Content><![CDATA[this is a test]]></Content>" +
                "<MsgId>1234567890123456</MsgId></xml>";
        InMessage msg = SerializeUtil.xmlToBean(xml, InMessage.class);
        Assert.assertEquals("toUser", msg.getToUserName());
    }
}
