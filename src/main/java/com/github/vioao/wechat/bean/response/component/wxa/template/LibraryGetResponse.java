package com.github.vioao.wechat.bean.response.component.wxa.template;


import com.github.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 获取模板库某个模板标题下关键词库接口返回.
 *
 * @author vioao
 */
public class LibraryGetResponse extends BaseResponse {
    private String id;
    private String title;
    private List<KeyWord> keywordList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<KeyWord> getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(List<KeyWord> keywordList) {
        this.keywordList = keywordList;
    }

    @Override
    public String toString() {
        return "LibraryGetResponse{"
                + "errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + ", id='" + id + '\''
                + ", title='" + title + '\''
                + ", keywordList=" + keywordList
                + '}';
    }

    public static class KeyWord {
        private Integer keywordId; // 关键词id，添加模板时需要
        private String name; // 关键词内容
        private String example; // 关键词内容对应的示例

        public Integer getKeywordId() {
            return keywordId;
        }

        public void setKeywordId(Integer keywordId) {
            this.keywordId = keywordId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }

        @Override
        public String toString() {
            return "KeyWord{" +
                    "keywordId=" + keywordId +
                    ", name='" + name + '\'' +
                    ", example='" + example + '\'' +
                    '}';
        }
    }
}
