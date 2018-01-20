package me.vioao.wechat.support.msg.proccessor;

import me.vioao.wechat.bean.xml.in.InMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 微信消息处理器抽象类,所有处理器需要继承它来实现.
 *
 * @author vioao
 */
public abstract class BaseMsgProcessor implements MsgProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseMsgProcessor.class);

    /**
     * 是否匹配,匹配才消费对应的消息.
     *
     * @param msg 微信消息
     */
    public abstract boolean match(InMessage msg);

    @Override
    public boolean process(InMessage msg, String out) {
        boolean processed = false;
        if (match(msg)) {
            try {
                out = doProcess(msg);
            } catch (Exception e) {
                LOGGER.error("Process wechat msg error.", e);
            }
            processed = true;
        }
        return processed;
    }

    /**
     * 处理微信消息.
     *
     * @param msg 微信消息
     * @return 处理结果
     */
    public abstract String doProcess(InMessage msg);
}
