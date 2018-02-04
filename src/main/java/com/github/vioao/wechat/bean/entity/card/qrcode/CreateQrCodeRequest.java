package com.github.vioao.wechat.bean.entity.card.qrcode;

/**
 * 创建二维码请求参数.
 *
 * @author vioao
 */
public class CreateQrCodeRequest {
    /**
     * 卡券领取类型：QR_CARD,QR_MULTIPLE_CARD
     *
     * @see ActionName
     */
    private String actionName;
    /**
     * 指定二维码的有效时间，范围是60 ~ 1800秒。不填默认为365天有效
     */
    private Integer expireSeconds;
    private ActionInfo actionInfo;

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Integer getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(Integer expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public ActionInfo getActionInfo() {
        return actionInfo;
    }

    public void setActionInfo(ActionInfo actionInfo) {
        this.actionInfo = actionInfo;
    }

    @Override
    public String toString() {
        return "CreateQrCodeRequest{" +
                "actionName='" + actionName + '\'' +
                ", expireSeconds=" + expireSeconds +
                ", actionInfo=" + actionInfo +
                '}';
    }
}
