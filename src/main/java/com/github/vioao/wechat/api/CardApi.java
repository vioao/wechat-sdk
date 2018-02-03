package com.github.vioao.wechat.api;

import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.bean.entity.card.type.*;
import com.github.vioao.wechat.bean.response.BaseResponse;
import com.github.vioao.wechat.bean.response.card.CreateCardResponse;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.client.HttpUtil;
import com.github.vioao.wechat.utils.serialize.SerializeUtil;

import java.util.Map;

/**
 * 微信卡券.
 *
 * @author vioao
 * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141229">微信卡券接口</a>
 */
public class CardApi {
    private static final String CREATE_CARD = Const.Uri.API_URI + "/card/create";

    /**
     * 创建卡券.
     *
     * @param accessToken 接口调用凭证
     * @param json        卡券JSON数据
     * @return {@link CreateCardResponse}
     */
    public static CreateCardResponse create(String accessToken, String json) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(CREATE_CARD, params, json, CreateCardResponse.class);
    }

    /**
     * 创建代金券.
     *
     * @param accessToken 接口调用凭证
     * @param cashCard    代金券
     * @return {@link CreateCardResponse}
     */
    public static CreateCardResponse create(String accessToken, CashCard cashCard) {
        String json = SerializeUtil.beanToJson(cashCard);
        return create(accessToken, json);
    }

    /**
     * 创建折扣券.
     *
     * @param accessToken  接口调用凭证
     * @param discountCard 折扣券
     * @return {@link CreateCardResponse}
     */
    public static CreateCardResponse create(String accessToken, DiscountCard discountCard) {
        String json = SerializeUtil.beanToJson(discountCard);
        return create(accessToken, json);
    }

    /**
     * 创建兑换券.
     *
     * @param accessToken 接口调用凭证
     * @param giftCard    兑换券
     * @return {@link CreateCardResponse}
     */
    public static CreateCardResponse create(String accessToken, GiftCard giftCard) {
        String json = SerializeUtil.beanToJson(giftCard);
        return create(accessToken, json);
    }

    /**
     * 创建团购券.
     *
     * @param accessToken 接口调用凭证
     * @param grouponCard 团购券
     * @return {@link CreateCardResponse}
     */
    public static CreateCardResponse create(String accessToken, GrouponCard grouponCard) {
        String json = SerializeUtil.beanToJson(grouponCard);
        return create(accessToken, json);
    }

    /**
     * 创建优惠券.
     *
     * @param accessToken       接口调用凭证
     * @param generalCouponCard 优惠券
     * @return {@link CreateCardResponse}
     */
    public static CreateCardResponse create(String accessToken, GeneralCouponCard generalCouponCard) {
        String json = SerializeUtil.beanToJson(generalCouponCard);
        return create(accessToken, json);
    }


    private static final String SET_PAY_CELL = Const.Uri.API_URI + "/card/paycell/set";

    /**
     * 设置买单接口.
     *
     * @param accessToken 接口调用凭证
     * @param cardId      卡券ID
     * @param isOpen      是否开启买单功能，填true/false
     * @return {@link BaseResponse}
     */
    public static BaseResponse setPayCell(String accessToken, String cardId, boolean isOpen) {
        String json = "{\"card_id\":\"" + cardId + "\",\"is_open\":" + isOpen + "}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(SET_PAY_CELL, params, json, BaseResponse.class);
    }

    /**
     * 开启买单功能.
     *
     * @param accessToken 接口调用凭证
     * @param cardId      卡券ID
     * @return {@link BaseResponse}
     */
    public static BaseResponse openPayCell(String accessToken, String cardId) {
        return setPayCell(accessToken, cardId, true);
    }

    /**
     * 关闭买单功能.
     *
     * @param accessToken 接口调用凭证
     * @param cardId      卡券ID
     * @return {@link BaseResponse}
     */
    public static BaseResponse closePayCell(String accessToken, String cardId) {
        return setPayCell(accessToken, cardId, false);
    }

    private static final String SET_SELF_CONSUME_CELL = Const.Uri.API_URI + "/card/selfconsumecell/set";

    /**
     * 设置自助核销接口.
     *
     * @param accessToken      接口调用凭证
     * @param cardId           卡券ID
     * @param isOpen           是否开启自助核销功能，填true/false，默认为false
     * @param needVerifyCode   用户核销时是否需要输入验证码， 填true/false， 默认为false
     * @param needRemarkAmount 用户核销时是否需要备注核销金额， 填true/false， 默认为false
     * @return {@link BaseResponse}
     */
    public static BaseResponse setSelfConsumeCell(String accessToken, String cardId,
                                                  boolean isOpen, boolean needVerifyCode, boolean needRemarkAmount) {
        String json = "{\"card_id\":\"" + cardId + "\",\"is_open\":" + isOpen
                + ",\"need_verify_cod\":" + needVerifyCode + ",\"need_remark_amount\":" + needRemarkAmount + "}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(SET_SELF_CONSUME_CELL, params, json, BaseResponse.class);
    }

    /**
     * 开启自助核销功能.
     *
     * @param accessToken 接口调用凭证
     * @param cardId      卡券ID
     * @return {@link BaseResponse}
     */
    public static BaseResponse openSelfConsumeCell(String accessToken, String cardId) {
        return setSelfConsumeCell(accessToken, cardId, true, false, false);
    }

    /**
     * 关闭自助核销功能.
     *
     * @param accessToken 接口调用凭证
     * @param cardId      卡券ID
     * @return {@link BaseResponse}
     */
    public static BaseResponse closeSelfConsumeCell(String accessToken, String cardId) {
        return setSelfConsumeCell(accessToken, cardId, true, false, false);
    }

    private static final String CREATE_QRCODE = Const.Uri.API_URI + "/card/qrcode/create";


}
