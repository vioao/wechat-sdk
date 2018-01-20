package me.vioao.wechat.bean.response.ticket;

import me.vioao.wechat.bean.response.BaseResponse;

/**
 * 微信JSAPI Ticket信息.
 *
 * @author vioao
 */
public class TicketResponse extends BaseResponse {
    private String ticket;
    private Integer expiresIn;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "TicketResponse{"
                + "ticket='" + ticket + '\''
                + ", expiresIn=" + expiresIn
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
