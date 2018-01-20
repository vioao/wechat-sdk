package me.vioao.wechat.bean.entity.autoreplay;

import java.util.Date;
import java.util.List;

/**
 * 自动回复的规则.
 *
 * @author vioao
 */
public class AutoReplyRule {
    private String ruleName; //规则名称
    private Date createTime; //创建时间
    private String replyMode; //回复模式，reply_all代表全部回复，random_one代表随机回复其中一条
    private List<ReplyInfo> keywordListInfo; //匹配的关键词列表
    private List<ReplyInfo> replyListInfo;

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReplyMode() {
        return replyMode;
    }

    public void setReplyMode(String replyMode) {
        this.replyMode = replyMode;
    }

    public List<ReplyInfo> getKeywordListInfo() {
        return keywordListInfo;
    }

    public void setKeywordListInfo(List<ReplyInfo> keywordListInfo) {
        this.keywordListInfo = keywordListInfo;
    }

    public List<ReplyInfo> getReplyListInfo() {
        return replyListInfo;
    }

    public void setReplyListInfo(List<ReplyInfo> replyListInfo) {
        this.replyListInfo = replyListInfo;
    }

    @Override
    public String toString() {
        return "AutoReplyRule{" +
                "ruleName='" + ruleName + '\'' +
                ", createTime=" + createTime +
                ", replyMode='" + replyMode + '\'' +
                ", keywordListInfo=" + keywordListInfo +
                ", replyListInfo=" + replyListInfo +
                '}';
    }
}
