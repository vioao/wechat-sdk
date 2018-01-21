package com.github.vioao.wechat.bean.entity.component;

/**
 * 第三方平台确认信息.
 *
 * @author vioao
 */
public class ConfirmInfo {
    private Integer needConfirm; //是否需要第三方平台确认（0，不需确认，1，需要认）
    private Integer alreadyConfirm; // already_confirm：是否已经确认。（0，未确认，1，已经确认）

    public Integer getNeedConfirm() {
        return needConfirm;
    }

    public void setNeedConfirm(Integer needConfirm) {
        this.needConfirm = needConfirm;
    }

    public Integer getAlreadyConfirm() {
        return alreadyConfirm;
    }

    public void setAlreadyConfirm(Integer alreadyConfirm) {
        this.alreadyConfirm = alreadyConfirm;
    }

    @Override
    public String toString() {
        return "ConfirmInfo{" +
                "needConfirm=" + needConfirm +
                ", alreadyConfirm=" + alreadyConfirm +
                '}';
    }
}
