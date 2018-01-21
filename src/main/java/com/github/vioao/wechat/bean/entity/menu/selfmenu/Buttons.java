package com.github.vioao.wechat.bean.entity.menu.selfmenu;


import java.util.List;

/**
 * @author vio
 */
public class Buttons {
    private List<Button> list;

    public List<Button> getList() {
        return list;
    }

    public void setList(List<Button> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Buttons{" +
                "list=" + list +
                '}';
    }
}
