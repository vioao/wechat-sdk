package com.github.vioao.wechat.bean.entity.card.type;

import com.github.vioao.wechat.bean.entity.card.CardType;
import com.github.vioao.wechat.bean.entity.card.base.Card;
import com.github.vioao.wechat.bean.entity.card.base.Cash;

/**
 * 代金券.
 *
 * @author vioao
 */
public class CashCard extends Card {
    private Cash cash;

    public CashCard() {
        super(CardType.CASH.name());
    }

    public Cash getCash() {
        return cash;
    }

    public void setCash(Cash cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "CashCard{" +
                "cardType='" + getCardType() + '\'' +
                "cash=" + cash +
                "} " + super.toString();
    }
}
