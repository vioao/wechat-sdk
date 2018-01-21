package com.github.vioao.wechat.bean.entity.user;

/**
 * 用户标签信息.
 *
 * @author vioao
 */
public class Tag {
    private Integer id; //标签id，由微信分配
    private String name; //标签名，UTF8编码
    private Integer count; //此标签下粉丝数

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Tag{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", count=" + count
                + '}';
    }
}
