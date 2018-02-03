package com.github.vioao.wechat.bean.entity.card.type;

import com.github.vioao.wechat.bean.entity.card.CardType;
import com.github.vioao.wechat.bean.entity.card.base.Card;
import com.github.vioao.wechat.bean.entity.card.base.Discount;

/**
 * 折扣券.
 *
 * @author vioao
 */
public class DiscountCard extends Card {
    private Discount discount;

    public DiscountCard() {
        super(CardType.DISCOUNT.name());
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "DiscountCard{" +
                "cardType='" + getCardType() + '\'' +
                "discount=" + discount +
                "} " + super.toString();
    }
}
