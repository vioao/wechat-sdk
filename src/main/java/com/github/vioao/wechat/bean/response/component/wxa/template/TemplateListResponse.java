package com.github.vioao.wechat.bean.response.component.wxa.template;

import com.github.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 获取帐号下已存在的模板列表接口返回.
 *
 * @author vioao
 */
public class TemplateListResponse extends BaseResponse {
    private List<TemplateDeatil> list;

    public List<TemplateDeatil> getList() {
        return list;
    }

    public void setList(List<TemplateDeatil> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "LibraryListResponse{"
                + "list=" + list
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }

    public static class TemplateDeatil {
        private String templateId;
        private String title;
        private String conetnt;
        private String example;

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

        public String getConetnt() {
            return conetnt;
        }

        public void setConetnt(String conetnt) {
            this.conetnt = conetnt;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }

        @Override
        public String toString() {
            return "TemplateDeatil{" +
                    "example='" + example + '\'' +
                    ", conetnt='" + conetnt + '\'' +
                    ", title='" + title + '\'' +
                    ", templateId='" + templateId + '\'' +
                    '}';
        }
    }
}
