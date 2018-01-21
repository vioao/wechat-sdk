package com.github.vioao.wechat.bean.entity.material;

public class MaterialBatchGetResultItem {
    private String mediaId;
    private NewsItem content;
    private String name;
    private String updateTime;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public NewsItem getContent() {
        return content;
    }

    public void setContent(NewsItem content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "MaterialBatchGetResultItem{" +
                "mediaId='" + mediaId + '\'' +
                ", content=" + content +
                ", name='" + name + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
