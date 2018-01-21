package com.github.vioao.wechat.bean.entity.message.msg;

import com.github.vioao.wechat.bean.entity.message.MsgType;

/**
 * 小程序信息.
 *
 * @author vioao
 */
public class MiniProgramPageMsg extends Message {
    private MiniProgramPage miniprogrampage;

    /**
     * 构造小程序消息.
     */
    public MiniProgramPageMsg(String touser, MiniProgramPage miniprogrampage) {
        super(touser, MsgType.MINIPROGRAMPAGE.name().toLowerCase());
        this.miniprogrampage = miniprogrampage;
    }

    public MiniProgramPage getMiniprogrampage() {
        return miniprogrampage;
    }

    public void setMiniprogrampage(MiniProgramPage miniprogrampage) {
        this.miniprogrampage = miniprogrampage;
    }

    public static class MiniProgramPage {
        private String title;
        private String appid;
        private String pagepath;
        private String thumbMediaId;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getPagepath() {
            return pagepath;
        }

        public void setPagepath(String pagepath) {
            this.pagepath = pagepath;
        }

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }
    }
}
