package com.github.vioao.wechat.api.component.wxa;

import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.bean.response.component.wxa.JsCode2sessionResponse;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * 微信登录.<br>
 * 第三方平台代替小程序实现登录功能请参考一般小程序接口文档 wx.login 部分内容。
 * 除了下述部分以外，其他接口的功能与一般小程序实现方式一致。
 *
 * @author vioao
 * @see <a href="https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1492585163_FtTNA&token=&lang=zh_CN">微信登录DOC</a>
 */
public class LoginApi {
    private static final String JS_CODW_2_SESSION = Const.Uri.API_URI + "/sns/component/jscode2session";

    /**
     * code 换取 session_key.<br>
     * 第三方平台开发者的服务器使用登录凭证 code 以及第三方平台的component_access_token 获取 session_key 和 openid。
     * 其中 session_key 是对用户数据进行加密签名的密钥。为了自身应用安全，session_key 不应该在网络上传输。
     *
     * @param componentAccessToken 第三方平台的 component_access_token
     * @param appId                小程序的AppID
     * @param componentAppId       第三方平台appid
     * @param jsCode               登录时获取的 code
     * @return {@link JsCode2sessionResponse}
     */
    public static JsCode2sessionResponse jscode2session(String componentAccessToken, String appId,
                                                        String componentAppId, String jsCode) {
        Map<String, String> params = Params.create("appid", appId).put("js_code", jsCode)
                .put("grant_type", "authorization_code").put("component_appid", componentAppId)
                .put("component_access_token", componentAccessToken).get();
        return HttpUtil.getJsonBean(JS_CODW_2_SESSION, params, JsCode2sessionResponse.class);
    }
}
