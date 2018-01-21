package me.vioao.wechat.bean.entity.message.massmsg;

import me.vioao.wechat.bean.entity.message.MsgType;
import me.vioao.wechat.bean.entity.message.massmsg.MassMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * 群发图文消息.
 *
 * @author vioao
 */
public class MassMpNewsMessage extends MassMessage {
    private Integer sendIgnoreReprint; //图文消息被判定为转载时，是否继续群发。 1为继续群发（转载），0为停止群发。 该参数默认为0
    private Map<String, String> mpnews;

    /**
     * 构造群发图文消息.
     */
    public MassMpNewsMessage(String mediaId) {
        super(MsgType.MPNEWS.name().toLowerCase());
        mpnews = new HashMap<>();
        mpnews.put("media_id", mediaId);
    }

    public Map<String, String> getMpnews() {
        return mpnews;
    }

    public void setMpnews(Map<String, String> mpnews) {
        this.mpnews = mpnews;
    }

    public Integer getSendIgnoreReprint() {
        return sendIgnoreReprint;
    }

    public void setSendIgnoreReprint(Integer sendIgnoreReprint) {
        this.sendIgnoreReprint = sendIgnoreReprint;
    }
}
