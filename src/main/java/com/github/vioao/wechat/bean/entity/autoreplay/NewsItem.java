package com.github.vioao.wechat.bean.entity.autoreplay;

/**
 * @author vioao
 */
public class NewsItem {
    private String coverUrl;
    private String author;
    private String contentUrl;
    private String digest;
    private Boolean showCover;
    private String sourceUrl;
    private String title;

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public Boolean getShowCover() {
        return showCover;
    }

    public void setShowCover(Boolean showCover) {
        this.showCover = showCover;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "NewsItem{" +
                "coverUrl='" + coverUrl + '\'' +
                ", author='" + author + '\'' +
                ", contentUrl='" + contentUrl + '\'' +
                ", digest='" + digest + '\'' +
                ", showCover=" + showCover +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
