package com.github.vioao.wechat.bean.entity.message.massmsg;

import com.github.vioao.wechat.bean.entity.message.MsgType;
import com.github.vioao.wechat.bean.entity.message.UploadVideo;

/**
 * 群发视频消息.
 *
 * @author vioao
 */
public class MassMPvideoMessage extends MassMessage {
    private UploadVideo mpvideo;

    /**
     * 根据视频对象构造群发视频消息对象.
     */
    public MassMPvideoMessage(UploadVideo uploadVideo) {
        super(MsgType.MPVIDEO.name().toLowerCase());
        this.mpvideo = uploadVideo;
    }

    public UploadVideo getMpvideo() {
        return mpvideo;
    }

    public void setMpvideo(UploadVideo mpvideo) {
        this.mpvideo = mpvideo;
    }
}
