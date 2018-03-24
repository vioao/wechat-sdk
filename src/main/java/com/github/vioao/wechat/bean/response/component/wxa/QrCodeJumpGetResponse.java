package com.github.vioao.wechat.bean.response.component.wxa;

import com.github.vioao.wechat.bean.entity.component.wxa.QrCodeJump;
import com.github.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 获取已设置的二维码规则接口返回结果.
 *
 * @author vioao
 */
public class QrCodeJumpGetResponse extends BaseResponse {
    private Integer qrcodejumpOpen; //	是否已经打开二维码跳转链接设置
    private Integer qrcodejumpPubQuota; // 本月还可发布的次数
    private Integer listSize; // 二维码规则数量
    private List<QrCodeJump> ruleList;    // 二维码规则详情，数组形式

    public Integer getQrcodejumpOpen() {
        return qrcodejumpOpen;
    }

    public void setQrcodejumpOpen(Integer qrcodejumpOpen) {
        this.qrcodejumpOpen = qrcodejumpOpen;
    }

    public Integer getQrcodejumpPubQuota() {
        return qrcodejumpPubQuota;
    }

    public void setQrcodejumpPubQuota(Integer qrcodejumpPubQuota) {
        this.qrcodejumpPubQuota = qrcodejumpPubQuota;
    }

    public Integer getListSize() {
        return listSize;
    }

    public void setListSize(Integer listSize) {
        this.listSize = listSize;
    }

    @Override
    public String toString() {
        return "QrCodeJumpGetResponse{"
                + "qrcodejumpOpen=" + qrcodejumpOpen
                + ", qrcodejumpPubQuota=" + qrcodejumpPubQuota
                + ", listSize=" + listSize
                + ", ruleList=" + ruleList
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
