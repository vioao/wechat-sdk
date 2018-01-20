package me.vioao.wechat.api;

import me.vioao.wechat.Const;
import me.vioao.wechat.bean.response.ticket.TicketResponse;
import me.vioao.wechat.utils.Params;
import me.vioao.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * JSAPI ticket.
 *
 * @author vioao
 */
public class TicketApi {
    private static final String TICKET_GET = Const.Uri.API_URI + "/cgi-bin/ticket/getticket";

    /**
     * 获取 jsapi_ticket.
     *
     * @param accessToken 公众号的全局唯一接口调用凭据
     */
    public static TicketResponse getTicket(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken)
                .put("type", "jsapi").get();
        return HttpUtil.getJsonBean(TICKET_GET, params, TicketResponse.class);
    }
}
