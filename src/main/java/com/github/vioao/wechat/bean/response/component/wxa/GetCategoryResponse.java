package com.github.vioao.wechat.bean.response.component.wxa;

import com.github.vioao.wechat.bean.entity.component.wxa.Category;
import com.github.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

public class GetCategoryResponse extends BaseResponse {
    private List<Category> categoryList; //可填选的类目列表

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "GetCategoryResponse{"
                + "categoryList=" + categoryList
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
