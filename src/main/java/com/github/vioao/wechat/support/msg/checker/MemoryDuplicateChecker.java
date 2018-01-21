package com.github.vioao.wechat.support.msg.checker;

import com.github.vioao.wechat.bean.xml.in.InMessage;
import com.github.vioao.wechat.utils.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 默认内存消息查重.
 *
 * @author vioao
 */
public class MemoryDuplicateChecker implements MsgDuplicateChecker {
    // 消息key - 消息时间戳
    private final Map<String, Long> keyTime = new ConcurrentHashMap<>();
    private AtomicBoolean clearThreadStarted = new AtomicBoolean(false);
    private long clearPeriod = 5L; //清理线程执行周期,默认5s
    private long keyPeriod = 10L; //消息存活周期,默认10s

    public MemoryDuplicateChecker() {
    }

    public MemoryDuplicateChecker(long clearPeriod, long keyPeriod) {
        this.clearPeriod = clearPeriod;
        this.keyPeriod = keyPeriod;
    }

    @Override
    public boolean isDuplicate(InMessage msg) {
        String key = getKey(msg);
        checkClearThreadStarted();
        return keyTime.putIfAbsent(key, System.currentTimeMillis()) != null;
    }

    private void checkClearThreadStarted() {
        if (!clearThreadStarted.getAndSet(true)) {
            ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
            executor.schedule(new ClearTask(), clearPeriod, TimeUnit.SECONDS);
        }
    }

    private String getKey(InMessage msg) {
        StringBuilder key = new StringBuilder();
        if (msg.getMsgId() == null) {
            key.append(msg.getCreateTime()).append("-").append(msg.getFromUserName())
                    .append("-").append(StringUtils.trimToEmpty(msg.getEventKey()))
                    .append("-").append(StringUtils.trimToEmpty(msg.getEvent()));
        } else {
            key.append(msg.getMsgId())
                    .append("-").append(msg.getCreateTime())
                    .append("-").append(msg.getFromUserName());
        }
        return key.toString();
    }

    class ClearTask implements Runnable {
        @Override
        public void run() {
            for (Map.Entry<String, Long> entry : keyTime.entrySet()) {
                long start = entry.getValue();
                long past = (System.currentTimeMillis() - start) / 1000;
                if (past >= keyPeriod) {
                    keyTime.entrySet().remove(entry);
                }
            }
        }
    }
}
