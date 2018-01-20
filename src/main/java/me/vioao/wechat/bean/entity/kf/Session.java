package me.vioao.wechat.bean.entity.kf;

/**
 * 客户会话状态.
 *
 * @author vioao
 */
public class Session {
    private String kfAccount;
    private Long createtime;

    public String getKfAccount() {
        return kfAccount;
    }

    public void setKfAccount(String kfAccount) {
        this.kfAccount = kfAccount;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }
}
