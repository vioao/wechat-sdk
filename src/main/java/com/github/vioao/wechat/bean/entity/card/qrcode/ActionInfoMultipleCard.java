package com.github.vioao.wechat.bean.entity.card.qrcode;

import java.util.List;

/**
 * @author vioao
 */
public class ActionInfoMultipleCard {
    private List<ActionInfoCard> cardList;

    public List<ActionInfoCard> getCardList() {
        return cardList;
    }

    public void setCardList(List<ActionInfoCard> cardList) {
        this.cardList = cardList;
    }

    @Override
    public String toString() {
        return "ActionInfoMultipleCard{" +
                "cardList=" + cardList +
                '}';
    }
}
