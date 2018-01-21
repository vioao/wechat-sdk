package com.github.vioao.wechat.utils.client;

import org.junit.Assert;
import org.junit.Test;

/**
 * Http工具类测试.
 *
 * @author vioao
 */
public class HttpUtilTest {
    @Test
    public void testGet() {
        String response = HttpUtil.get("https://mp.weixin.qq.com/wiki", null);
        Assert.assertNotNull(response);
    }
}
