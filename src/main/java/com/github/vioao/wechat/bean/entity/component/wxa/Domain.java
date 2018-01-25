package com.github.vioao.wechat.bean.entity.component.wxa;

import lombok.Builder;

import java.util.List;

/**
 * 微信小程序域名设置.
 *
 * @author vioao
 */
@Builder
public class Domain {
    private String action; // add添加, delete删除, set覆盖, get获取。当参数是get时不需要填四个域名字段。
    private List<String> requestdomain; // request合法域名，当action参数是get时不需要此字段。
    private List<String> wsrequestdomain; // socket合法域名，当action参数是get时不需要此字段。
    private List<String> uploaddomain; // uploadFile合法域名，当action参数是get时不需要此字段。
    private List<String> downloaddomain; // downloadFile合法域名，当action参数是get时不需要此字段。

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<String> getRequestdomain() {
        return requestdomain;
    }

    public void setRequestdomain(List<String> requestdomain) {
        this.requestdomain = requestdomain;
    }

    public List<String> getWsrequestdomain() {
        return wsrequestdomain;
    }

    public void setWsrequestdomain(List<String> wsrequestdomain) {
        this.wsrequestdomain = wsrequestdomain;
    }

    public List<String> getUploaddomain() {
        return uploaddomain;
    }

    public void setUploaddomain(List<String> uploaddomain) {
        this.uploaddomain = uploaddomain;
    }

    public List<String> getDownloaddomain() {
        return downloaddomain;
    }

    public void setDownloaddomain(List<String> downloaddomain) {
        this.downloaddomain = downloaddomain;
    }

    @Override
    public String toString() {
        return "ModifyDomain{" +
                "action='" + action + '\'' +
                ", requestdomain=" + requestdomain +
                ", wsrequestdomain=" + wsrequestdomain +
                ", uploaddomain=" + uploaddomain +
                ", downloaddomain=" + downloaddomain +
                '}';
    }
}
