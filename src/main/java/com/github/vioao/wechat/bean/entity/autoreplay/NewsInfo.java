package com.github.vioao.wechat.bean.entity.autoreplay;

import java.util.List;

/**
 * @author vioao
 */
public class NewsInfo {
    private List<NewsItem> list;

    public List<NewsItem> getList() {
        return list;
    }

    public void setList(List<NewsItem> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "NewsInfo{" +
                "list=" + list +
                '}';
    }
}
