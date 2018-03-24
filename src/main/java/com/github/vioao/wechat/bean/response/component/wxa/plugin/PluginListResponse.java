package com.github.vioao.wechat.bean.response.component.wxa.plugin;

import com.github.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 查询已添加的插件接口返回.
 *
 * @author vioao
 */
public class PluginListResponse extends BaseResponse {
    private List<Plugin> pluginList;

    public List<Plugin> getPluginList() {
        return pluginList;
    }

    public void setPluginList(List<Plugin> pluginList) {
        this.pluginList = pluginList;
    }

    @Override
    public String toString() {
        return "PluginListResponse{"
                + "errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + ", pluginList=" + pluginList
                + '}';
    }

    public static class Plugin {
        private String appid; // 插件appid
        private Integer status; // 插件状态（1：申请中，2：申请通过，3：被拒绝；4：已超时）
        private String nickname; // 插件昵称
        private String headimgurl; // 插件头像

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHeadimgurl() {
            return headimgurl;
        }

        public void setHeadimgurl(String headimgurl) {
            this.headimgurl = headimgurl;
        }

        @Override
        public String toString() {
            return "Plugin{" +
                    "appid='" + appid + '\'' +
                    ", status=" + status +
                    ", nickname='" + nickname + '\'' +
                    ", headimgurl='" + headimgurl + '\'' +
                    '}';
        }
    }
}
