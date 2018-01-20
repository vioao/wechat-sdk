package me.vioao.wechat.bean.entity.comment;

/**
 * 用户评论.
 *
 * @author vioao
 */
public class Comment {
    private String userCommentId; //用户评论id
    private String openid;
    private Integer createTime; //评论时间
    private String content; //评论内容
    private String commentType; //是否精选评论，0为即非精选，1为true，即精选
    private Comment reply;  //作者回复内容

    public String getUserCommentId() {
        return userCommentId;
    }

    public void setUserCommentId(String userCommentId) {
        this.userCommentId = userCommentId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    public Comment getReply() {
        return reply;
    }

    public void setReply(Comment reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "userCommentId='" + userCommentId + '\'' +
                ", openid='" + openid + '\'' +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                ", commentType='" + commentType + '\'' +
                ", reply=" + reply +
                '}';
    }
}
