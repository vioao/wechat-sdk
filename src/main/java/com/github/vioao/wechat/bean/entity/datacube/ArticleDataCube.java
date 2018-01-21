package com.github.vioao.wechat.bean.entity.datacube;

import java.util.List;


/**
 * 图文分析数据Item.
 *
 * @author vioao
 */
public class ArticleDataCube {
    private String refDate; //数据的日期，需在begin_date和end_date之间

    //数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
    private Integer refHour;

    //统计的日期，在getarticletotal接口中，ref_date指的是文章群发出日期， 而stat_date是数据统计日期
    private String statDate;

    // 请注意：这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（消息次序索引）
    // 组成， 例如12003_3， 其中12003是msgid，即一次群发的消息的id； 3为index，
    // 假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
    private String msgId;

    private String title; //图文消息的标题
    private Integer intPageReadUser; //图文页（点击群发图文卡片进入的页面）的阅读人数
    private Integer intPageReadCount; //图文页的阅读次数
    private Integer oriPageReadUser; //原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0

    private Integer oriPageReadCount; //原文页的阅读次数
    private Integer shareScene; //分享的场景 1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
    private Integer shareUser; //分享的人数
    private Integer shareCount; //分享的次数
    private Integer addToFavUser; //收藏的人数
    private Integer addToFavCount; //收藏的次数
    private Integer targetUser; //送达人数，一般约等于总粉丝数（需排除黑名单或其他异常情况下无法收到消息的粉丝）

    // 在获取图文阅读分时数据时才有该字段，代表用户从哪里进入来阅读该图文。
    // 0:会话;1.好友;2.朋友圈;3.腾讯微博;4.历史消息页;5.其他
    private Integer userSource;

    //送达人数，一般约等于总粉丝数（需排除黑名单或其他异常情况下无法收到消息的粉丝）


    // ----------获取图文群发总数据接口中的详细字段解释-------------
    private Integer intPageFromSessionReadUser; //公众号会话阅读人数
    private Integer intPageFromSessionReadCount; //公众号会话阅读次数
    private Integer intPageFromHistMsgReadUser; //历史消息页阅读人数
    private Integer intPageFromHistMsgReadCount; //历史消息页阅读次数
    private Integer intPageFromFeedReadUser; // 朋友圈阅读人数
    private Integer intPageFromFeedReadCount; //朋友圈阅读次数
    private Integer intPageFromFriendsReadUser; //好友转发阅读人数
    private Integer intPageFromFriendsReadCount; //好友转发阅读次数
    private Integer intPageFromOtherReadUser; //其他场景阅读人数
    private Integer intPageFromOtherReadCount; //其他场景阅读次数
    private Integer feedShareFromSessionUser; // 公众号会话转发朋友圈人数
    private Integer feedShareFromSessionCnt; //公众号会话转发朋友圈次数
    private Integer feedShareFromFeedUser; //朋友圈转发朋友圈人数
    private Integer feedShareFromFeedCnt; //朋友圈转发朋友圈次数
    private Integer feedShareFromOtherUser; //其他场景转发朋友圈人数
    private Integer feedShareFromOtherCnt; //其他场景转发朋友圈次数

    private List<ArticleDataCube> details;

    public String getRefDate() {
        return refDate;
    }

    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIntPageReadUser() {
        return intPageReadUser;
    }

    public void setIntPageReadUser(Integer intPageReadUser) {
        this.intPageReadUser = intPageReadUser;
    }

    public Integer getIntPageReadCount() {
        return intPageReadCount;
    }

    public void setIntPageReadCount(Integer intPageReadCount) {
        this.intPageReadCount = intPageReadCount;
    }

    public Integer getOriPageReadUser() {
        return oriPageReadUser;
    }

    public void setOriPageReadUser(Integer oriPageReadUser) {
        this.oriPageReadUser = oriPageReadUser;
    }

    public Integer getOriPageReadCount() {
        return oriPageReadCount;
    }

