package com.github.vioao.wechat.bean.entity.component.wxa;

public class GetWxaCode {
    private String path;
    private Integer width;
    private Boolean autoColor;
    private LineColor lineColor;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Boolean getAutoColor() {
        return autoColor;
    }

    public void setAutoColor(Boolean autoColor) {
        this.autoColor = autoColor;
    }

    public LineColor getLineColor() {
        return lineColor;
    }

    public void setLineColor(LineColor lineColor) {
        this.lineColor = lineColor;
    }

    @Override
    public String toString() {
        return "GetWxaCode{" +
                "path='" + path + '\'' +
                ", width=" + width +
                ", autoColor=" + autoColor +
                ", lineColor=" + lineColor +
                '}';
    }
}
