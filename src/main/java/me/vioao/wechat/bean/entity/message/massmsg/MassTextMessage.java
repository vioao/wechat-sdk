package me.vioao.wechat.bean.entity.message.massmsg;

import me.vioao.wechat.bean.entity.message.MsgType;
import me.vioao.wechat.bean.entity.message.massmsg.MassMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * 群发文本消息.
 *
 * @author vioao
 */
public class MassTextMessage extends MassMessage {
    private Map<String, String> text;

    /**
     * 构造群发文本消息对象.
     */
    public MassTextMessage(String content) {
        super(MsgType.TEXT.name().toLowerCase());
        text = new HashMap<>();
        text.put("content", content);
    }

    public Map<String, String> getText() {
        return text;
    }

    public void setText(Map<String, String> text) {
        this.text = text;
    }
}
