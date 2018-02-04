package com.github.vioao.wechat.bean.response.card;

import com.github.vioao.wechat.bean.response.BaseResponse;

/**
 * 创建二维码接口返回.
 *
 * @author vioao
 */
public class CreateQrCodeResponse extends BaseResponse {

    /**
     * 获取的二维码ticket，凭借此ticket调用通过ticket换取二维码接口可以在有效时间内换取二维码。
     */
    private String ticket;

    /**
     * 二维码的有效时间，范围是60 ~ 1800秒。不填默认为365天有效
     */
    private Integer expireSeconds;

    /**
     * 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
     */
    private String url;

    /**
     * 二维码显示地址，点击后跳转二维码页面
     */
    private String showQrcodeUrl;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(Integer expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShowQrcodeUrl() {
        return showQrcodeUrl;
    }

    public void setShowQrcodeUrl(String showQrcodeUrl) {
        this.showQrcodeUrl = showQrcodeUrl;
    }

    @Override
    public String toString() {
        return "CreateQrCodeResponse{"
                + "errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + ", ticket='" + ticket + '\''
                + ", expireSeconds=" + expireSeconds
                + ", url='" + url + '\''
                + ", showQrcodeUrl='" + showQrcodeUrl + '\''
                + '}';
    }
}
