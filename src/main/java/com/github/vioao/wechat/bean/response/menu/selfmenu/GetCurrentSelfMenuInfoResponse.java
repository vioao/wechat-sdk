package com.github.vioao.wechat.bean.response.menu.selfmenu;

import com.github.vioao.wechat.bean.entity.menu.selfmenu.SelfMenuInfo;
import com.github.vioao.wechat.bean.response.BaseResponse;

public class GetCurrentSelfMenuInfoResponse extends BaseResponse {
    private Integer isMenuOpen;
    private SelfMenuInfo selfmenuInfo;

    public Integer getIsMenuOpen() {
        return isMenuOpen;
    }

    public void setIsMenuOpen(Integer isMenuOpen) {
        this.isMenuOpen = isMenuOpen;
    }

    public SelfMenuInfo getSelfmenuInfo() {
        return selfmenuInfo;
    }

    public void setSelfmenuInfo(SelfMenuInfo selfmenuInfo) {
        this.selfmenuInfo = selfmenuInfo;
    }

    @Override
    public String toString() {
        return "GetCurrentSelfMenuInfoResponse{"
                + "isMenuOpen=" + isMenuOpen
                + ", selfmenuInfo=" + selfmenuInfo
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
