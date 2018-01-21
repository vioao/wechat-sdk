package com.github.vioao.wechat.bean.entity.comment;

/**
 * 查看群发图文评论入参.
 *
 * @author vioao
 */
public class CommentRequest {
    private String msgDataId;// 群发返回的msg_data_id
    private Integer index;// 多图文时，用来指定第几篇图文，从0开始，不带默认返回该msg_data_id的第一篇图文
    private Integer begin;// 起始位置
    private Integer count;// 获取数目（>=50会被拒绝）
    private Integer type;// type=0 普通评论&精选评论 type=1 普通评论 type=2 精选评论

    public CommentRequest() {
    }

    /**
     * 构造方法，获取评论时需要提交的数据.
     *
     * @param msgDataId 群发返回的msg_data_id
     * @param index     多图文时，用来指定第几篇图文
     * @param begin     起始位置
     * @param count     获取数目（>=50会被拒绝）
     * @param type      type=0 普通评论&精选评论 type=1 普通评论 type=2 精选评论
     */
    public CommentRequest(String msgDataId, Integer index, Integer begin, Integer count, Integer type) {
        this.msgDataId = msgDataId;
        this.index = index;
        this.begin = begin;
        this.count = count;
        this.type = type;
    }

    public String getMsgDataId() {
        return msgDataId;
    }

    public void setMsgDataId(String msgDataId) {
        this.msgDataId = msgDataId;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CommentView{" +
                "msgDataId='" + msgDataId + '\'' +
                ", index=" + index +
                ", begin=" + begin +
                ", count=" + count +
                ", type=" + type +
                '}';
    }
}
