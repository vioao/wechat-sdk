package com.github.vioao.wechat.bean.entity.menu.selfmenu;

import java.util.List;

public class SelfMenuInfo {
    private List<Button> button;

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "SelfMenuInfo{" +
                "button=" + button +
                '}';
    }
}
