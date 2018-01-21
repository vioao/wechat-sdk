package com.github.vioao.wechat.bean.response.material;

import com.github.vioao.wechat.bean.entity.message.Article;
import com.github.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 图文素材返回.
 *
 * @author vioao
 */
public class NewsItemResponse extends BaseResponse {
    private List<Article> newsItem;

    public List<Article> getNewsItem() {
        return newsItem;
    }

    public void setNewsItem(List<Article> newsItem) {
        this.newsItem = newsItem;
    }

    @Override
    public String toString() {
        return "GetMaterialNewsResponse{"
                + "newsItem=" + newsItem
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
