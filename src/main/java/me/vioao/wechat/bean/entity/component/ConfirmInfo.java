package me.vioao.wechat.bean.entity.component;

/**
 * 第三方平台确认信息.
 *
 * @author vioao
 */
public class ConfirmInfo {
    private int needConfirm; //是否需要第三方平台确认（0，不需确认，1，需要认）
    private int alreadyConfirm; // already_confirm：是否已经确认。（0，未确认，1，已经确认）

    public int getNeedConfirm() {
        return needConfirm;
    }

    public void setNeedConfirm(int needConfirm) {
        this.needConfirm = needConfirm;
    }

    public int getAlreadyConfirm() {
        return alreadyConfirm;
    }

    public void setAlreadyConfirm(int alreadyConfirm) {
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
