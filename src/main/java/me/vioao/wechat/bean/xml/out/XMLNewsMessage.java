package me.vioao.wechat.bean.xml.out;

import me.vioao.wechat.bean.entity.message.MsgType;

import java.util.List;

public class XMLNewsMessage extends XmlMessage {
    private List<Article> articles;

    /**
     * @param toUserName
     * @param fromUserName
     * @param articles
     */
    public XMLNewsMessage(String toUserName, String fromUserName,
                          List<Article> articles) {
        super(toUserName, fromUserName, MsgType.NEWS.name().toLowerCase());
        this.articles = articles;
    }

    @Override
    public String subXml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ArticleCount>").append(articles.size()).append("</ArticleCount>");
        sb.append("<Articles>");
        for (Article a : articles) {
            sb.append("<item>").append("<Title><![CDATA[").append(a.title == null ? "" : a.title).append("]]></Title>")
                    .append("<Description><![CDATA[").append(a.description == null ? "" : a.description)
                    .append("]]></Description>")
                    .append("<PicUrl><![CDATA[").append(a.picurl == null ? "" : a.picurl).append("]]></PicUrl>")
                    .append("<Url><![CDATA[").append(a.url == null ? "" : a.url).append("]]></Url>").append("</item>");
        }
        sb.append("</Articles>");
        return sb.toString();
    }

    public static class Article {
        private String title;
        private String description;
        private String url;
        private String picurl;

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
