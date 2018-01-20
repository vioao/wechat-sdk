package me.vioao.wechat.bean.entity.menu;

import java.util.List;

/**
 * 菜单按钮.
 *
 * @author vioao
 */
public class Button {
    private String type; // 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型,media_id,view_limited
    private String name; //	菜单标题，不超过16个字节，子菜单不超过60个字节
    private String key; // click等点击类型必须;菜单KEY值，用于消息接口推送，不超过128字节

    // view、miniprogram类型必须
    // 网页 链接，用户点击菜单可打开链接，不超过1024字节。 type为miniprogram时，不支持小程序的老版本客户端将打开本url
    private String url;
    private String mediaId; //media_id类型和view_limited类型必须;调用新增永久素材接口返回的合法media_id
    private String appid; //miniprogram类型必须;小程序的appid（仅认证公众号可配置）
    private String pagepath; //miniprogram类型必须;小程序的页面路径
    private List<Button> subButton; // 二级菜单数组，个数应为1~5个

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }

    public List<Button> getSubButton() {
        return subButton;
    }

    public void setSubButton(List<Button> subButton) {
        this.subButton = subButton;
    }

    @Override
    public String toString() {
        return "Button{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", url='" + url + '\'' +
                ", mediaId='" + mediaId + '\'' +
                ", appid='" + appid + '\'' +
                ", pagepath='" + pagepath + '\'' +
                ", subButton=" + subButton +
                '}';
    }
}