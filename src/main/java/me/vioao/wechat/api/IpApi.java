package me.vioao.wechat.api;

import me.vioao.wechat.Const;
import me.vioao.wechat.bean.response.ip.IpListResponse;
import me.vioao.wechat.utils.Params;
import me.vioao.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * 微信服务器IP API接口.
 *
 * @author vioao
 */
public class IpApi {
    private static final String GET_CALL_BACK_IP = Const.Uri.API_URI + "/cgi-bin/getcallbackip";

    /**
     * 获取微信服务器IP地址.
     */
    public static IpListResponse getIpList(String token) {
        Map<String, String> params = Params.create("access_token", token).get();
        return HttpUtil.getJsonBean(GET_CALL_BACK_IP, params, IpListResponse.class);
    }
}
