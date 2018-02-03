package com.github.vioao.wechat.bean.entity.card.type;

import com.github.vioao.wechat.bean.entity.card.CardType;
import com.github.vioao.wechat.bean.entity.card.base.Card;
import com.github.vioao.wechat.bean.entity.card.base.Gift;

/**
 * 兑换券.
 *
 * @author vioao
 */
public class GiftCard extends Card {
    private Gift gift;

    public GiftCard() {
        super(CardType.GIFT.name());
    }

    public Gift getGift() {
        return gift;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }

    @Override
    public String toString() {
        return "GiftCard{" +
                "cardType='" + getCardType() + '\'' +
                "gift=" + gift +
                "} " + super.toString();
    }
}
