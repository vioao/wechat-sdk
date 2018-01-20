package me.vioao.wechat.bean.entity.datacube;

/**
 * 用户分析数据Item.
 *
 * @author vioao
 */
public class UserDataCube {
    private String refDate; // 数据的日期

    // 用户的渠道，数值代表的含义如下：
    // 0代表其他合计 1代表公众号搜索 17代表名片分享 30代表扫描二维码
    // 43代表图文页右上角菜单 51代表支付后关注（在支付完成页）
    // 57代表图文页内公众号名称 75代表公众号文章广告 78代表朋友圈广告
    private Integer userSource;  // 数据的日期

    private Integer newUser;  // 新增的用户数量
    private Integer cancelUser;  // 取消关注的用户数量，new_user减去cancel_user即为净增用户数量
    private Integer cumulateUser;  // 总用户量


    public String getRefDate() {
        return refDate;
    }

    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    public Integer getUserSource() {
        return userSource;
    }

    public void setUserSource(Integer userSource) {
        this.userSource = userSource;
    }

    public Integer getNewUser() {
        return newUser;
    }

    public void setNewUser(Integer newUser) {
        this.newUser = newUser;
    }

    public Integer getCancelUser() {
        return cancelUser;
    }

    public void setCancelUser(Integer cancelUser) {
        this.cancelUser = cancelUser;
    }

    public Integer getCumulateUser() {
        return cumulateUser;
    }

    public void setCumulateUser(Integer cumulateUser) {
        this.cumulateUser = cumulateUser;
    }

    @Override
    public String toString() {
        return "UserDataCube{" +
                "refDate='" + refDate + '\'' +
                ", userSource=" + userSource +
                ", newUser=" + newUser +
                ", cancelUser=" + cancelUser +
                ", cumulateUser=" + cumulateUser +
                '}';
    }
}
