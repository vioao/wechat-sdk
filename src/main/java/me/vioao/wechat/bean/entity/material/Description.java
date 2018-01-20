package me.vioao.wechat.bean.entity.material;

/**
 * 新增永久视频素材需特别注意.
 *
 * @author vioao
 */
public class Description {
    private String title;
    private String introduction;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Description{" +
                "title='" + title + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
