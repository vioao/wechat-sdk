package com.github.vioao.wechat.bean.entity.material;

import com.github.vioao.wechat.bean.entity.message.Article;

import java.util.List;

/**
 * 图文消息。
 *
 * @author vio
 */
public class NewsItem {
    private List<Article> newsItem;

    public List<Article> getNewsItem() {
        return newsItem;
    }

    public void setNewsItem(List<Article> newsItem) {
        this.newsItem = newsItem;
    }

    @Override
    public String toString() {
        return "NewsItem{" +
                "newsItem=" + newsItem +
                '}';
    }
}
