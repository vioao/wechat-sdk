package me.vioao.wechat.api;

import me.vioao.wechat.Const;
import me.vioao.wechat.bean.MediaFile;
import me.vioao.wechat.bean.response.qrcode.QrCodeResponse;
import me.vioao.wechat.utils.Params;
import me.vioao.wechat.utils.UrlUtils;
import me.vioao.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * 二维码API.
 * 使用该接口可以获得多个带不同场景值的二维码，用户扫描后，公众号可以接收到事件推送.<br>
 * 目前有2种类型的二维码：<br>
 * 1、临时二维码，是有过期时间的，最长可以设置为在二维码生成后的30天（即2592000秒）后过期，但能够生成较多数量。
 * 临时二维码主要用于帐号绑定等不要求二维码永久保存的业务场景<br>
 * 2、永久二维码，是无过期时间的，但数量较少（目前为最多10万个）。永久二维码主要用于适用于帐号绑定、用户来源统计等场景。
 * <p>
 * 用户扫描带场景值二维码时，可能推送以下两种事件：<br>
 * 1. 如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。<br>
 * 2. 如果用户已经关注公众号，在用户扫描后会自动进入会话，微信也会将带场景值扫描事件推送给开发者。<br>
 * <p>
 * 获取带参数的二维码的过程包括两步，首先创建二维码ticket，然后凭借ticket到指定URL换取二维码。
 *
 * @author vio
 */
public class QrCodeApi {

    private static final String QR_CODE_CREATE = Const.Uri.API_URI + "/cgi-bin/qrcode/create";

    /**
     * 创建二维码.
     * 每次创建二维码ticket需要提供一个开发者自行设定的参数（scene_id）
     * 分别介绍临时二维码和永久二维码的创建二维码ticket过程.
     *
     * @param accessToken   公众号的全局唯一接口调用凭据
     * @param expireSeconds 该二维码有效时间，以秒为单位。最大不超过2592000（即30天）。
     * @param actionName    二维码类型，QR_SCENE为临时的整型参数值，QR_LIMIT_SCENE为永久的整型参数值，
     * @param sceneId       场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     */
    private static QrCodeResponse create(String accessToken, Integer expireSeconds, String actionName, long sceneId) {
        String data = String.format("{" + (expireSeconds == null ? "%1$s" : "\"expire_seconds\": %1$s, ")
                        + "\"action_name\": \"%2$s\", \"action_info\": {\"scene\": {\"scene_id\": %3$d}}}",
                expireSeconds == null ? "" : expireSeconds, actionName, sceneId);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(QR_CODE_CREATE, params, data, QrCodeResponse.class);
    }

    /**
     * 创建临时二维码.
     *
     * @param accessToken   公众号的全局唯一接口调用凭据
     * @param expireSeconds 最大不超过2592000 秒（即30天）
     * @param sceneId       场景值ID，32位非0整型
     */
    public static QrCodeResponse createTemp(String accessToken, int expireSeconds, long sceneId) {
        return create(accessToken, expireSeconds, "QR_SCENE", sceneId);
    }

    /**
     * 创建持久二维码.
     *
     * @param accessToken 公众号的全局唯一接口调用凭据
     * @param sceneId     场景值ID 1-100000
     */
    public static QrCodeResponse createFinal(String accessToken, long sceneId) {
        return create(accessToken, null, "QR_LIMIT_SCENE", sceneId);
    }

    private static final String QR_CODE_SHOW = Const.Uri.MP_URI + "/cgi-bin/showqrcode";

    /**
     * 下载二维码.
     * ticket正确情况下，http 返回码是200，是一张图片，可以直接展示或者下载。
     *
     * @param ticket 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
     */
    public static MediaFile download(String ticket) {
        Map<String, String> params = Params.create("ticket", UrlUtils.encode(ticket)).get();
        return HttpUtil.download(QR_CODE_SHOW, params);
    }
}
