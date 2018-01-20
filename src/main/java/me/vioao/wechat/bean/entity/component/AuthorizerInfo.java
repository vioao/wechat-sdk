package me.vioao.wechat.bean.entity.component;

/**
 * 授权方的基本账户信息.
 *
 * @author vioao
 */
public class AuthorizerInfo {
    private String nickName; //授权方昵称
    private String headImg; //授权方头像
    private String userName; //授权方公众号原始id
    private String alias; //授权方公众号设置的微信号，可能为空。
    private ServiceTypeInfo serviceTypeInfo; //授权方公众号类型
    private VerifyTypeInfo verifyTypeInfo; //授权方认证类型

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public ServiceTypeInfo getServiceTypeInfo() {
        return serviceTypeInfo;
    }

    public void setServiceTypeInfo(ServiceTypeInfo serviceTypeInfo) {
        this.serviceTypeInfo = serviceTypeInfo;
    }

    public VerifyTypeInfo getVerifyTypeInfo() {
        return verifyTypeInfo;
    }

    public void setVerifyTypeInfo(VerifyTypeInfo verifyTypeInfo) {
        this.verifyTypeInfo = verifyTypeInfo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * 授权方公众号类型.
     */
    public static class ServiceTypeInfo {
        private Integer id; //0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

    /**
     * 授权方认证类型.
     */
    public static class VerifyTypeInfo {
        // -1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，
        // 4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

}
