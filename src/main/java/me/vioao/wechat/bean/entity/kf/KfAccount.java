package me.vioao.wechat.bean.entity.kf;

/**
 * 客服信息.
 *
 * @author vioao
 */
public class KfAccount {
    private String kfAccount; //完整客服帐号，格式为：帐号前缀@公众号微信号
    private String kfNick; //客服昵称
    private String kfId; //客服编号
    private String kfHeadimgurl; //客服头像
    private String kfWx; //如果客服帐号已绑定了客服人员微信号， 则此处显示微信号
    private String inviteWx; //如果客服帐号尚未绑定微信号，但是已经发起了一个绑定邀请， 则此处显示绑定邀请的微信号
    private String inviteStatus; //邀请的状态，有等待确认“waiting”，被拒绝“rejected”， 过期“expired”
    private Long inviteExpireTime; //如果客服帐号尚未绑定微信号，但是已经发起过一个绑定邀请， 邀请的过期时间，为unix 时间戳
    private Integer status; //客服在线状态，目前为：1、web 在线
    private Integer acceptedCase; //客服当前正在接待的会话数

    public String getKfAccount() {
        return kfAccount;
    }

    public void setKfAccount(String kfAccount) {
        this.kfAccount = kfAccount;
    }

    public String getKfNick() {
        return kfNick;
    }

    public void setKfNick(String kfNick) {
        this.kfNick = kfNick;
    }

    public String getKfId() {
        return kfId;
    }

    public void setKfId(String kfId) {
        this.kfId = kfId;
    }

    public String getKfHeadimgurl() {
        return kfHeadimgurl;
    }

    public void setKfHeadimgurl(String kfHeadimgurl) {
        this.kfHeadimgurl = kfHeadimgurl;
    }

    public String getKfWx() {
        return kfWx;
    }

    public void setKfWx(String kfWx) {
        this.kfWx = kfWx;
    }

    public String getInviteWx() {
        return inviteWx;
    }

    public void setInviteWx(String inviteWx) {
        this.inviteWx = inviteWx;
    }

    public String getInviteStatus() {
        return inviteStatus;
    }

    public void setInviteStatus(String inviteStatus) {
        this.inviteStatus = inviteStatus;
    }

    public Long getInviteExpireTime() {
        return inviteExpireTime;
    }

    public void setInviteExpireTime(Long inviteExpireTime) {
        this.inviteExpireTime = inviteExpireTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAcceptedCase() {
        return acceptedCase;
    }

    public void setAcceptedCase(Integer acceptedCase) {
        this.acceptedCase = acceptedCase;
    }

    @Override
    public String toString() {
        return "KfAccount{" +
                "kfAccount='" + kfAccount + '\'' +
                ", kfNick='" + kfNick + '\'' +
                ", kfId='" + kfId + '\'' +
                ", kfHeadimgurl='" + kfHeadimgurl + '\'' +
                ", kfWx='" + kfWx + '\'' +
                ", inviteWx='" + inviteWx + '\'' +
                ", inviteStatus='" + inviteStatus + '\'' +
                ", inviteExpireTime=" + inviteExpireTime +
                ", status=" + status +
                ", acceptedCase=" + acceptedCase +
                '}';
    }
}
