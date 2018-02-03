package com.github.vioao.wechat.bean.entity.card.base;

/**
 * 卡券基类.
 *
 * @author vioao
 */
public class Card {

    /**
     * 卡券类型
     */
    private String cardType;

    public Card(String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "card{" +
                "cardType='" + cardType + '\'' +
                '}';
    }
}
