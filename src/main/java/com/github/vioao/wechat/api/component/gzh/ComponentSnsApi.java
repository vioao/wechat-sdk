package com.github.vioao.wechat.api.component.gzh;

import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.api.SnsApi;
import com.github.vioao.wechat.bean.response.sns.SnsTokenResponse;
import com.github.vioao.wechat.bean.response.user.UserResponse;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.UrlUtils;
import com.github.vioao.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * 代公众号发起网页授权.
 *
 * @author vioao
 * @see <a href="https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1419318590&token=&lang=zh_CN">WeChat DOC</a>
 */
public class ComponentSnsApi {

    /**
     * 第一步：请求CODE<br>
     * 生成网页授权URL  (第三方平台开发).
     *
     * @param appId          公众号的唯一标识
     * @param redirectUri    授权后重定向的回调链接地址
     * @param detail         应用授权作用域:
     *                       false: snsapi_base;不弹出授权页面，直接跳转，只能获取用户openid.
     *                       true: snsapi_userinfo;弹出授权页面，可通过openid拿到昵称、性别、所在地.
     *                       并且，即使在未关注的情况下，只要用户授权，也能获取其信息.
     * @param state          重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
     * @param componentAppId 第三方平台开发，可以为空。
     *                       服务方的appid，在申请创建公众号服务成功后，可在公众号服务详情页找到
     * @return 授权URL
     */
    public static String getComponentOath2Url(String appId, String redirectUri, boolean detail,
                                              String state, String componentAppId) {
        StringBuilder sb = new StringBuilder();
        sb.append(Const.Uri.OPEN_URI + "/connect/oauth2/authorize?")
                .append("appid=").append(appId)
                .append("&redirect_uri=").append(UrlUtils.encode(redirectUri))
                .append("&response_type=code")
                .append("&scope=").append(detail ? "snsapi_userinfo" : "snsapi_base")
                .append("&state=").append(state == null ? "" : state)
                .append("&component_appid=").append(componentAppId);
        sb.append("#wechat_redirect");
        return sb.toString();
    }

    private static final String SNS_OAUTH2_COMPONENT_TOKEN = Const.Uri.API_URI + "/sns/oauth2/component/access_token";

    /**
     * 第二步：通过code换取网页授权access_token (第三方平台开发).
     *
     * @param appId                公众号的唯一标识
     * @param code                 填写第一步获取的code参数
     * @param componentAppId       服务开发方的appid
     * @param componentAccessToken 服务开发方的access_token
     */
    public static SnsTokenResponse getAccessToken(String appId, String code, String componentAppId,
                                                  String componentAccessToken) {
        Map<String, String> params = Params.create("appid", appId).put("code", code).put("code", code)
                .put("grant_type", "authorization_code").put("component_appid", componentAppId)
                .put("component_access_token", componentAccessToken).get();
        return HttpUtil.getJsonBean(SNS_OAUTH2_COMPONENT_TOKEN, params, SnsTokenResponse.class);
    }

    private static final String SNS_OAUTH2_REFRESH_TOKEN = Const.Uri.API_URI + "/sns/oauth2/component/refresh_token";

    /**
     * 第三步：刷新access_token（如果需要）.
     *
     * @param componentAppId       服务开发商的appid
     * @param componentAccessToken 服务开发方的access_token
     * @param appId                公众号的唯一标识
     * @param refreshToken         填写通过access_token获取到的refresh_token参数
     */
    public static SnsTokenResponse oauth2RefreshToken(String componentAppId, String componentAccessToken,
                                                      String appId, String refreshToken) {
        Map<String, String> params = Params.create("appid", appId).put("refresh_token", refreshToken)
                .put("grant_type", "refresh_token").put("component_appid", componentAppId)
                .put("component_access_token", componentAccessToken).get();
        return HttpUtil.getJsonBean(SNS_OAUTH2_REFRESH_TOKEN, params, SnsTokenResponse.class);
    }

    /**
     * 拉取用户信息(需scope为 snsapi_userinfo).
     *
     * @param accessToken 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     * @param openid      用户的唯一标识
     * @param lang        国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     */
    public static UserResponse getIUserInfo(String accessToken, String openid, String lang) {
        return SnsApi.getUserInfo(accessToken, openid, lang);
    }

    /**
     * 拉取用户信息(需scope为 snsapi_userinfo).
     */
    public static UserResponse getUserInfo(String accessToken, String openid) {
        return getIUserInfo(accessToken, openid, "zh_CN");
    }
}
