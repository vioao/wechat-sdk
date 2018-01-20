package me.vioao.wechat.api;

import me.vioao.wechat.Const;
import me.vioao.wechat.bean.response.BaseResponse;
import me.vioao.wechat.bean.response.user.*;
import me.vioao.wechat.utils.Params;
import me.vioao.wechat.utils.client.HttpUtil;
import me.vioao.wechat.utils.serialize.SerializeUtil;

import java.util.List;
import java.util.Map;


/**
 * 微信关注用户相关API接口.
 *
 * @author vioao
 */
public class UserApi {

    private static final String USER_INFO = Const.Uri.API_URI + "/cgi-bin/user/info";

    /**
     * 获取用户基本信息.
     *
     * @param accessToken 公众号的全局唯一接口调用凭据
     * @param lang        返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @param openid      普通用户的标识，对当前公众号唯一
     */
    public static UserResponse getUserInfo(String accessToken, String lang, String openid) {
        Map<String, String> params = Params.create("access_token", accessToken).put("openid", openid)
                .put("lang", Const.Lang.ZH_CN).get();
        return HttpUtil.getJsonBean(USER_INFO, params, UserResponse.class);
    }

    /**
     * 获取简体版关注列表.
     */
    public static UserResponse getUserInfo(String accessToken, String openid) {
        return getUserInfo(accessToken, Const.Lang.ZH_CN, openid);
    }

    private static final String USER_GET = Const.Uri.API_URI + "/cgi-bin/user/get";

    /**
     * 获取关注列表,一次拉取调用最多拉取10000个关注者的OpenID.
     *
     * @param accessToken 公众号的全局唯一接口调用凭据
     * @param nextOpenid  第一个拉取的OPENID，不填默认从头开始拉取
     */
    public static FollowResponse getUserOpenIds(String accessToken, String nextOpenid) {
        nextOpenid = nextOpenid == null ? "" : nextOpenid;
        Map<String, String> params = Params.create("access_token", accessToken).put("next_openid", nextOpenid).get();
        return HttpUtil.getJsonBean(USER_GET, params, FollowResponse.class);
    }


    private static final String USER_INFO_BATCH_GET = Const.Uri.API_URI + "/cgi-bin/user/info/batchget";

