package me.vioao.wechat.bean.entity.autoreplay;

import java.util.List;

/**
 * @author vioao
 */
public class KeywordAutoReplyInfo {
    private List<AutoReplyRule> list;

    public List<AutoReplyRule> getList() {
        return list;
    }

    public void setList(List<AutoReplyRule> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "KeywordAutoReplyInfo{" +
                "list=" + list +
                '}';
    }
}
