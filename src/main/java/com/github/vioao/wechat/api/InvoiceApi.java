package com.github.vioao.wechat.api;

import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.bean.entity.invoice.AuthUrlRequest;
import com.github.vioao.wechat.bean.response.invoice.AuthDataResponse;
import com.github.vioao.wechat.bean.response.invoice.AuthUrlResponse;
import com.github.vioao.wechat.bean.response.ticket.TicketResponse;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.client.HttpUtil;
import com.github.vioao.wechat.utils.serialize.SerializeUtil;

import java.util.Map;

/**
 * 发票API。
 *
 * @author vioao
 */
public class InvoiceApi {

    private static final String GET_TICKET = Const.Uri.API_URI + "/cgi-bin/ticket/getticket";

    /**
     * 获取授权页ticket.
     */
    public static TicketResponse getTicket(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).put("type", "wx_card").get();
        return HttpUtil.getJsonBean(GET_TICKET, params, TicketResponse.class);
    }

    private static final String GET_AUTH_URL = Const.Uri.API_URI + "/cgi-bin/ticket/getauthurl";

    /**
     * 获取授权页链接.
     *
     * @param accessToken 调用凭证
     * @param request     请求数据
     * @return {@link AuthUrlResponse}
     */
    public static AuthUrlResponse getAuthUrl(String accessToken, AuthUrlRequest request) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(GET_AUTH_URL, params, SerializeUtil.beanToJson(request), AuthUrlResponse.class);
    }

    private static final String GET_AUTH_DATA = Const.Uri.API_URI + "/cgi-bin/ticket/getauthdata";

    /**
     * 查询授权完成状态.
     *
     * @param accessToken 调用凭证
     * @param orderId     发票order_id
     * @param sPappid     开票平台在微信的标识，由开票平台告知商户
     * @return {@link AuthDataResponse}
     */
    public static AuthDataResponse getAuthData(String accessToken, String orderId, String sPappid) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        String data = String.format("{\"order_id\":\"%s\",\"s_pappid\":%s}", orderId, sPappid);
        return HttpUtil.postJsonBean(GET_AUTH_DATA, params, data, AuthDataResponse.class);
    }

}
