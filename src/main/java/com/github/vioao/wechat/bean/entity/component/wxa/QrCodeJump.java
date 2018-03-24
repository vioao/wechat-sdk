package com.github.vioao.wechat.bean.entity.component.wxa;

import lombok.Builder;

import java.util.List;

/**
 * 扫普通链接二维码打开小程序-二维码规则.
 *
 * @author vioao
 */
@Builder
public class QrCodeJump {

    /**
     * 二维码规则
     */
    private String prefix;

    /**
     * 是否独占符合二维码前缀匹配规则的所有子规1为不占用，2为占用 <br>
     * 详细说明 ：https://mp.weixin.qq.com/debug/wxadoc/introduction/qrcode.html#前缀占用规则
     */
    private String permitSubRule;
    private String path; // 小程序功能页面

    /**
     * 测试范围： <br>
     * 1为开发版（配置只对开发者生效） <br>
     * 2为体验版（配置对管理员、体验者生效） <br>
     * 3为线上版本（配置对管理员、开发者和体验者生效） <br>
     */
    private String openVersion;

    /**
     * 测试链接（选填）可填写不多于5个用于测试的二维码完整链接，此链接必须符合已填写的二维码规则。
     */
    private List<String> debugUrl;

    /**
     * 编辑标志位(发送请求时)： <br>
     * 0表示新增二维码规则 <br>
     * 1表示修改已有二维码规则 <br>
     */
    private Integer isEdit;

    /**
     * 发布标志位(返回结果时)： <br>
     * 1表示未发布 <br>
     * 2表示已发布 <br>
     */
    private Integer state;


    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPermitSubRule() {
        return permitSubRule;
    }

    public void setPermitSubRule(String permitSubRule) {
        this.permitSubRule = permitSubRule;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOpenVersion() {
        return openVersion;
    }

    public void setOpenVersion(String openVersion) {
        this.openVersion = openVersion;
    }

    public List<String> getDebugUrl() {
        return debugUrl;
    }

    public void setDebugUrl(List<String> debugUrl) {
        this.debugUrl = debugUrl;
    }

    public Integer getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(Integer isEdit) {
        this.isEdit = isEdit;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "QrCodeJump{" +
                "prefix='" + prefix + '\'' +
                ", permitSubRule='" + permitSubRule + '\'' +
                ", path='" + path + '\'' +
                ", openVersion='" + openVersion + '\'' +
                ", debugUrl=" + debugUrl +
                ", isEdit=" + isEdit +
                ", state=" + state +
                '}';
    }
}
