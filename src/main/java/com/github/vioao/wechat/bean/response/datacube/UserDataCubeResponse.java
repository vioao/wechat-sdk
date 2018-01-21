package com.github.vioao.wechat.bean.response.datacube;

import com.github.vioao.wechat.bean.entity.datacube.UserDataCube;
import com.github.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

public class UserDataCubeResponse extends BaseResponse {
    private List<UserDataCube> list;

    public List<UserDataCube> getList() {
        return list;
    }

    public void setList(List<UserDataCube> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "UserDataCubeResponse{"
                + "list=" + list
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
