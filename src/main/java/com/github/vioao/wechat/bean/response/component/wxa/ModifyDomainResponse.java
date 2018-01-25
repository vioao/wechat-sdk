package com.github.vioao.wechat.bean.response.component.wxa;

import com.github.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 修改域名接口返回.
 *
 * @author vioao
 */
public class ModifyDomainResponse extends BaseResponse {
    private List<String> requestdomain; // request合法域名
    private List<String> wsrequestdomain; // socket合法域名
    private List<String> uploaddomain; // uploadFile合法域名
    private List<String> downloaddomain; // downloadFile合法域名

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
        return "ModifyDomainResponse{"
                + "requestdomain=" + requestdomain
                + ", wsrequestdomain=" + wsrequestdomain
                + ", uploaddomain=" + uploaddomain
                + ", downloaddomain=" + downloaddomain
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
