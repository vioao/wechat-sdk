package com.github.vioao.wechat.bean.response.poi;

import com.github.vioao.wechat.bean.entity.poi.BusinessResult;
import com.github.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 门店列表信息返回.
 *
 * @author vioao
 */
public class PoiListResponse extends BaseResponse {
    private List<BusinessResult> businessList;
    private Integer totalCount;

    public List<BusinessResult> getBusinessList() {
        return businessList;
    }

    public void setBusinessList(List<BusinessResult> businessList) {
        this.businessList = businessList;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "PoiListResponse{"
                + "businessList=" + businessList
                + ", totalCount=" + totalCount
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
