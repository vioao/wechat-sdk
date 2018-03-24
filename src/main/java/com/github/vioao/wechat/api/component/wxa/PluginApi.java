package com.github.vioao.wechat.api.component.wxa;

import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.bean.response.BaseResponse;
import com.github.vioao.wechat.bean.response.component.wxa.plugin.PluginListResponse;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * 小程序插件管理权限集相关API.  <br>
 * 插件管理权限集用于第三方代小程序管理插件，具体包括：添加插件、查询已添加的插件及删除插件
 *
 * @author vioao
 */
public class PluginApi {
    private static final String APPLY = Const.Uri.API_URI + "/wxa/plugin";

    /**
     * 申请使用插件 <br>
     * 此接口用于小程序向插件开发者发起使用插件的申请.
     *
     * @param accessToken accessToken
     * @param pluginAppId 插件appid
     */
    public static BaseResponse apply(String accessToken, String pluginAppId) {
        String data = String.format("{\"action\":\"apply\",\"plugin_appid\":\"%s\"}", pluginAppId);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(APPLY, params, data, BaseResponse.class);
    }


    private static final String LIST = Const.Uri.API_URI + "/wxa/plugin";

    /**
     * 查询已添加的插件 <br>
     * 此接口用于查询小程序目前已添加的插件（包括确认中、已通过、已拒绝、已超时状态）.
     *
     * @param accessToken accessToken
     */
    public static PluginListResponse list(String accessToken) {
        String data = "{\"action\":\"list\"}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(LIST, params, data, PluginListResponse.class);
    }


    private static final String UN_BIND = Const.Uri.API_URI + "/wxa/plugin";

    /**
     * 删除已添加的插件 <br>
     * 此接口用于小程序向插件开发者发起使用插件的申请.
     *
     * @param accessToken accessToken
     * @param pluginAppId 插件appid
     */
    public static BaseResponse unbind(String accessToken, String pluginAppId) {
        String data = String.format("{\"action\":\"unbind\",\"plugin_appid\":\"%s\"}", pluginAppId);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(UN_BIND, params, data, BaseResponse.class);
    }
}
