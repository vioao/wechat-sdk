package me.vioao.wechat.bean.response.user;

import me.vioao.wechat.bean.entity.user.User;
import me.vioao.wechat.bean.response.BaseResponse;

import java.util.List;

public class UserListResponse extends BaseResponse {
    private List<User> userInfoList;

    public List<User> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<User> userInfoList) {
        this.userInfoList = userInfoList;
    }

    @Override
    public String toString() {
        return "UserListResponse{"
                + "userInfoList=" + userInfoList
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }
}
