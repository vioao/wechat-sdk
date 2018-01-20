package me.vioao.wechat.api;

import me.vioao.wechat.bean.response.autoreplay.AutoReplyInfoResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * 自动回复接口测试.
 *
 * @author vioao
 */
public class AutoReplyInfoApiTest extends BaseApiTest {
    @Test
    public void testGetToken() {
        AutoReplyInfoResponse result = AutoReplyInfoApi.getCurrent(TOKEN);
        System.out.println("Get auto reply detail: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }
}
