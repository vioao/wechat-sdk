package com.github.vioao.wechat.bean.entity.message.massmsg;

import com.github.vioao.wechat.bean.entity.message.MsgType;

import java.util.HashMap;
import java.util.Map;

/**
 * 群发音乐消息.
 *
 * @author vioao
 */
public class MassMusicMessage extends MassMessage {
    private Map<String, String> music;

    /**
     * 构造群发音乐消息.
     */
    public MassMusicMessage(String mediaId) {
        super(MsgType.MUSIC.name().toLowerCase());
        music = new HashMap<>();
        music.put("media_id", mediaId);
    }

    public Map<String, String> getMusic() {
        return music;
    }

    public void setMusic(Map<String, String> music) {
        this.music = music;
    }
}
