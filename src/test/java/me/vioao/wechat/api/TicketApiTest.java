package me.vioao.wechat.api;

import me.vioao.wechat.bean.response.ticket.TicketResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * js api ticket接口测试.
 *
 * @author vioao
 */
public class TicketApiTest extends BaseApiTest {
    @Test
    public void testGetToken() {
        TicketResponse result = TicketApi.getTicket(TOKEN);
        System.out.println("Get access token: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }
}
