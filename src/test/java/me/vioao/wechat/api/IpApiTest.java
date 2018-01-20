package me.vioao.wechat.api;

import me.vioao.wechat.bean.response.ip.IpListResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * 获取为新服务器IP接口测试.
 *
 * @author vioao
 */
public class IpApiTest extends BaseApiTest {
    @Test
    public void testGetIp() {
        IpListResponse result = IpApi.getIpList(TOKEN);
        System.out.println("Get Ip List: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }
}
