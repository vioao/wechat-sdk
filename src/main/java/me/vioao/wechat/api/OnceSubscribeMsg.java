package me.vioao.wechat.api;

import me.vioao.wechat.Const;

import me.vioao.wechat.bean.entity.template.TemplateMessage;
import me.vioao.wechat.bean.response.BaseResponse;
import me.vioao.wechat.utils.Params;
import me.vioao.wechat.utils.UrlUtils;
import me.vioao.wechat.utils.client.HttpUtil;
import me.vioao.wechat.utils.serialize.SerializeUtil;

import java.util.Map;

/**
 * 一次性订阅消息.
 *
 * @author vioao
 */
public class OnceSubscribeMsg {
    private static final String SUBSCRIBE = Const.Uri.API_URI + "/cgi-bin/msg/template/subscribe";
    private static final String AUTH = Const.Uri.MP_URI + "/subscribemsg";

    /**
     * 获取授权URL。
     * 如果用户点击同意或取消授权，页面将跳转至：redirect_url/?openid=OPENID&template_id=TEMPLATE_ID&action=ACTION&scene=SCENE
     *
     * @param appId       公众号的唯一标识
     * @param scene       重定向后会带上scene参数，开发者可以填0-10000的整形值，用来标识订阅场景值
     * @param templateId  订阅消息模板ID，登录公众平台后台，在接口权限列表处可查看订阅模板ID
     * @param reserved    用于保持请求和回调的状态，授权请后原样带回给第三方。
     *                    该参数可用于防止csrf攻击（跨站请求伪造攻击），建议第三方带上该参数，可设置为简单的随机数加session进行校验，
     *                    开发者可以填写a-zA-Z0-9的参数值，最多128字节，要求做urlencode
     * @param redirectUrl 授权后重定向的回调地址，请使用UrlEncode对链接进行处理。
     *                    注：要求redirect_url的域名要跟登记的业务域名一致，且业务域名不能带路径。
     *                    业务域名需登录公众号，在设置-公众号设置-功能设置里面对业务域名设置。
     */
    public static String getAuthUrl(String appId, String scene, String templateId, String reserved, String redirectUrl) {
        return AUTH + "?action=get_confirm&appid=" + appId + "&scene=" + scene + "&template_id=" + templateId
                + "&reserved=" + UrlUtils.encode(reserved) + "&redirect_url=" + redirectUrl + "#wechat_redirect";
    }

    /**
     * 推送订阅模板消息给到授权微信用户.
     */
    public static BaseResponse subscribe(String accessToken, TemplateMessage message) {
        String data = SerializeUtil.beanToJson(message);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(SUBSCRIBE, params, data, BaseResponse.class);
    }
}
