package me.vioao.wechat.bean.response.datacube;

import me.vioao.wechat.bean.entity.datacube.MessageDataCube;
import me.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

public class MessageDataCubeResponse extends BaseResponse {
    private List<MessageDataCube> list;

    public List<MessageDataCube> getList() {
        return list;
    }

    public void setList(List<MessageDataCube> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "MessageDataCubeResponse{"
                + "list=" + list
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
