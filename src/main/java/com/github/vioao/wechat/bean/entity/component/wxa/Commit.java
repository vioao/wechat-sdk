package com.github.vioao.wechat.bean.entity.component.wxa;

import lombok.Builder;

/**
 * 代码提交信息.
 *
 * @author vioao
 */
@Builder
public class Commit {
    private String templateId; //代码库中的代码模版ID
    private String extJson; // 第三方自定义的配置
    private String userVersion; //代码版本号，开发者可自定义
    private String userDesc; //代码描述，开发者可自定义

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getExtJson() {
        return extJson;
    }

    public void setExtJson(String extJson) {
        this.extJson = extJson;
    }

    public String getUserVersion() {
        return userVersion;
    }

    public void setUserVersion(String userVersion) {
        this.userVersion = userVersion;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    @Override
    public String toString() {
        return "Commit{" +
                "templateId='" + templateId + '\'' +
                ", extJson='" + extJson + '\'' +
                ", userVersion='" + userVersion + '\'' +
                ", userDesc='" + userDesc + '\'' +
                '}';
    }
}
