package com.github.vioao.wechat.bean.response.component.wxa;

import com.github.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

public class GetPageResponse extends BaseResponse {
    private List<String> pageList; //page_list 页面配置列表

    public List<String> getPageList() {
        return pageList;
    }

    public void setPageList(List<String> pageList) {
        this.pageList = pageList;
    }

    @Override
    public String toString() {
        return "GetPageResponse{"
                + "pageList=" + pageList
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
