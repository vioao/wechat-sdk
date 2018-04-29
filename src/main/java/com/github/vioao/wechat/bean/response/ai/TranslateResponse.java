package com.github.vioao.wechat.bean.response.ai;

import com.github.vioao.wechat.bean.response.BaseResponse;

/**
 * 微信翻译接口返回.
 *
 * @author vioao
 */
public class TranslateResponse extends BaseResponse {
    private String fromContent;
    private String toContent;

    public String getFromContent() {
        return fromContent;
    }

    public void setFromContent(String fromContent) {
        this.fromContent = fromContent;
    }

    public String getToContent() {
        return toContent;
    }

    public void setToContent(String toContent) {
        this.toContent = toContent;
    }

    @Override
    public String toString() {
        return "TranslateResponse{"
                + "errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + ", fromContent='" + fromContent + '\''
                + ", toContent='" + toContent + '\'' +
                '}';
    }
}
