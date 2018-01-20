package me.vioao.wechat.bean.entity.message.msg;

import me.vioao.wechat.bean.entity.message.MsgType;

import java.util.List;

/**
 * 图文消息（点击跳转到外链）.
 * 图文消息条数限制在8条以内，注意，如果图文数超过8，则将会无响应.
 *
 * @author vioao
 */
public class NewsMessage extends Message {
    private News news;

    /**
     * 构造图文消息（点击跳转到外链）.
     */
    public NewsMessage(String touser, List<Article> articles) {
        super(touser, MsgType.NEWS.name().toLowerCase());
        this.news = new News();
        this.news.setArticles(articles);
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public static class News {
        private List<Article> articles;

        public List<Article> getArticles() {
            return articles;
        }

        public void setArticles(List<Article> articles) {
            this.articles = articles;
        }
    }

    public static class Article {
        private String title;
        private String description;
        private String url;
        private String picurl;

        /**
         * 构造图文对象.
         */
        public Article(String title, String description, String url, String picurl) {
            this.title = title;
            this.description = description;
            this.url = url;
            this.picurl = picurl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }
    }
}
