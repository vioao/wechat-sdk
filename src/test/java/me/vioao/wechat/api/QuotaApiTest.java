package me.vioao.wechat.api;

import me.vioao.wechat.bean.response.BaseResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * 接口调用频次API测试.
 *
 * @author vioao
 */
public class QuotaApiTest extends BaseApiTest {

    @Test
    public void testClearQuota() {
        BaseResponse result = QuotaApi.clearQuota(TOKEN, APP_ID);
        System.out.println("Clear Quota: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }
}
