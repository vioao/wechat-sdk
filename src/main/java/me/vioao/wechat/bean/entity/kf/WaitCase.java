package me.vioao.wechat.bean.entity.kf;

/**
 * 未接入会话信息.
 *
 * @author vioao
 */
public class WaitCase {
    private Long latestTime; //粉丝的最后一条消息的时间
    private String openid; //粉丝的openid

    public Long getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(Long latestTime) {
        this.latestTime = latestTime;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Override
    public String toString() {
        return "WaitCase{" +
                "latestTime=" + latestTime +
                ", openid='" + openid + '\'' +
                '}';
    }
}
