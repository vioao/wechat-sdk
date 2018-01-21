package com.github.vioao.wechat.api;

import com.github.vioao.wechat.bean.response.user.*;
import com.github.vioao.wechat.bean.response.BaseResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 用户管理API测试.
 *
 * @author vioao
 */
public class UserApiTest extends BaseApiTest {
    @Test
    public void testUserInfo() {
        UserResponse result = UserApi.getUserInfo(TOKEN, OPENID);
        System.out.println("Get user info: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }

    @Test
    public void testGetUserOpenIdsAndBatchGetUserInfo() {
        FollowResponse result1 = UserApi.getUserOpenIds(TOKEN, null);
        System.out.println("Get user openid list: " + result1);
        Assert.assertEquals(true, result1.isSuccess());

        List<String> openIds = result1.getData().getOpenid();
        if (openIds.size() > 10) {
            openIds = openIds.subList(0, 9);
        }
        UserListResponse result2 = UserApi.batchGetUserInfo(TOKEN, openIds);
        System.out.println("Batch get user info: " + result2);
        Assert.assertEquals(true, result2.isSuccess());
    }

    @Test
    public void testUpdateUserRemark() {
        BaseResponse result = UserApi.updateUserRemark(TOKEN, OPENID, "remarkUser");
        System.out.println("Update user remark: " + result);
        Assert.assertEquals(true, result.isSuccess());
    }

    @Test
    public void testCreateUpdateDelTag() {
        TagResponse result1 = UserApi.createTag(TOKEN, "MyTag");
        System.out.println("Create tag: " + result1);
        Assert.assertEquals(true, result1.isSuccess());

        BaseResponse result2 = UserApi.updateTag(TOKEN, result1.getTag().getId(), "MyTag2");
        System.out.println("Update tag: " + result2);
        Assert.assertEquals(true, result2.isSuccess());

        BaseResponse result3 = UserApi.deleteTag(TOKEN, result1.getTag().getId());
        System.out.println("Delete tag: " + result3);
        Assert.assertEquals(true, result3.isSuccess());
    }


    @Test
    public void testAboutBlackUser() {
        BaseResponse result1 = UserApi.blackUsers(TOKEN, Arrays.asList(OPENID));
        System.out.println("Black users: " + result1);
        Assert.assertEquals(true, result1.isSuccess());

        FollowResponse result2 = UserApi.getBlackUserIds(TOKEN, null);
        System.out.println("Get black user ids: " + result2);
        Assert.assertEquals(true, result2.isSuccess());

        BaseResponse result3 = UserApi.unBlackUsers(TOKEN, Arrays.asList(OPENID));
        System.out.println("UnBlack users:: " + result3);
        Assert.assertEquals(true, result3.isSuccess());
    }

    @Test
    public void testAboutTagUsers() {
        TagsResponse result1 = UserApi.getTags(TOKEN);
        System.out.println("Get tags: " + result1);
        Assert.assertEquals(true, result1.isSuccess());

        if (result1.getTags().size() > 0) {
            Integer tagId = result1.getTags().get(0).getId();

            BaseResponse result2 = UserApi.batchTagUsers(TOKEN, Arrays.asList(OPENID), tagId);
            System.out.println("Batch tag users: " + result2);
            Assert.assertEquals(true, result2.isSuccess());

            FollowResponse result3 = UserApi.getTagUserIds(TOKEN, tagId, null);
            System.out.println("Get tag users: " + result3);
            Assert.assertEquals(true, result3.isSuccess());

            BaseResponse result4 = UserApi.batchUnTagUsers(TOKEN, Arrays.asList(OPENID), tagId);
            System.out.println("Batch tag users: " + result4);
            Assert.assertEquals(true, result4.isSuccess());
        }
    }
}
