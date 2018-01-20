package me.vioao.wechat.bean.entity.message.massmsg;

/**
 * 用于设定消息的接收者.
 *
 * @author vioao
 */
public class Filter {
    //用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据tag_id发送给指定群组的用户
    private boolean isToAll;
    private String tagId; //群发到的标签的tag_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id

    /**
     * 构造群发接受者过滤.
     */
    public Filter(boolean isToAll, String tagId) {
        super();
        this.isToAll = isToAll;
        this.tagId = tagId;
    }

    public boolean isToAll() {
        return isToAll;
    }

    public void setToAll(boolean toAll) {
        this.isToAll = toAll;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }
}
