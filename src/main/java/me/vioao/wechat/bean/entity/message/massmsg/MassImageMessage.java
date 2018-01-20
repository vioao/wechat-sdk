package me.vioao.wechat.bean.entity.message.massmsg;

import me.vioao.wechat.bean.entity.message.MsgType;
import me.vioao.wechat.bean.entity.message.massmsg.MassMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * 群发图片消息.
 *
 * @author vioao
 */
public class MassImageMessage extends MassMessage {
    private Map<String, String> image;

    /**
     * 构造群发图片消息.
     */
    public MassImageMessage(String mediaId) {
        super(MsgType.IMAGE.name().toLowerCase());
        image = new HashMap<>();
        image.put("media_id", mediaId);
    }

    public Map<String, String> getImage() {
        return image;
    }

    public void setImage(Map<String, String> image) {
        this.image = image;
    }
}
