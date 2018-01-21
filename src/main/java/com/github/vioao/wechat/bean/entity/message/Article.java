package com.github.vioao.wechat.bean.entity.message;

import lombok.Builder;

/**
 * 图文消息文章.
 *
 * @author vioao
 */
@Builder
public class Article {
    private String title; // 标题
    private String author; // 作者
    private String thumbMediaId; // 图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得

    // 在图文消息页面点击“阅读原文”后的页面，受安全限制，如需跳转Appstore，可以使用itun.es或appsto.re的短链服务，
    // 并在短链后增加 #wechat_redirect 后缀。
    private String contentSourceUrl;

    // 图文消息页面的内容，支持HTML标签。
    // 具备微信支付权限的公众号，可以使用a标签，其他公众号不能使用，如需插入小程序卡片，可参考下文。
    private String content;

    private String digest; // 图文消息的描述，如本字段为空，则默认抓取正文前64个字
    private Integer showCoverPic; // 是否显示封面，1为显示，0为不显示
    private Integer needOpenComment;// 是否打开评论，0不打开，1打开
    private Integer onlyFansCanComment;// 是否粉丝才可评论，0所有人可评论，1粉丝才可评论

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public Integer getNeedOpenComment() {
        return needOpenComment;
    }

    public void setNeedOpenComment(Integer needOpenComment) {
        this.needOpenComment = needOpenComment;
    }

    public Integer getOnlyFansCanComment() {
        return onlyFansCanComment;
    }

    public void setOnlyFansCanComment(Integer onlyFansCanComment) {
        this.onlyFansCanComment = onlyFansCanComment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentSourceUrl() {
        return contentSourceUrl;
    }

    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public Integer getShowCoverPic() {
        return showCoverPic;
    }

    public void setShowCoverPic(Integer showCoverPic) {
        this.showCoverPic = showCoverPic;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", thumbMediaId='" + thumbMediaId + '\'' +
                ", contentSourceUrl='" + contentSourceUrl + '\'' +
                ", content='" + content + '\'' +
                ", digest='" + digest + '\'' +
                ", showCoverPic=" + showCoverPic +
                ", needOpenComment=" + needOpenComment +
                ", onlyFansCanComment=" + onlyFansCanComment +
                '}';
    }
}
