package com.github.vioao.wechat.bean.entity.card.type;

import com.github.vioao.wechat.bean.entity.card.CardType;
import com.github.vioao.wechat.bean.entity.card.base.Card;
import com.github.vioao.wechat.bean.entity.card.base.Groupon;

/**
 * 团购券.
 *
 * @author vioao
 */
public class GrouponCard extends Card {
    private Groupon groupon;

    public GrouponCard() {
        super(CardType.GROUPON.name());
    }

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    @Override
    public String toString() {
        return "GrouponCard{" +
                "cardType='" + getCardType() + '\'' +
                "groupon=" + groupon +
                "} " + super.toString();
    }
}
