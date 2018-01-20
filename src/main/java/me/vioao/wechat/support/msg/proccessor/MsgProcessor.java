package me.vioao.wechat.support.msg.proccessor;

import me.vioao.wechat.bean.xml.in.InMessage;


/**
 * 微信消息处理器.
 *
 * @author vioao
 */
public interface MsgProcessor {
    /**
     * 消费处理微信消息.
     *
     * @param inMsg 微信消息
     * @param out   返回的结果
     */
    boolean process(InMessage inMsg, String out);
}
