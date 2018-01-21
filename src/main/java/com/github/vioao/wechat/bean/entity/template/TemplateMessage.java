package com.github.vioao.wechat.bean.entity.template;

import lombok.Builder;

import java.util.LinkedHashMap;

/**
 * 模板消息.
 *
 * @author vioao
 */
@Builder
public class TemplateMessage {
    private String touser; //接收者openid
    private String templateId; //模板ID
    private String url; //模板跳转链接
    private LinkedHashMap<String, TemplateMessageItem> data; //模板数据
    private MiniProgram miniprogram; //跳小程序所需数据，不需跳小程序可不用传该数据
    private String scene;//订阅场景值
    private String title; //消息标题，15字以内

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LinkedHashMap<String, TemplateMessageItem> getData() {
        return data;
    }

    public void setData(LinkedHashMap<String, TemplateMessageItem> data) {
        this.data = data;
    }

    public MiniProgram getMiniprogram() {
        return miniprogram;
    }

    public void setMiniprogram(MiniProgram miniprogram) {
        this.miniprogram = miniprogram;
    }
}
