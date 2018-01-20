package me.vioao.wechat.bean.entity.message.msg;

import me.vioao.wechat.bean.entity.message.MsgType;

/**
 * 音乐消息.
 *
 * @author vioao
 */
public class MusicMessage extends Message {
    private Music music;

    /**
     * 构造音乐消息.
     */
    public MusicMessage(String touser, Music music) {
        super(touser, MsgType.MUSIC.name().toLowerCase());
        this.music = music;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public static class Music {
        private String title;
        private String description;
        private String musicurl;
        private String hqmusicurl;
        private String thumbMediaId;

        /**
         * 构造音乐对象.
         */
        public Music(String title, String description, String musicurl, String hqmusicurl, String thumbMediaId) {
            this.title = title;
            this.description = description;
            this.musicurl = musicurl;
            this.hqmusicurl = hqmusicurl;
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

        public String getMusicurl() {
            return musicurl;
        }

        public void setMusicurl(String musicurl) {
            this.musicurl = musicurl;
        }

        public String getHqmusicurl() {
            return hqmusicurl;
        }

        public void setHqmusicurl(String hqmusicurl) {
            this.hqmusicurl = hqmusicurl;
        }

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }
    }
}
