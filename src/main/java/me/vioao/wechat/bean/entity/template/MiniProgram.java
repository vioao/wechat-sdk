package me.vioao.wechat.bean.entity.template;

/**
 * 模板消息-小程序组件.
 *
 * @author vioao
 */
public class MiniProgram {
    private String appid; // 所需跳转到的小程序appid（该小程序appid必须与发模板消息的公众号是绑定关联关系）
    private String pagepath; // 所需跳转到小程序的具体页面路径，支持带参数,（示例index?foo=bar）

    public MiniProgram(String appid, String pagepath) {
        this.appid = appid;
        this.pagepath = pagepath;
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
}
