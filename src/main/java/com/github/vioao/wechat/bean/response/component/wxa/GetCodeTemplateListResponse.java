package com.github.vioao.wechat.bean.response.component.wxa;

import com.github.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 获取代码模版库中的所有小程序代码模版接口返回.
 *
 * @author vioao
 */
public class GetCodeTemplateListResponse extends BaseResponse {
    private List<CodeTemplate> templateList;

    public List<CodeTemplate> getTemplateList() {
        return templateList;
    }

    public void setTemplateList(List<CodeTemplate> templateList) {
        this.templateList = templateList;
    }

    @Override
    public String toString() {
        return "GetTemplateListResponse{"
                + "templateList=" + templateList
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }

    private static class CodeTemplate {
        private Long createTime; // 说开发者上传草稿时间
        private String userVersion; // 模版版本号，开发者自定义字段
        private String userDesc; // 模版描述 开发者自定义字段
        private Integer templateId; // 模版id

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
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

        public Integer getTemplateId() {
            return templateId;
        }

        public void setTemplateId(Integer templateId) {
            this.templateId = templateId;
        }

        @Override
        public String toString() {
            return "CodeTemplate{" +
                    "createTime=" + createTime +
                    ", userVersion='" + userVersion + '\'' +
                    ", userDesc='" + userDesc + '\'' +
                    ", templateId=" + templateId +
                    '}';
        }
    }
}
