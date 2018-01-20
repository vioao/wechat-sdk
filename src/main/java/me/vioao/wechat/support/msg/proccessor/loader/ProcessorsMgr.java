package me.vioao.wechat.support.msg.proccessor.loader;

import me.vioao.wechat.support.msg.proccessor.MsgProcessor;

import java.util.HashSet;

/**
 * 微信消息处理器管理器.
 *
 * @author vioao
 */
public interface ProcessorsMgr {
    /**
     * 获取所有的消息处理器.
     */
    HashSet<MsgProcessor> getAll();
}
