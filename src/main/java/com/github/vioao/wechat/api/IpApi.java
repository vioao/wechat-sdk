package com.github.vioao.wechat.api;

import com.github.vioao.wechat.bean.response.ip.IpListResponse;
import com.github.vioao.wechat.utils.client.HttpUtil;
import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.utils.Params;

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
