package com.github.vioao.wechat.api.component.wxa;

import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.bean.response.BaseResponse;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * 成员管理。<br>
 * 第三方平台在帮助旗下授权的小程序提交代码审核之前，可先让小程序运营者体验，
 * 体验之前需要将运营者的个人微信号添加到该小程序的体验者名单中。
 *
 * @author vioao
 */
public class MemberApi {


    private static final String BIND_TESTER = Const.Uri.API_URI + "/wxa/bind_tester";

    /**
     * 绑定微信用户为小程序体验者 <br>
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     * @param weChatId    微信号
     */
    public static BaseResponse bindTester(String accessToken, String weChatId) {
        String data = String.format("{\"wechatid\":\"%s\"}", weChatId);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(BIND_TESTER, params, data, BaseResponse.class);
    }

    private static final String UN_BIND_TESTER = Const.Uri.API_URI + "/wxa/unbind_tester";

    /**
     * 解除绑定小程序的体验者
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     * @param weChatId    微信号
     */
    public static BaseResponse unBindTester(String accessToken, String weChatId) {
        String data = String.format("{\"wechatid\":\"%s\"}", weChatId);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(UN_BIND_TESTER, params, data, BaseResponse.class);
    }
}
