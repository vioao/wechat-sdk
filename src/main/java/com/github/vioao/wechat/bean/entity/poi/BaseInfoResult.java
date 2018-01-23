package com.github.vioao.wechat.bean.entity.poi;

import lombok.Builder;

/**
 * 门店信息-返回信息.
 *
 * @author vioao
 */
@Builder
public class BaseInfoResult extends BaseInfo {
    /**
     * 门店是否可用状态。<br>
     * 1 表示系统错误 <br>
     * 2 表示审核中 <br>
     * 3 审核通过 <br>
     * 4 审核驳回 <br>
     * 当该字段为1、2、4 状态时，poi_id 为空
     */
    private Integer availableState;
    /**
     * 扩展字段是否正在更新中。<br>
     * 1 表示扩展字段正在更新中，尚未生效，不允许再次更新；<br>
     * 0 表示扩展字段没有在更新中或更新已生效，可以再次更新 <br>
     */
    private Integer updateStatus;

    public Integer getAvailableState() {
        return availableState;
    }

    public void setAvailableState(Integer availableState) {
        this.availableState = availableState;
    }

    public Integer getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(Integer updateStatus) {
        this.updateStatus = updateStatus;
    }
}
