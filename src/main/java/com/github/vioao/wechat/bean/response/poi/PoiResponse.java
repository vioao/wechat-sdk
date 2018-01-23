package com.github.vioao.wechat.bean.response.poi;

import com.github.vioao.wechat.bean.entity.poi.BusinessResult;
import com.github.vioao.wechat.bean.response.BaseResponse;

/**
 * 门店信息返回.
 *
 * @author vioao
 */
public class PoiResponse extends BaseResponse {
    private BusinessResult business;

    public BusinessResult getBusiness() {
        return business;
    }

    public void setBusiness(BusinessResult business) {
        this.business = business;
    }

    @Override
    public String toString() {
        return "PoiResponse{"
                + "business=" + business
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
