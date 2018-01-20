package me.vioao.wechat.api;

import me.vioao.wechat.Const;
import me.vioao.wechat.bean.response.comment.CommentListResponse;
import me.vioao.wechat.bean.entity.comment.CommentRequest;
import me.vioao.wechat.bean.response.BaseResponse;
import me.vioao.wechat.utils.Params;
import me.vioao.wechat.utils.client.HttpUtil;
import me.vioao.wechat.utils.serialize.SerializeUtil;

import java.util.Map;

/**
 * 评论数据管理接口.
 *
 * @author vioao
 */
public class CommentApi {
    private static final String OPEN_COMMENT = Const.Uri.API_URI + "/cgi-bin/comment/open";
    private static final String CLOSE_COMMENT = Const.Uri.API_URI + "/cgi-bin/comment/close";
    private static final String LIST_COMMENT = Const.Uri.API_URI + "/cgi-bin/comment/list";
    private static final String MARKELECT_COMMENT = Const.Uri.API_URI + "/cgi-bin/comment/markelect";
    private static final String UMMARKELECT_COMMENT = Const.Uri.API_URI + "/cgi-bin/comment/unmarkelect";
    private static final String DELETE_COMMENT = Const.Uri.API_URI + "/cgi-bin/comment/delete";
    private static final String ADD_REPLY_COMMENT = Const.Uri.API_URI + "/cgi-bin/comment/reply/add";
    private static final String DELETE_REPLY_COMMENT = Const.Uri.API_URI + "/cgi-bin/comment/reply/delete";

    /**
     * 打开已群发文章评论.
     *
     * @param accessToken 调用凭证
     * @param msgDataId   群发返回的msg_data_id
     * @param index       多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     */
    public static BaseResponse openComment(String accessToken, String msgDataId, Integer index) {
        String json = "{\"msg_data_id\":\"" + msgDataId + "\",\"index\":\"" + index + "\"}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(OPEN_COMMENT, params, json, BaseResponse.class);
    }

    /**
     * 关闭已群发文章评论.
     *
     * @param accessToken 调用凭证
     * @param msgDataId   群发返回的msg_data_id
     * @param index       多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     */
    public static BaseResponse closeComment(String accessToken, String msgDataId, Integer index) {
        String json = "{\"msg_data_id\":\"" + msgDataId + "\",\"index\":\"" + index + "\"}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(CLOSE_COMMENT, params, json, BaseResponse.class);
    }

    /**
     * 查看指定文章的评论数据.
     *
     * @param accessToken 调用凭证
     * @param commentView 要查看哪个素材哪个条目的评论
     */
    public static CommentListResponse listComment(String accessToken, CommentRequest commentView) {
        String messageJson = SerializeUtil.beanToJson(commentView);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(LIST_COMMENT, params, messageJson, CommentListResponse.class);
    }

    /**
     * 将评论标记精选.
     *
     * @param accessToken   调用凭证
     * @param msgDataId     群发返回的msg_data_id
     * @param index         多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     */
    public static BaseResponse markelectComment(String accessToken, String msgDataId,
                                                Integer index, String userCommentId) {
        String json = "{\"msg_data_id\":\"" + msgDataId + "\",\"index\":\"" + index
                + "\",\"user_comment_id\":\"" + userCommentId + "\"}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(MARKELECT_COMMENT, params, json, BaseResponse.class);
    }

    /**
     * 将评论取消精选.
     *
     * @param accessToken   调用凭证
     * @param msgDataId     群发返回的msg_data_id
     * @param index         多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     */
    public static BaseResponse unmarkelectComment(String accessToken, String msgDataId, Integer index,
                                                  String userCommentId) {
        String json = "{\"msg_data_id\":\"" + msgDataId + "\",\"index\":\"" + index
                + "\",\"user_comment_id\":\"" + userCommentId + "\"}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(UMMARKELECT_COMMENT, params, json, BaseResponse.class);
    }

    /**
     * 删除评论.
     *
     * @param accessToken   调用凭证
     * @param msgDataId     群发返回的msg_data_id
     * @param index         多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     */
    public static BaseResponse deleteComment(String accessToken, String msgDataId, Integer index, String userCommentId) {
        String json = "{\"msg_data_id\":\"" + msgDataId + "\",\"index\":\"" + index
                + "\",\"user_comment_id\":\"" + userCommentId + "\"}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(DELETE_COMMENT, params, json, BaseResponse.class);
    }

    /**
     * 添加回复.
     *
     * @param accessToken   调用凭证
     * @param msgDataId     群发返回的msg_data_id
     * @param index         多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     * @param content       回复内容
     */
    public static BaseResponse addReplyComment(String accessToken, String msgDataId, Integer index, String userCommentId,
                                               String content) {
        String json = "{\"msg_data_id\":\"" + msgDataId + "\",\"index\":\"" + index
                + "\",\"user_comment_id\":\"" + userCommentId + "\",\"content\":\"" + content + "\"}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(ADD_REPLY_COMMENT, params, json, BaseResponse.class);
    }

    /**
     * 删除回复.
     *
     * @param accessToken   调用凭证
     * @param msgDataId     群发返回的msg_data_id
     * @param index         多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     */
    public static BaseResponse deleteReplyComment(String accessToken, String msgDataId, Integer index,
                                                  String userCommentId) {
        String json = "{\"msg_data_id\":\"" + msgDataId + "\",\"index\":\"" + index
                + "\",\"user_comment_id\":\"" + userCommentId + "\"}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(DELETE_REPLY_COMMENT, params, json, BaseResponse.class);
    }
}
