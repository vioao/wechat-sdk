package com.github.vioao.wechat.bean.entity.invoice;

import lombok.Builder;

/**
 * 获取授权页链接-请求实体.
 *
 * @author vioao
 */
@Builder
public class AuthUrlRequest {
    private String sPappid; // 开票平台在微信的标识号，商户需要找开票平台提供
    private String order_id; // 订单id，在商户内单笔开票请求的唯一识别号，
    private Integer money; // 订单金额，以分为单位
    private Integer timestamp; // 间戳
    private String source; // 开票来源，app：app开票，web：微信h5开票，wxa：小程序开发票，wap：普通网页开票
    /**
     * 授权成功后跳转页面。本字段只有在source为H5的时候需要填写，引导用户在微信中进行下一步流程。
     * app开票因为从外部app拉起微信授权页，授权完成后自动回到原来的app，故无需填写。
     */
    private String redirectUrl;
    private String ticket; // 从上一环节中获取
    private Integer type; // 授权类型，0：开票授权，1：填写字段开票授权，2：领票授权

    public String getsPappid() {
        return sPappid;
    }

    public void setsPappid(String sPappid) {
        this.sPappid = sPappid;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AuthUrlRequest{" +
                "type=" + type +
                ", sPappid='" + sPappid + '\'' +
                ", order_id='" + order_id + '\'' +
                ", money=" + money +
                ", timestamp=" + timestamp +
                ", source='" + source + '\'' +
                ", redirectUrl='" + redirectUrl + '\'' +
                ", ticket='" + ticket + '\'' +
                '}';
    }
}
