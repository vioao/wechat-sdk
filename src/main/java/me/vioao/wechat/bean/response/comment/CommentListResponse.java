package me.vioao.wechat.bean.response.comment;


import me.vioao.wechat.bean.entity.comment.Comment;
import me.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 文章的评论数据。
 *
 * @author vio
 */
public class CommentListResponse extends BaseResponse {
    private Integer total; // 总数，非comment的size
    private List<Comment> comment;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CommentListResponse{"
                + "total=" + total
                + ", comment=" + comment
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
