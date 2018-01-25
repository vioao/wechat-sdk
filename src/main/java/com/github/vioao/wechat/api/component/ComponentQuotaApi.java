package com.github.vioao.wechat.api.component;

import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.bean.response.BaseResponse;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * 第三方平台对其所有API调用次数清零（只与第三方平台相关，与公众号无关，接口如api_component_token）.
 *
 * @author vioao
 */
public class ComponentQuotaApi {
    private static final String CLEAR_QUOTA = Const.Uri.API_URI + "/cgi-bin/component/clear_quota";

    /**
     * 创建开放平台帐号并绑定公众号/小程序<br>
     * 该API用于创建一个开放平台帐号，并将一个尚未绑定开放平台帐号的公众号/小程序绑定至该开放平台帐号上。
     * 新创建的开放平台帐号的主体信息将设置为与之绑定的公众号或小程序的主体。
     *
     * @param componentAccessToken 调用接口凭据
     * @param componentAppId       第三方平台APPID
     */
    public static BaseResponse clearQuota(String componentAccessToken, String componentAppId) {
        String data = String.format("{\"component_appid\":\"%s\"}", componentAppId);
        Map<String, String> params = Params.create("component_access_token", componentAccessToken).get();
        return HttpUtil.postJsonBean(CLEAR_QUOTA, params, data, BaseResponse.class);
    }
}
