package me.vioao.wechat.bean.entity.message.msg;

import me.vioao.wechat.bean.entity.message.MsgType;

/**
 * 图文消息（点击跳转到图文消息页面）.
 * 图文消息条数限制在8条以内，注意，如果图文数超过8，则将会无响应.
 *
 * @author vioao
 */
public class MpNewsMessage extends Message {
    private MpNews mpnews;

    /**
     * 构造图文消息.
     */
    public MpNewsMessage(String touser, String mediaId) {
        super(touser, MsgType.MPNEWS.name().toLowerCase());
        this.mpnews = new MpNews();
        this.mpnews.setMediaId(mediaId);
    }

    public MpNews getMpnews() {
        return mpnews;
    }

    public void setMpnews(MpNews mpnews) {
        this.mpnews = mpnews;
    }

    public static class MpNews {
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }
}
