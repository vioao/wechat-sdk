package com.github.vioao.wechat.api;

import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.bean.response.BaseResponse;
import com.github.vioao.wechat.bean.response.component.*;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.UrlUtils;
import com.github.vioao.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * 第三方强授权相关接口.
 *
 * @author vioao
 */
public class ComponentApi {

    /**
     * 获取用户授权页.
     *
     * @param componentAppId 第三方平台方appid
     * @param preAuthCode    预授权码
     * @param redirectUri    回调URI
     * @param authType       要授权的帐号类型:
     *                       1: 则商户扫码后，手机端仅展示公众号
     *                       2: 表示仅展示小程序
     *                       3: 表示公众号和小程序都展示
     *                       如果为未制定,则默认小程序和公众号都展示.第三方平台开发者可以使用本字段来控制授权的帐号类型.
     */
    public String getComponentLoginPage(String componentAppId, String preAuthCode,
                                        String redirectUri, String authType) {
        return Const.Uri.MP_URI + "/cgi-bin/componentloginpage?component_appid" + componentAppId
                + "&pre_auth_code=" + preAuthCode + "&redirect_uri=" + UrlUtils.encode(redirectUri)
                + "&auth_type=" + authType;
    }

    public String getComponentLoginPage(String componentAppId, String preAuthCode,
                                        String redirectUri) {
        return Const.Uri.MP_URI + "/cgi-bin/componentloginpage?component_appid" + componentAppId
                + "&pre_auth_code=" + preAuthCode + "&redirect_uri=" + UrlUtils.encode(redirectUri)
                + "&auth_type=3";
    }

    private static final String COMPONENT_API_QUERY_AUTH = Const.Uri.API_URI + "/cgi-bin/component/api_query_auth";

    /**
     * 使用授权码换取公众号的授权信息.
     *
     * @param token 第三方平台access_token
     * @param appid 第三方平台appid
     * @param code  授权code,会在授权成功时返回给第三方平台，详见第三方平台授权流程说明
     */
    public QueryAuthResponse queryAuth(String token, String appid, String code) {
        String data = String.format("{\"component_appid\":\"%1$s\",\"authorization_code\":\"%2$s\"}", appid, code);
        Map<String, String> params = Params.create("component_access_token", token).get();
        return HttpUtil.postJsonBean(COMPONENT_API_QUERY_AUTH, params, data, QueryAuthResponse.class);
    }


    private static final String COMPONENT_API_GET_AUTHORIZER_INFO =
            Const.Uri.API_URI + "/cgi-bin/component/api_get_authorizer_info";

    /**
     * 获取授权方的账户信息.
     *
     * @param token           第三方平台access_token
     * @param componentAppid  服务appid
     * @param authorizerAppid 授权方appid
     */
    public GetAuthorizerInfoResponse getAuthorizerInfo(String token, String componentAppid, String authorizerAppid) {
        String data = String.format("{\"component_appid\":\"%1$s\",\"authorizer_appid\":\"%2$s\"}",
                componentAppid, authorizerAppid);
        Map<String, String> params = Params.create("component_access_token", token).get();
        return HttpUtil.postJsonBean(COMPONENT_API_GET_AUTHORIZER_INFO,
                params, data, GetAuthorizerInfoResponse.class);
    }


    private static final String COMPONENT_TOKEN = Const.Uri.API_URI + "/cgi-bin/component/api_component_token";

    /**
     * 获取第三方平台access_token.
     *
     * @param appid  第三方平台appid
     * @param secret 第三方平台appsecret
     * @param ticket 微信后台推送的ticket，此ticket会定时推送，具体请见本页末尾的推送说明
     */
    public GetComponentTokenResponse getComponentToken(String appid, String secret, String ticket) {
        String format = "{\"component_appid\":\"%1$s\" ,\"component_appsecret\": \"%2$s\","
                + "\"component_verify_ticket\": \"%3$s\"}";
        String data = String.format(format, appid, secret, ticket);
        return HttpUtil.postJsonBean(COMPONENT_TOKEN, null, data, GetComponentTokenResponse.class);
    }


