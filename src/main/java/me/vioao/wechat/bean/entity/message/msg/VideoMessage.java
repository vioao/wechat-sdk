package me.vioao.wechat.bean.entity.message.msg;

import me.vioao.wechat.bean.entity.message.MsgType;

/**
 * 视频消息.
 *
 * @author vioao
 */
public class VideoMessage extends Message {
    public Video video;

    /**
     * 构造视频消息.
     */
    public VideoMessage(String touser, Video video) {
        super(touser, MsgType.VIDEO.name().toLowerCase());
        this.video = video;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public static class Video {
        private String mediaId;
        private String thumbMediaId;
        private String title;
        private String description;

        /**
         * 构造视频.
         */
        public Video(String media_id, String thumbMediaId, String title, String description) {
            this.mediaId = media_id;
            this.thumbMediaId = thumbMediaId;
            this.title = title;
            this.description = description;
        }

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }

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
    }
}
