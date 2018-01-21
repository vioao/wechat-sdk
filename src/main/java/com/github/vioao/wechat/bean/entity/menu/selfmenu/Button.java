package com.github.vioao.wechat.bean.entity.menu.selfmenu;


import java.util.List;

public class Button {
    private String name;
    private String type;    //click|view|newsInfo|img|text|voice|video
    private String key;
    private String url;
    private String value;
    private NewsInfo newsInfo;
    private List<Button> list;
    private Buttons subButton;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Button> getList() {
        return list;
    }

    public void setList(List<Button> list) {
        this.list = list;
    }

    public Buttons getSubButton() {
        return subButton;
    }

    public void setSubButton(Buttons subButton) {
        this.subButton = subButton;
    }

    public NewsInfo getNewsInfo() {
        return newsInfo;
    }

    public void setNewsInfo(NewsInfo newsInfo) {
        this.newsInfo = newsInfo;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Button{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", key='" + key + '\'' +
                ", url='" + url + '\'' +
                ", value='" + value + '\'' +
                ", newsInfo=" + newsInfo +
                ", list=" + list +
                ", subButton=" + subButton +
                '}';
    }
}
