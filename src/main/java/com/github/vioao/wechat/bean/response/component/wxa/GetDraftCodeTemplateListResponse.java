package com.github.vioao.wechat.bean.response.component.wxa;

import com.github.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 获取草稿箱内的所有临时代码草稿接口返回.
 *
 * @author vioao
 */
public class GetDraftCodeTemplateListResponse extends BaseResponse {
    private List<DraftTemplate> draftTemplateList;

    public List<DraftTemplate> getDraftTemplateList() {
        return draftTemplateList;
    }

    public void setDraftTemplateList(List<DraftTemplate> draftTemplateList) {
        this.draftTemplateList = draftTemplateList;
    }

    @Override
    public String toString() {
        return "DraftTemplateListResponse{"
                + "draftTemplateList=" + draftTemplateList
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }

    public static class DraftTemplate {
        private Long createTime; // 说开发者上传草稿时间
        private String userVersion; // 模版版本号，开发者自定义字段
        private String userDesc; // 模版描述 开发者自定义字段
        private Integer draftId; // 草稿id

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

        public Integer getDraftId() {
            return draftId;
        }

        public void setDraftId(Integer draftId) {
            this.draftId = draftId;
        }

        @Override
        public String toString() {
            return "DraftTemplate{" +
                    "createTime=" + createTime +
                    ", userVersion='" + userVersion + '\'' +
                    ", userDesc='" + userDesc + '\'' +
                    ", draftId=" + draftId +
                    '}';
        }
    }
}
