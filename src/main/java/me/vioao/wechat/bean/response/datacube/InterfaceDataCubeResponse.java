package me.vioao.wechat.bean.response.datacube;

import me.vioao.wechat.bean.entity.datacube.InterfaceDataCube;
import me.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

public class InterfaceDataCubeResponse extends BaseResponse {
    private List<InterfaceDataCube> list;

    public List<InterfaceDataCube> getList() {
        return list;
    }

    public void setList(List<InterfaceDataCube> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "InterfaceDataCubeResponse{"
                + "list=" + list
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
