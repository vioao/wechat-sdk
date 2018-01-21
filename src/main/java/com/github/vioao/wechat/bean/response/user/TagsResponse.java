package com.github.vioao.wechat.bean.response.user;

import com.github.vioao.wechat.bean.entity.user.Tag;
import com.github.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 用户标签信息列表返回.
 *
 * @author vioao
 */
public class TagsResponse extends BaseResponse {
    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "TagResponse{"
                + ", tags=" + tags
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
