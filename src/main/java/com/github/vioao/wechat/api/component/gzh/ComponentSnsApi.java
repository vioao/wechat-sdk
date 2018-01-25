package com.github.vioao.wechat.api.component.gzh;

import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.bean.response.sns.SnsTokenResponse;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.UrlUtils;
import com.github.vioao.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * 代公众号发起网页授权.
 *
 * @author vioao
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
    public static String generateComponentOath2Url(String appId, String redirectUri, boolean detail,
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
    public static SnsTokenResponse oauth2ComponentAccessToken(String appId, String code, String componentAppId,
                                                              String componentAccessToken) {
        Map<String, String> params = Params.create("appid", appId).put("code", code).put("code", code)
                .put("grant_type", "authorization_code").put("component_appid", componentAppId)
                .put("component_access_token", componentAccessToken).get();
        return HttpUtil.getJsonBean(SNS_OAUTH2_COMPONENT_TOKEN, params, SnsTokenResponse.class);
    }
}
