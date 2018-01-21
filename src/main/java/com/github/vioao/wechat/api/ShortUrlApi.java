package com.github.vioao.wechat.api;

import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.bean.response.shorturl.ShortUrlResponse;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * 长链接转短链接接口.<br>
 * 主要使用场景： 开发者用于生成二维码的原链接（商品、支付二维码等）太长导致扫码速度和成功率下降，
 * 将原长链接通过此接口转成短链接再生成二维码将大大提升扫码速度和成功率。
 *
 * @author vioao
 */
public class ShortUrlApi {

    /**
     * 长链接转短链接.
     */
    public static ShortUrlResponse toShortUrl(String accessToken, String longUrl) {
        return toShortUrl(accessToken, "long2short", longUrl);
    }

    private static final String SHORT_URL = Const.Uri.API_URI + "/cgi-bin/shorturl";

    /**
     * 将一条长链接转成短链接.
     *
     * @param accessToken 公众号的全局唯一接口调用凭据
     * @param action      此处填long2short，代表长链接转短链接
     * @param longUrl     需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url
     */
    private static ShortUrlResponse toShortUrl(String accessToken, String action, String longUrl) {
        String data = "{\"action\":\"" + action + "\",\"long_url\":\"" + longUrl + "\"}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(SHORT_URL, params, data, ShortUrlResponse.class);
    }
}
