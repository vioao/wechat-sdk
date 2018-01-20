package me.vioao.wechat.bean.response.material;


import me.vioao.wechat.bean.response.BaseResponse;

/**
 * 临时视频素材下载地址.
 *
 * @author vioao
 */
public class VideoUrlResponse extends BaseResponse {
    private String videoUrl;

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public String toString() {
        return "VideoUrlResponse{"
                + "videoUrl='" + videoUrl + '\''
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