    public void setOriPageReadCount(Integer oriPageReadCount) {
        this.oriPageReadCount = oriPageReadCount;
    }

    public Integer getShareUser() {
        return shareUser;
    }

    public void setShareUser(Integer shareUser) {
        this.shareUser = shareUser;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    public Integer getAddToFavUser() {
        return addToFavUser;
    }

    public void setAddToFavUser(Integer addToFavUser) {
        this.addToFavUser = addToFavUser;
    }

    public Integer getAddToFavCount() {
        return addToFavCount;
    }

    public void setAddToFavCount(Integer addToFavCount) {
        this.addToFavCount = addToFavCount;
    }

    public Integer getRefHour() {
        return refHour;
    }

    public void setRefHour(Integer refHour) {
        this.refHour = refHour;
    }

    public Integer getUserSource() {
        return userSource;
    }

    public void setUserSource(Integer userSource) {
        this.userSource = userSource;
    }

    public Integer getIntPageFromSessionReadUser() {
        return intPageFromSessionReadUser;
    }

    public void setIntPageFromSessionReadUser(Integer intPageFromSessionReadUser) {
        this.intPageFromSessionReadUser = intPageFromSessionReadUser;
    }

    public String getStatDate() {
        return statDate;
    }

    public void setStatDate(String statDate) {
        this.statDate = statDate;
    }

    public Integer getShareScene() {
        return shareScene;
    }

    public void setShareScene(Integer shareScene) {
        this.shareScene = shareScene;
    }

    public Integer getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(Integer targetUser) {
        this.targetUser = targetUser;
    }

    public Integer getIntPageFromSessionReadCount() {
        return intPageFromSessionReadCount;
    }

    public void setIntPageFromSessionReadCount(Integer intPageFromSessionReadCount) {
        this.intPageFromSessionReadCount = intPageFromSessionReadCount;
    }

    public Integer getIntPageFromHistMsgReadUser() {
        return intPageFromHistMsgReadUser;
    }

    public void setIntPageFromHistMsgReadUser(Integer intPageFromHistMsgReadUser) {
        this.intPageFromHistMsgReadUser = intPageFromHistMsgReadUser;
    }

    public Integer getIntPageFromHistMsgReadCount() {
        return intPageFromHistMsgReadCount;
    }

    public void setIntPageFromHistMsgReadCount(Integer intPageFromHistMsgReadCount) {
        this.intPageFromHistMsgReadCount = intPageFromHistMsgReadCount;
    }

    public Integer getIntPageFromFeedReadUser() {
        return intPageFromFeedReadUser;
    }

    public void setIntPageFromFeedReadUser(Integer intPageFromFeedReadUser) {
        this.intPageFromFeedReadUser = intPageFromFeedReadUser;
    }

    public Integer getIntPageFromFeedReadCount() {
        return intPageFromFeedReadCount;
    }

    public void setIntPageFromFeedReadCount(Integer intPageFromFeedReadCount) {
        this.intPageFromFeedReadCount = intPageFromFeedReadCount;
    }

    public Integer getIntPageFromFriendsReadUser() {
        return intPageFromFriendsReadUser;
    }

    public void setIntPageFromFriendsReadUser(Integer intPageFromFriendsReadUser) {
        this.intPageFromFriendsReadUser = intPageFromFriendsReadUser;
    }

    public Integer getIntPageFromFriendsReadCount() {
        return intPageFromFriendsReadCount;
    }

    public void setIntPageFromFriendsReadCount(Integer intPageFromFriendsReadCount) {
        this.intPageFromFriendsReadCount = intPageFromFriendsReadCount;
    }

    public Integer getIntPageFromOtherReadUser() {
        return intPageFromOtherReadUser;
    }

    public void setIntPageFromOtherReadUser(Integer intPageFromOtherReadUser) {
        this.intPageFromOtherReadUser = intPageFromOtherReadUser;
    }

    public Integer getIntPageFromOtherReadCount() {
        return intPageFromOtherReadCount;
    }

    public void setIntPageFromOtherReadCount(Integer intPageFromOtherReadCount) {
        this.intPageFromOtherReadCount = intPageFromOtherReadCount;
    }

    public Integer getFeedShareFromSessionUser() {
        return feedShareFromSessionUser;
    }

    public void setFeedShareFromSessionUser(Integer feedShareFromSessionUser) {
        this.feedShareFromSessionUser = feedShareFromSessionUser;
    }

    public Integer getFeedShareFromSessionCnt() {
        return feedShareFromSessionCnt;
    }

    public void setFeedShareFromSessionCnt(Integer feedShareFromSessionCnt) {
        this.feedShareFromSessionCnt = feedShareFromSessionCnt;
    }

    public Integer getFeedShareFromFeedUser() {
        return feedShareFromFeedUser;
    }

    public void setFeedShareFromFeedUser(Integer feedShareFromFeedUser) {
        this.feedShareFromFeedUser = feedShareFromFeedUser;
    }

    public Integer getFeedShareFromFeedCnt() {
        return feedShareFromFeedCnt;
    }

    public void setFeedShareFromFeedCnt(Integer feedShareFromFeedCnt) {
        this.feedShareFromFeedCnt = feedShareFromFeedCnt;
    }

    public Integer getFeedShareFromOtherUser() {
        return feedShareFromOtherUser;
    }

    public void setFeedShareFromOtherUser(Integer feedShareFromOtherUser) {
        this.feedShareFromOtherUser = feedShareFromOtherUser;
    }

    public Integer getFeedShareFromOtherCnt() {
        return feedShareFromOtherCnt;
    }

    public void setFeedShareFromOtherCnt(Integer feedShareFromOtherCnt) {
        this.feedShareFromOtherCnt = feedShareFromOtherCnt;
    }

    public List<ArticleDataCube> getDetails() {
        return details;
    }

    public void setDetails(List<ArticleDataCube> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ArticleDataCube{" +
                "refDate='" + refDate + '\'' +
                ", refHour=" + refHour +
                ", statDate='" + statDate + '\'' +
                ", msgId='" + msgId + '\'' +
                ", title='" + title + '\'' +
                ", intPageReadUser=" + intPageReadUser +
                ", intPageReadCount=" + intPageReadCount +
                ", oriPageReadUser=" + oriPageReadUser +
                ", oriPageReadCount=" + oriPageReadCount +
                ", shareScene=" + shareScene +
                ", shareUser=" + shareUser +
                ", shareCount=" + shareCount +
                ", addToFavUser=" + addToFavUser +
                ", addToFavCount=" + addToFavCount +
                ", targetUser=" + targetUser +
                ", userSource=" + userSource +
                ", intPageFromSessionReadUser=" + intPageFromSessionReadUser +
                ", intPageFromSessionReadCount=" + intPageFromSessionReadCount +
                ", intPageFromHistMsgReadUser=" + intPageFromHistMsgReadUser +
                ", intPageFromHistMsgReadCount=" + intPageFromHistMsgReadCount +
                ", intPageFromFeedReadUser=" + intPageFromFeedReadUser +
                ", intPageFromFeedReadCount=" + intPageFromFeedReadCount +
                ", intPageFromFriendsReadUser=" + intPageFromFriendsReadUser +
                ", intPageFromFriendsReadCount=" + intPageFromFriendsReadCount +
                ", intPageFromOtherReadUser=" + intPageFromOtherReadUser +
                ", intPageFromOtherReadCount=" + intPageFromOtherReadCount +
                ", feedShareFromSessionUser=" + feedShareFromSessionUser +
                ", feedShareFromSessionCnt=" + feedShareFromSessionCnt +
                ", feedShareFromFeedUser=" + feedShareFromFeedUser +
                ", feedShareFromFeedCnt=" + feedShareFromFeedCnt +
                ", feedShareFromOtherUser=" + feedShareFromOtherUser +
                ", feedShareFromOtherCnt=" + feedShareFromOtherCnt +
                ", details=" + details +
                '}';
    }
}
