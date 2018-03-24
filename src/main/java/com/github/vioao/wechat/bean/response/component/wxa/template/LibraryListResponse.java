package com.github.vioao.wechat.bean.response.component.wxa.template;

import com.github.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 获取小程序模板库标题列表接口返回.
 *
 * @author vioao
 */
public class LibraryListResponse extends BaseResponse {
    private List<Template> list;

    public List<Template> getList() {
        return list;
    }

    public void setList(List<Template> list) {
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

    public static class Template {
        private String id;
        private String title;

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

        @Override
        public String toString() {
            return "Template{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }


}
