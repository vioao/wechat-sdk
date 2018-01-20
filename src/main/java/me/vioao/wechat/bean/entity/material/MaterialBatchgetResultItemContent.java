package me.vioao.wechat.bean.entity.material;


import me.vioao.wechat.bean.entity.message.Article;

import java.util.List;

public class MaterialBatchgetResultItemContent {
    private List<Article> newsItem;

    public List<Article> getNewsItem() {
        return newsItem;
    }

    public void setNewsItem(List<Article> newsItem) {
        this.newsItem = newsItem;
    }

}
