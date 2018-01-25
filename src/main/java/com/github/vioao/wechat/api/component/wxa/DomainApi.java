package com.github.vioao.wechat.api.component.wxa;

import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.bean.entity.component.wxa.Domain;
import com.github.vioao.wechat.bean.response.BaseResponse;
import com.github.vioao.wechat.bean.response.component.wxa.*;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.client.HttpUtil;
import com.github.vioao.wechat.utils.serialize.SerializeUtil;

import java.util.List;
import java.util.Map;

/**
 * 微信小程序接口.<br>
 * 该接口主要用于第三方平台代小程序实现业务.
 *
 * @author vioao
 */
public class DomainApi {

    private static final String MODIFY_DOMAIN = Const.Uri.API_URI + "/wxa/modify_domain";

    /**
     * 设置小程序服务器域名.<br>
     * 授权给第三方的小程序，其服务器域名只可以为第三方的服务器，
     * 当小程序通过第三方发布代码上线后，小程序原先自己配置的服务器域名将被删除，
     * 只保留第三方平台的域名，所以第三方平台在代替小程序发布代码之前，需要调用接口为小程序添加第三方自身的域名。<br>
     * 提示：需要先将域名登记到第三方平台的小程序服务器域名中，才可以调用接口进行配置。
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     * @param domain      微信小程序域名配置.
     */
    public static BaseResponse modifyDomain(String accessToken, Domain domain) {
        String data = SerializeUtil.beanToJson(domain);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(MODIFY_DOMAIN, params, data, BaseResponse.class);
    }

    public static ModifyDomainResponse getDomain(String accessToken) {
        String data = "{\"action\":\"get\"}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(MODIFY_DOMAIN, params, data, ModifyDomainResponse.class);
    }

    private static final String SET_WEBVIEW_DOMAIN = Const.Uri.API_URI + "/wxa/modify_domain";

    /**
     * 设置小程序业务域名（仅供第三方代小程序调用）<br>
     * 授权给第三方的小程序，其业务域名只可以为第三方的服务器，当小程序通过第三方发布代码上线后，
     * 小程序原先自己配置的业务域名将被删除，只保留第三方平台的域名，
     * 所以第三方平台在代替小程序发布代码之前，需要调用接口为小程序添加业务域名。<br>
     * 提示：<br>
     * 1、需要先将域名登记到第三方平台的小程序业务域名中，才可以调用接口进行配置。<br>
     * 2、为授权的小程序配置域名时支持配置子域名，例如第三方登记的业务域名如为qq.com，
     * 则可以直接将qq.com及其子域名（如xxx.qq.com）也配置到授权的小程序中。
     *
     * @param accessToken   第三方平台获取到的该小程序授权的authorizer_access_token
     * @param action        add添加, delete删除, set覆盖, get获取。当参数是get时不需要填webviewdomain字段。
     *                      如果没有action字段参数，则默认见开放平台第三方登记的小程序业务域名全部添加到授权的小程序中
     * @param webviewdomain 小程序业务域名，当action参数是get时不需要此字段。
     */
    public static BaseResponse setWebViewDomain(String accessToken, String action, List<String> webviewdomain) {
        String domains = SerializeUtil.beanToJson(webviewdomain);
        String data = String.format("{\"action\":\"%s\",\"webviewdomain\":%s}", action, domains);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(SET_WEBVIEW_DOMAIN, params, data, BaseResponse.class);
    }
}
