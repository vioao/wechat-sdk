package me.vioao.wechat.bean.response.material;


import me.vioao.wechat.bean.entity.material.MaterialBatchGetResultItem;
import me.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

public class MaterialBatchGetResponse extends BaseResponse {
    private Integer totalCount;
    private Integer itemCount;
    private List<MaterialBatchGetResultItem> item;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public List<MaterialBatchGetResultItem> getItem() {
        return item;
    }

    public void setItem(List<MaterialBatchGetResultItem> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "MaterialBatchGetResponse{"
                + "totalCount=" + totalCount
                + ", itemCount=" + itemCount
                + ", item=" + item
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
