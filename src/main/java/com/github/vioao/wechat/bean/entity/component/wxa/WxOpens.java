package com.github.vioao.wechat.bean.entity.component.wxa;

import java.util.List;

/**
 * 关联的小程序列表信息实体.
 *
 * @author vioao
 */
public class WxOpens {
    private List<Items> items;

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "WxOpens{" +
                "items=" + items +
                '}';
    }

    public static class Items {
        /**
         * 关联状态 <br>
         * 1：已关联 <br>
         * 2：等待小程序管理员确认中 <br>
         * 3：小程序管理员拒绝关联 <br>
         * 12：等到公众号管理员确认中 <br>
         */
        private Integer status;
        private String username; // 小程序gh_id
        private String source;
        private String nickname; // 小程序名称
        private Integer selected; // 是否在公众号管理页展示中
        private Integer nearbyDisplayStatus; // 是否展示在附近的小程序中
        private Integer released; // 是否已经发布
        private Integer copyVrifyStatus;
        private String headimg_url; // 头像url
        private List<FuncInfos> funcInfos; // 微信认证及支付信息，0表示未开通，1表示开通

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public Integer getSelected() {
            return selected;
        }

        public void setSelected(Integer selected) {
            this.selected = selected;
        }

        public Integer getNearbyDisplayStatus() {
            return nearbyDisplayStatus;
        }

        public void setNearbyDisplayStatus(Integer nearbyDisplayStatus) {
            this.nearbyDisplayStatus = nearbyDisplayStatus;
        }

        public Integer getReleased() {
            return released;
        }

        public void setReleased(Integer released) {
            this.released = released;
        }

        public Integer getCopyVrifyStatus() {
            return copyVrifyStatus;
        }

        public void setCopyVrifyStatus(Integer copyVrifyStatus) {
            this.copyVrifyStatus = copyVrifyStatus;
        }

        public String getHeadimg_url() {
            return headimg_url;
        }

        public void setHeadimg_url(String headimg_url) {
            this.headimg_url = headimg_url;
        }

        public List<FuncInfos> getFuncInfos() {
            return funcInfos;
        }

        public void setFuncInfos(List<FuncInfos> funcInfos) {
            this.funcInfos = funcInfos;
        }

        @Override
        public String toString() {
            return "Items{" +
                    "status=" + status +
                    ", username='" + username + '\'' +
                    ", source='" + source + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", selected=" + selected +
                    ", nearbyDisplayStatus=" + nearbyDisplayStatus +
                    ", released=" + released +
                    ", copyVrifyStatus=" + copyVrifyStatus +
                    ", headimg_url='" + headimg_url + '\'' +
                    ", funcInfos=" + funcInfos +
                    '}';
        }
    }

    public static class FuncInfos {
        private Integer status;
        private Integer id;
        private String name;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "funcInfos{" +
                    "status=" + status +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
