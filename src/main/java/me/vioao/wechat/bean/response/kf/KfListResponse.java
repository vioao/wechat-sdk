package me.vioao.wechat.bean.response.kf;

import me.vioao.wechat.bean.entity.kf.KfAccount;
import me.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

/**
 * 客服账号列表.
 *
 * @author vioao
 */
public class KfListResponse extends BaseResponse {
    private List<KfAccount> kfList;

    public List<KfAccount> getKfList() {
        return kfList;
    }

    public void setKfList(List<KfAccount> kfList) {
        this.kfList = kfList;
    }

    @Override
    public String toString() {
        return "KfListResponse{"
                + "kfList=" + kfList
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
