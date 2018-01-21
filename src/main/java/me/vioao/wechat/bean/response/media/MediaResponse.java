package me.vioao.wechat.bean.response.media;


import me.vioao.wechat.bean.entity.material.MaterialType;
import me.vioao.wechat.bean.response.BaseResponse;

/**
 * 图文消息素材.
 * 上传临时素材返回用到此类.
 *
 * @author vioao
 */
public class MediaResponse extends BaseResponse {
    // 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），图文消息（news）
    private String type;
    private String mediaId; // 媒体文件/图文消息上传后获取的唯一标识
    private String thumbMediaId; // 上传thumb返回的唯一标识[坑爹的腾讯、接口的都不统一]
    private Long createdAt; // 媒体文件上传时间
    private String url;// 图片上传后返回的url地址

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaId() {
        if (MaterialType.THUMB.name().equalsIgnoreCase(this.type) && (mediaId == null || mediaId.length() == 0)) {
            return thumbMediaId;
        }
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    @Override
    public String toString() {
        return "MediaResponse{"
                + "type='" + type + '\''
                + ", mediaId='" + getMediaId() + '\''
                + ", createdAt=" + createdAt
                + ", url='" + url + '\''
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
