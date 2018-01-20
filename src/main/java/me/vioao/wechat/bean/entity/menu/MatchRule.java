package me.vioao.wechat.bean.entity.menu;

/**
 * 个性化菜单匹配规则.
 *
 * @author vioao
 */
public class MatchRule {
    private Integer tagId;
    private Integer sex;
    private String country;
    private String province;
    private String city;
    private String clientPlatformType; //客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getClientPlatformType() {
        return clientPlatformType;
    }

    public void setClientPlatformType(String clientPlatformType) {
        this.clientPlatformType = clientPlatformType;
    }

    @Override
    public String toString() {
        return "MatchRule{" +
                "tagId=" + tagId +
                ", sex=" + sex +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", clientPlatformType='" + clientPlatformType + '\'' +
                '}';
    }
}