    private static final String COMPONENT_CREATE_PRE_AUTH_CODE =
            Const.Uri.API_URI + "/cgi-bin/component/api_create_preauthcode";

    /**
     * 获取预授权码.
     */
    public CreatePreAuthCodeResponse createPreAuthCode(String token, String appid) {
        String data = String.format("{\"component_appid\":\"%1$s\"}", appid);
        Map<String, String> params = Params.create("component_access_token", token).get();
        return HttpUtil.postJsonBean(COMPONENT_CREATE_PRE_AUTH_CODE, params, data, CreatePreAuthCodeResponse.class);
    }


    private static final String COMPONENT_API_AUTHORIZER_TOKEN =
            Const.Uri.API_URI + "/cgi-bin/component/api_authorizer_token";

    /**
     * 获取（刷新）授权公众号的令牌.
     *
     * @param token                  第三方平台access_token
     * @param componentAppid         第三方平台appid
     * @param authorizerAppid        授权方appid
     * @param authorizerRefreshToken 授权方的刷新令牌，刷新令牌主要用于公众号第三方平台获取和刷新已授权用户的access_token，
     *                               只会在授权时刻提供，请妥善保存。 一旦丢失，只能让用户重新授权，才能再次拿到新的刷新令牌
     */
    public GetAuthorizerTokenResponse getAuthorizerToken(String token, String componentAppid,
                                                         String authorizerAppid, String authorizerRefreshToken) {
        String data = String.format("{\"component_appid\":\"%1$s\",\"authorizer_appid\":\"%2$s\","
                        + "\"authorizer_refresh_token\":\"%3$s\"}",
                componentAppid, authorizerAppid, authorizerRefreshToken);
        Map<String, String> params = Params.create("component_access_token", token).get();
        return HttpUtil.postJsonBean(COMPONENT_API_AUTHORIZER_TOKEN,
                params, data, GetAuthorizerTokenResponse.class);
    }


    private static final String COMPONENT_API_GET_AUTHORIZER_OPTION =
            Const.Uri.API_URI + "/cgi-bin/component/api_get_authorizer_option";

    /**
     * 获取授权方的选项设置信息.
     *
     * @param token           第三方平台access_token
     * @param componentAppid  第三方平台appid
     * @param authorizerAppid 授权公众号appid
     * @param optionName      选项名称
     */
    public GetAuthorizerOptionResponse getAuthorizerOption(String token, String componentAppid,
                                                           String authorizerAppid, String optionName) {
        String data = String.format("{\"component_appid\":\"%1$s\",\"authorizer_appid\":\"%2$s\","
                + "\"option_name\":\"%3$s\"}", componentAppid, authorizerAppid, optionName);
        Map<String, String> params = Params.create("component_access_token", token).get();
        return HttpUtil.postJsonBean(COMPONENT_API_GET_AUTHORIZER_OPTION,
                params, data, GetAuthorizerOptionResponse.class);
    }

    private static final String COMPONENT_API_SET_AUTHORIZER_OPTION =
            Const.Uri.API_URI + "/cgi-bin/component/api_set_authorizer_option";

    /**
     * 设置授权方的选项信息.
     *
     * @param token           第三方平台access_token
     * @param componentAppid  第三方平台appid
     * @param authorizerAppid 授权公众号appid
     * @param optionName      选项名称
     * @param optionValue     设置的选项值
     */
    public BaseResponse apiSetAuthorizerOption(String token, String componentAppid, String authorizerAppid,
                                               String optionName, String optionValue) {
        String format = "{\"component_appid\":\"%1$s\",\"authorizer_appid\":\"%2$s\","
                + "\"option_name\":\"%3$s\",\"option_value\":\"%4$s\"}";
        String data = String.format(format, componentAppid, authorizerAppid, optionName, optionValue);
        Map<String, String> params = Params.create("component_access_token", token).get();
        return HttpUtil.postJsonBean(COMPONENT_API_SET_AUTHORIZER_OPTION, params, data, BaseResponse.class);
    }
}
