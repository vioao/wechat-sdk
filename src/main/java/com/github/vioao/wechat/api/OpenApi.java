package com.github.vioao.wechat.api;

import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.bean.response.BaseResponse;
import com.github.vioao.wechat.bean.response.open.OpenResponse;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * 微信开放平台帐号管理<br>
 * 第三方平台在获得此权限后，可以代替已授权的公众号/小程序创建开放平台帐号或进行绑定/解绑操作。<br>
 * <p>
 * 注:<br>
 * 1. 一个公众号/小程序帐号只可以绑定在一个开放平台帐号下。<br>
 * 2. 授权第三方平台注册的开放平台帐号只可用于获取用户unionid实现用户身份打通，
 * 支持绑定同主体的公众号及小程序，不可独立登录。<br>
 * 3. 第三方平台不可操作（包括绑定/解绑）通过open.weixin.qq.com线上流程注册的开放平台帐号。<br>
 * 4. 公众号只可将此权限集授权给一个第三方平台，授权互斥。<br>
 *
 * @author vioao
 */
public class OpenApi {
    private static final String CREATE = Const.Uri.API_URI + "/cgi-bin/open/create";

    /**
     * 创建开放平台帐号并绑定公众号/小程序<br>
     * 该API用于创建一个开放平台帐号，并将一个尚未绑定开放平台帐号的公众号/小程序绑定至该开放平台帐号上。
     * 新创建的开放平台帐号的主体信息将设置为与之绑定的公众号或小程序的主体。
     *
     * @param accessToken 调用凭证
     * @param appId       授权公众号或小程序的appid
     */
    public static OpenResponse create(String accessToken, String appId) {
        String data = String.format("{\"appid\":\"%s\"}", appId);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(CREATE, params, data, OpenResponse.class);
    }

    private static final String BIND = Const.Uri.API_URI + "/cgi-bin/open/bind";

    /**
     * 将公众号/小程序绑定到开放平台帐号下<br>
     * 该API用于将一个尚未绑定开放平台帐号的公众号或小程序绑定至指定开放平台帐号上。二者须主体相同。
     *
     * @param accessToken 调用凭证
     * @param appId       授权公众号或小程序的appid
     * @param openAppId   开放平台帐号appid
     */
    public static BaseResponse bind(String accessToken, String appId, String openAppId) {
        String data = String.format("{\"appid\":\"%s\",\"open_appid\":\"%s\"}", appId, openAppId);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(BIND, params, data, BaseResponse.class);
    }

    private static final String UN_BIND = Const.Uri.API_URI + "/cgi-bin/open/unbind";

    /**
     * 将公众号/小程序从开放平台帐号下解绑<br>
     * 该API用于将一个公众号或小程序与指定开放平台帐号解绑。
     * 开发者须确认所指定帐号与当前该公众号或小程序所绑定的开放平台帐号一致。
     *
     * @param accessToken 调用凭证
     * @param appId       授权公众号或小程序的appid
     * @param openAppId   开放平台帐号appid
     */
    public static BaseResponse unBind(String accessToken, String appId, String openAppId) {
        String data = String.format("{\"appid\":\"%s\",\"open_appid\":\"%s\"}", appId, openAppId);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(UN_BIND, params, data, BaseResponse.class);
    }

    private static final String GET = Const.Uri.API_URI + "/cgi-bin/open/get";

    /**
     * 获取公众号/小程序所绑定的开放平台帐号<br>
     * 该API用于获取公众号或小程序所绑定的开放平台帐号。
     */
    /**
     * 获取公众号/小程序所绑定的开放平台帐号<br>
     * 该API用于获取公众号或小程序所绑定的开放平台帐号。
     *
     * @param accessToken 调用凭证
     * @param appId       授权公众号或小程序的appid
     */
    public static OpenResponse get(String accessToken, String appId) {
        String data = String.format("{\"appid\":\"%s\"}", appId);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(GET, params, data, OpenResponse.class);
    }
}
