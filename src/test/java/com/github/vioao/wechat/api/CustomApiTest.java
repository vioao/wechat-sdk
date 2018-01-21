package com.github.vioao.wechat.api;

import com.github.vioao.wechat.bean.response.BaseResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * 客服接口测试.
 * 测试号无法测试新客服接口,Pass.
 *
 * @author vioao
 */
public class CustomApiTest extends BaseApiTest {
    @Test
    public void testGetCurrentSelfMenuInfo() {
        String account = "test@" + ACCOUNT_ID;
        BaseResponse result = CustomApi.addAccount(TOKEN, account, "nick");
        System.out.println("Add custom account: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }
}
