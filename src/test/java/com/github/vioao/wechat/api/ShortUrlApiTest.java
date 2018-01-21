package com.github.vioao.wechat.api;

import com.github.vioao.wechat.bean.response.shorturl.ShortUrlResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * 长链接转短链接接口测试.
 *
 * @author vioao
 */
public class ShortUrlApiTest extends BaseApiTest {
    @Test
    public void testToShort() {
        String url = "http://blog.vioao.me/";
        ShortUrlResponse result = ShortUrlApi.toShortUrl(TOKEN, url);
        System.out.println("Change to short url: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }
}
