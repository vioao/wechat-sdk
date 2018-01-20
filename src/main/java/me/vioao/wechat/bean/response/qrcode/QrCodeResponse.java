package me.vioao.wechat.bean.response.qrcode;

import me.vioao.wechat.bean.response.BaseResponse;

/**
 * 二维码请求Response.
 *
 * @author vioao
 */
public class QrCodeResponse extends BaseResponse {
    private String ticket; //获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
    private Integer expireSeconds; //该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）
    private String url; //二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片

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

    @Override
    public String toString() {
        return "QrCodeResponse{"
                + "ticket='" + ticket + '\''
                + ", expireSeconds=" + expireSeconds
                + ", url='" + url + '\''
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
