package com.github.vioao.wechat.bean.entity.component.wxa;

import lombok.Builder;

import java.util.List;

/**
 * 代码包信息.
 *
 * @author vioao
 */
public class SubmitAudit {
    private List<Item> itemList; //提交审核项的一个列表（至少填写1项，至多填写5项）

    public SubmitAudit(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Builder
    public static class Item {
        private String address; //小程序的页面，可通过“获取小程序的第三方提交代码的页面配置”接口获得
        private String tag; //小程序的标签，多个标签用空格分隔，标签不能多于10个，标签长度不超过20
        private String firstClass; //一级类目名称，可通过“获取授权小程序帐号的可选类目”接口获得
        private String secondClass;//二级类目(同上)
        private String thirdClass;//三级类目(同上)
        private Integer firstId; //一级类目的ID，可通过“获取授权小程序帐号的可选类目”接口获得
        private Integer secondId;//二级类目ID(同上)
        private Integer thirdId;//三级类目ID(同上)
        private String title;//小程序页面的标题,标题长度不超过32

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getFirstClass() {
            return firstClass;
        }

        public void setFirstClass(String firstClass) {
            this.firstClass = firstClass;
        }

        public String getSecondClass() {
            return secondClass;
        }

        public void setSecondClass(String secondClass) {
            this.secondClass = secondClass;
        }

        public String getThirdClass() {
            return thirdClass;
        }

        public void setThirdClass(String thirdClass) {
            this.thirdClass = thirdClass;
        }

        public Integer getFirstId() {
            return firstId;
        }

        public void setFirstId(Integer firstId) {
            this.firstId = firstId;
        }

        public Integer getSecondId() {
            return secondId;
        }

        public void setSecondId(Integer secondId) {
            this.secondId = secondId;
        }

        public Integer getThirdId() {
            return thirdId;
        }

        public void setThirdId(Integer thirdId) {
            this.thirdId = thirdId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    @Override
    public String toString() {
        return "SubmitAudit{" +
                "itemList=" + itemList +
                '}';
    }
}
