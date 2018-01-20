package me.vioao.wechat.bean.entity.template;

/**
 * 模板消息-data组件.
 *
 * @author vioao
 */
public class TemplateMessageItem {
    private String value; //消息内容文本（200字以内）
    private String color; //color为整段消息内容的字体颜色（目前仅支持整段消息为一种颜色）

    /**
     * 构造模板消息-data组件.
     */
    public TemplateMessageItem(String value, String color) {
        this.value = value;
        this.color = color;
    }

    /**
     * 构造模板消息-data组件(默认黑色字体).
     */
    public TemplateMessageItem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
