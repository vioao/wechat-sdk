package com.github.vioao.wechat.bean.entity.component;

/**
 * 权限集编号信息.
 *
 * @author vioao
 */
public class FuncScopeCategory {
    private Integer id; // 权限集编号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FuncScopeCategory{" +
                "id=" + id +
                '}';
    }
}
