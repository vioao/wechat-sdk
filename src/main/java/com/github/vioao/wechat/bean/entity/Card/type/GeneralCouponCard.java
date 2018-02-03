package com.github.vioao.wechat.bean.entity.card.type;

import com.github.vioao.wechat.bean.entity.card.CardType;
import com.github.vioao.wechat.bean.entity.card.base.Card;
import com.github.vioao.wechat.bean.entity.card.base.GeneralCoupon;

/**
 * 优惠券.
 *
 * @author vioao
 */
public class GeneralCouponCard extends Card {
    private GeneralCoupon generalCoupon;

    public GeneralCouponCard() {
        super(CardType.GIFT.name());
    }

    public GeneralCoupon getGeneralCoupon() {
        return generalCoupon;
    }

    public void setGeneralCoupon(GeneralCoupon generalCoupon) {
        this.generalCoupon = generalCoupon;
    }

    @Override
    public String toString() {
        return "GeneralCouponCard{" +
                "cardType='" + getCardType() + '\'' +
                "generalCoupon=" + generalCoupon +
                "} " + super.toString();
    }
}
