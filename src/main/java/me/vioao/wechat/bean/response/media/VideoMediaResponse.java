package me.vioao.wechat.bean.response.media;


import me.vioao.wechat.bean.response.BaseResponse;

/**
 * 获取永久视频素材返回的封装类.
 *
 * @author vioao
 */
public class VideoMediaResponse extends BaseResponse {
    private String title;
    private String description;
    private String downUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }

    @Override
    public String toString() {
        return "VideoMediaResponse{"
                + "title='" + title + '\''
                + ", description='" + description + '\''
                + ", downUrl='" + downUrl + '\''
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