    /**
     * 批量获取用户基本信息，最多支持一次拉取100条.
     *
     * @param accessToken 公众号的全局唯一接口调用凭据
     * @param lang        国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，默认为zh-CN
     * @param openIds     openid列表
     */
    public static UserListResponse batchGetUserInfo(String accessToken, String lang, List<String> openIds) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"user_list\": [");
        for (int i = 0; i < openIds.size(); i++) {
            sb.append("{")
                    .append("\"openid\": \"").append(openIds.get(i)).append("\",")
                    .append("\"lang\": \"").append(lang).append("\"")
                    .append("}").append(i == openIds.size() - 1 ? "" : ",");
        }
        sb.append("]}");
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(USER_INFO_BATCH_GET, params, sb.toString(), UserListResponse.class);
    }

    /**
     * 批量获取简体版用户基本信息.
     */
    public static UserListResponse batchGetUserInfo(String accessToken, List<String> openIds) {
        return batchGetUserInfo(accessToken, Const.Lang.ZH_CN, openIds);
    }

    private static final String USER_INFO_UPDATE_REMARK = Const.Uri.API_URI + "/cgi-bin/user/info/updateremark";

    /**
     * 设置备注名.
     *
     * @param accessToken 公众号的全局唯一接口调用凭据
     * @param openid      普通用户的标识，对当前公众号唯一
     * @param remark      新的备注名，长度必须小于30字符
     */
    public static BaseResponse updateUserRemark(String accessToken, String openid, String remark) {
        String data = String.format("{\"openid\":\"%1$s\",\"remark\":\"%2$s\"}", openid, remark);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(USER_INFO_UPDATE_REMARK, params, data, BaseResponse.class);
    }

    private static final String TAGS_CREATE = Const.Uri.API_URI + "/cgi-bin/tags/create";

    /**
     * 创建标签，一个公众号，最多可以创建100个标签.
     *
     * @param accessToken 公众号的全局唯一接口调用凭据
     * @param name        标签名（30个字符以内）
     */
    public static TagResponse createTag(String accessToken, String name) {
        String data = String.format("{\"tag\":{\"name\":\"%1$s\"}}", name);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(TAGS_CREATE, params, data, TagResponse.class);
    }


    private static final String TAGS_GET = Const.Uri.API_URI + "/cgi-bin/tags/get";

    /**
     * 获取公众号已创建的标签.
     */
    public static TagsResponse getTags(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.getJsonBean(TAGS_GET, params, TagsResponse.class);
    }

    private static final String TAGS_UPDATE = Const.Uri.API_URI + "/cgi-bin/tags/update";

    /**
     * 修改标签名.
     *
     * @param accessToken 公众号的全局唯一接口调用凭据
     * @param id          标签ID
     * @param name        标签名（30个字符以内）
     */
    public static BaseResponse updateTag(String accessToken, int id, String name) {
        String data = "{\"tag\":{\"id\":" + id + ",\"name\":\"" + name + "\"}}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(TAGS_UPDATE, params, data, BaseResponse.class);
    }

    private static final String TAGS_DELETE = Const.Uri.API_URI + "/cgi-bin/tags/delete";

    /**
     * 删除标签<br>
     * 当某个标签下的粉丝超过10w时，后台不可直接删除标签。<br>
     * 此时，开发者可以对该标签下的openid列表，先进行取消标签的操作，直到粉丝数不超过10w后，才可直接删除该标签.
     *
     * @param accessToken 公众号的全局唯一接口调用凭据
     * @param id          标签ID
     */
    public static BaseResponse deleteTag(String accessToken, int id) {
        String data = String.format("{\"tag\":{\"id\":%1$s}}", id);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(TAGS_DELETE, params, data, BaseResponse.class);
    }


    private static final String USER_TAG_GET = Const.Uri.API_URI + "/cgi-bin/user/tag/get";

    /**
     * 获取标签下粉丝列表.
     *
     * @param tagId      标签ID
     * @param nextOpenid 第一个拉取的OPENID，不填默认从头开始拉取
     */
    public static FollowResponse getTagUserIds(String accessToken, int tagId, String nextOpenid) {
        nextOpenid = nextOpenid == null ? "" : nextOpenid;
        String data = String.format("{\"tagid\":\"%1$s\",\"next_openid\":\"%2$s\"}", tagId, nextOpenid);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(USER_TAG_GET, params, data, FollowResponse.class);
    }

    private static final String BATCH_TAG_MEMBERS = Const.Uri.API_URI + "/cgi-bin/tags/members/batchtagging";

    /**
     * 批量为用户打标签.
     *
     * @param openidList 粉丝列表
     * @param tagId      标签ID
     */
    public static BaseResponse batchTagUsers(String accessToken, List<String> openidList, int tagId) {
        String openidListStr = SerializeUtil.beanToJson(openidList);
        String data = "{\"openid_list\":" + openidListStr + ",\"tagid\":" + tagId + "}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(BATCH_TAG_MEMBERS, params, data, BaseResponse.class);
    }

    private static final String BATCH_UNTAG_MEMBERS = Const.Uri.API_URI + "/cgi-bin/tags/members/batchuntagging";

    /**
     * 批量为用户取消标签.
     *
     * @param openidList 粉丝列表
     * @param tagId      标签ID
     */
    public static BaseResponse batchUnTagUsers(String accessToken, List<String> openidList, int tagId) {
        String openidListStr = SerializeUtil.beanToJson(openidList);
        String data = "{\"openid_list\":" + openidListStr + ",\"tagid\":" + tagId + "}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(BATCH_UNTAG_MEMBERS, params, data, BaseResponse.class);
    }


    private static final String TAGS_GET_ID_LIST = Const.Uri.API_URI + "/cgi-bin/tags/getidlist";

    /**
     * 获取用户身上的标签列表.
     */
    public static TagIdListResponse getUserTagIds(String accessToken, String openid) {
        String data = String.format("{\"openid\":\"%1$s\"}", openid);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(TAGS_GET_ID_LIST, params, data, TagIdListResponse.class);
    }

    private static final String TAGS_GET_BLACK_LIST = Const.Uri.API_URI + "/cgi-bin/tags/members/getblacklist";

    /**
     * 获取公众号的黑名单列表.
     *
     * @param beginOpenid 第一个拉取的OPENID，不填默认从头开始拉取
     */
    public static FollowResponse getBlackUserIds(String accessToken, String beginOpenid) {
        beginOpenid = beginOpenid == null ? "" : beginOpenid;
        String data = String.format("{\"begin_openid\":\"%1$s\"}", beginOpenid);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(TAGS_GET_BLACK_LIST, params, data, FollowResponse.class);
    }

    private static final String TAGS_BATCH_BLACK_LIST = Const.Uri.API_URI + "/cgi-bin/tags/members/batchblacklist";

    /**
     * 拉黑用户.
     */
    public static BaseResponse blackUsers(String accessToken, List<String> openidList) {
        String openidListStr = SerializeUtil.beanToJson(openidList);
        String data = "{\"openid_list\":" + openidListStr + "}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(TAGS_BATCH_BLACK_LIST, params, data, BaseResponse.class);
    }

    private static final String TAGS_BATCH_UNBLACK_LIST = Const.Uri.API_URI + "/cgi-bin/tags/members/batchunblacklist";

    /**
     * 取消拉黑用户.
     */
    public static BaseResponse unBlackUsers(String accessToken, List<String> openidList) {
        String openidListStr = SerializeUtil.beanToJson(openidList);
        String data = "{\"openid_list\":" + openidListStr + "}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(TAGS_BATCH_UNBLACK_LIST, params, data, BaseResponse.class);
    }
}
