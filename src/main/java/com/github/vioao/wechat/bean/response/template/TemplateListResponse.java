package com.github.vioao.wechat.bean.response.template;

import com.github.vioao.wechat.bean.entity.template.Template;
import com.github.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 模板列表.
 *
 * @author vioao
 */
public class TemplateListResponse extends BaseResponse {
    private List<Template> templateList;

    public List<Template> getTemplateList() {
        return templateList;
    }

    public void setTemplateList(List<Template> templateList) {
        this.templateList = templateList;
    }

    @Override
    public String toString() {
        return "TemplateListResponse{"
                + "templateList=" + templateList
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
