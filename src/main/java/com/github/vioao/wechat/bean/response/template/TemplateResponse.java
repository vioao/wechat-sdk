package com.github.vioao.wechat.bean.response.template;

import com.github.vioao.wechat.bean.response.BaseResponse;

/**
 * 模板接口返回信息.
 *
 * @author vioao
 */
public class TemplateResponse extends BaseResponse {
    private String templateId; //模板ID
    private String title; //模板标题
    private String primaryIndustry; //模板所属行业的一级行业
    private String deputyIndustry; //模板所属行业的二级行业
    private String content; //模板内容
    private String example; //模板示例

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(String primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public String getDeputyIndustry() {
        return deputyIndustry;
    }

    public void setDeputyIndustry(String deputyIndustry) {
        this.deputyIndustry = deputyIndustry;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return "TemplateResponse{"
                + "templateId='" + templateId + '\''
                + ", title='" + title + '\''
                + ", primaryIndustry='" + primaryIndustry + '\''
                + ", deputyIndustry='" + deputyIndustry + '\''
                + ", content='" + content + '\''
                + ", example='" + example + '\''
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
