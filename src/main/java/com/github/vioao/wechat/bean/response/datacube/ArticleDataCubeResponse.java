package com.github.vioao.wechat.bean.response.datacube;

import com.github.vioao.wechat.bean.entity.datacube.ArticleDataCube;
import com.github.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

public class ArticleDataCubeResponse extends BaseResponse {
    private List<ArticleDataCube> list;

    public List<ArticleDataCube> getList() {
        return list;
    }

    public void setList(List<ArticleDataCube> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ArticleDataCubeResponse{"
                + "list=" + list + '\''
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}

