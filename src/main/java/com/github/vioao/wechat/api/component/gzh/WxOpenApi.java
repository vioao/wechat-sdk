package com.github.vioao.wechat.api.component.gzh;

import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.bean.response.BaseResponse;
import com.github.vioao.wechat.bean.response.component.wxa.WxaMpLinkGetResponse;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * 为帮助公众号通过第三方关联、管理小程序，公众平台把关联小程序及相关管理功能添加到 “小程序管理”权限集。
 * 公众号需要先把该权限集授权给第三方平台，第三方平台才可以调用此接口进行关联和管理操作。
 *
 * @author vioao
 * @see <a href="https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1513255108_gFkRI&token=&lang=zh_CN">小程序管理权限集DOC</a>
 */
public class WxOpenApi {

    private static final String WXA_MP_LINK_GET = Const.Uri.API_URI + "/wxopen/wxamplinkget";

    /**
     * 获取公众号关联的小程序.
     *
     * @param accessToken 接口调研凭证
     * @return {@link WxaMpLinkGetResponse}
     */
    public static WxaMpLinkGetResponse getWxaMpLink(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.getJsonBean(WXA_MP_LINK_GET, params, WxaMpLinkGetResponse.class);
    }


    private static final String WXA_MP_LINK = Const.Uri.API_URI + "/wxopen/wxamplink";

    /**
     * 关联小程序.<br>
     * 关联流程（需要公众号和小程序管理员双方确认）：<br>
     * 1.第三方平台调用接口发起关联<br>
     * 2 公众号管理员收到模板消息，同意关联小程序。<br>
     * 3.小程序管理员收到模板消息，同意关联公众号。<br>
     * 4.关联成功<br>
     * 等待管理员同意的中间状态可使用“获取公众号关联的小程序”接口进行查询。
     *
     * @param appId       小程序appid
     * @param notifyUsers 是否发送模板消息通知公众号粉丝
     * @param showProfile 是否展示公众号主页中
     * @param accessToken 调用凭证
     * @return {@link BaseResponse}
     */
    public static BaseResponse wxaMpLink(String appId, boolean notifyUsers, boolean showProfile,
                                         String accessToken) {
        String notifyUsersStr = notifyUsers ? "1" : "0";
        String showProfileStr = showProfile ? "1" : "0";
        String data = String.format("{\"appid\":\"%s\",\"notify_users\":\"%s\",\"showProfile\":\"%s\"}",
                appId, notifyUsersStr, showProfileStr);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(WXA_MP_LINK, params, data, BaseResponse.class);
    }

    private static final String WXA_MP_UNLINK = Const.Uri.API_URI + "/wxopen/wxampunlink";

    /**
     * 解除已关联的小程序. <br>
     *
     * @param appId       小程序appid
     * @param accessToken 调用凭证
     * @return {@link BaseResponse}
     */
    public static BaseResponse wxaMpUnLink(String appId, String accessToken) {
        String data = String.format("{\"appid\":\"%s\"}", appId);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(WXA_MP_UNLINK, params, data, BaseResponse.class);
    }
}
