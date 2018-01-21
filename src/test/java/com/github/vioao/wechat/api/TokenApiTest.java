package com.github.vioao.wechat.api;

import com.github.vioao.wechat.bean.response.token.TokenResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * token相关API测试.
 *
 * @author vioao
 */
public class TokenApiTest extends BaseApiTest {
    @Test
    public void testGetToken() {
        TokenResponse result = TokenApi.token(APP_ID, APP_SECRET);
        System.out.println("Get access token: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }
}
