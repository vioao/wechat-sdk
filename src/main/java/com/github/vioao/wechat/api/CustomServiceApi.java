package com.github.vioao.wechat.api;

import com.github.vioao.wechat.bean.response.kf.KfListResponse;
import com.github.vioao.wechat.bean.response.kf.WaitCaseResponse;
import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.bean.response.BaseResponse;
import com.github.vioao.wechat.bean.entity.kf.Session;
import com.github.vioao.wechat.bean.response.kf.MsgRecordResponse;
import com.github.vioao.wechat.bean.response.kf.SessionListResponse;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.client.HttpUtil;

import java.io.File;
import java.util.Map;

/**
 * 新客服接口.
 *
 * @author vioao
 */
public class CustomServiceApi {

    private static final String CUSTOM_ADD = Const.Uri.API_URI + "/customservice/kfaccount/add";

    /**
     * 添加客服.
     *
     * @param kfAccount 完整客服帐号，格式为：帐号前缀@公众号微信号
     * @param nickname  客服昵称，最长16个字
     */
    public static BaseResponse addAccount(String accessToken, String kfAccount, String nickname) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        String data = "{\"kf_account\":\"" + kfAccount + "\",\"nickname\":\"" + nickname + "\"}";
        return HttpUtil.postJsonBean(CUSTOM_ADD, params, data, BaseResponse.class);
    }


    private static final String INVITE_WORKER = Const.Uri.API_URI + "/customservice/kfaccount/inviteworker";

    /**
     * 邀请绑定客服帐号.
     */
    public static BaseResponse inviteWorker(String accessToken, String kfAccount, String inviteWx) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        String data = "{\"kf_account\":\"" + kfAccount + "\",\"invite_wx\":\"" + inviteWx + "\"}";
        return HttpUtil.postJsonBean(INVITE_WORKER, params, data, BaseResponse.class);
    }

    private static final String CUSTOM_UPDATE = Const.Uri.API_URI + "/customservice/kfaccount/update";

    /**
     * 修改客服.
     */
    public static BaseResponse updateAccount(String accessToken, String kfAccount, String nickname) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        String data = "{\"kf_account\":\"" + kfAccount + "\",\"nickname\":\"" + nickname + "\"}";
        return HttpUtil.postJsonBean(CUSTOM_UPDATE, params, data, BaseResponse.class);
    }

    private static final String CUSTOM_DELETE = Const.Uri.API_URI + "/customservice/kfaccount/del";

    /**
     * 删除客服.
     */
    public static BaseResponse deleteAccount(String accessToken, String kfAccount) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        String data = "{\"kf_account\":\"" + kfAccount + "\"}";
        return HttpUtil.postJsonBean(CUSTOM_DELETE, params, data, BaseResponse.class);
    }

    private static final String UPLOAD_CUSTOM_HEAD_IMG = Const.Uri.API_URI + "/customservice/kfaccount/uploadheadimg";

    /**
     * 设置客服帐号的头像.
     *
     * @param file 文件大小为5M 以内
     */
    public static BaseResponse uploadHeadImg(String accessToken, String kfAccount, File file) {
        Map<String, String> params = Params.create("access_token", accessToken).put("kf_account", kfAccount).get();
        return HttpUtil.uploadJsonBean(UPLOAD_CUSTOM_HEAD_IMG, params, file, BaseResponse.class);
    }

    private static final String GET_CUSTOM_LIST = Const.Uri.API_URI + "/cgi-bin/customservice/getkflist";

    /**
     * 获取所有客服账号.
     */
    public static KfListResponse getKfList(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.getJsonBean(GET_CUSTOM_LIST, params, KfListResponse.class);
    }

    private static final String GET_ONLINE_CUSTOM_LIST = Const.Uri.API_URI + "/cgi-bin/customservice/getonlinekflist";

    /**
     * 获取所有在线客服账号.
     */
    public static KfListResponse getOnlineKfList(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.getJsonBean(GET_ONLINE_CUSTOM_LIST, params, KfListResponse.class);
    }

    private static final String SESSION_CREATE = Const.Uri.API_URI + "/customservice/kfsession/create";

    /**
     * 创建会话.如果该客服和用户会话已存在，则直接返回0。指定的客服帐号必须已经绑定微信号且在线.
     */
    public static BaseResponse createSession(String accessToken, String kfAccount, String openId) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        String data = "{\"kf_account\":\"" + kfAccount + "\",\"openid\":\"" + openId + "\"}";
        return HttpUtil.postJsonBean(SESSION_CREATE, params, data, BaseResponse.class);
    }

    private static final String SESSION_CLOSE = Const.Uri.API_URI + "/customservice/kfsession/close";

    /**
     * 关闭会话.
     */
    public static BaseResponse closeSession(String accessToken, String kfAccount, String openId) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        String data = "{\"kf_account\":\"" + kfAccount + "\",\"openid\":\"" + openId + "\"}";
        return HttpUtil.postJsonBean(SESSION_CLOSE, params, data, BaseResponse.class);
    }

    private static final String SESSION_GET_SESSION = Const.Uri.API_URI + "/customservice/kfsession/getsession";

    /**
     * 获取客户会话状态.
     */
    public static Session getSession(String accessToken, String openId) {
        Map<String, String> params = Params.create("access_token", accessToken).put("openid", openId).get();
        return HttpUtil.getJsonBean(SESSION_GET_SESSION, params, Session.class);
    }

    private static final String SESSION_GET_SESSION_LIST =
            Const.Uri.API_URI + "/customservice/kfsession/getsessionlist";

    /**
     * 获取客服会话列表.
     */
    public static SessionListResponse getSessionList(String accessToken, String kfAccount) {
        Map<String, String> params = Params.create("access_token", accessToken).put("kf_account", kfAccount).get();
        return HttpUtil.getJsonBean(SESSION_GET_SESSION_LIST, params, SessionListResponse.class);
    }

    private static final String SESSION_GET_WAIT_CASE = Const.Uri.API_URI + "/customservice/kfsession/getwaitcase";

    /**
     * 获取未接入会话列表.
     */
    public static WaitCaseResponse getWaitCase(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.getJsonBean(SESSION_GET_WAIT_CASE, params, WaitCaseResponse.class);
    }


    private static final String MSG_RECORD_GET_LIST = Const.Uri.API_URI + "/customservice/msgrecord/getmsglist";

    /**
     * 获取聊天记录.请求的number和返回的number)不一样，则该时间段的后续聊天记录获取完毕.
     *
     * @param start  起始时间，unix时间戳
     * @param end    结束时间，unix时间戳，每次查询时段不能超过24小时
     * @param msgId  消息id顺序从小到大，从1开始
     * @param number 每次获取条数，最多10000条
     */
    public static MsgRecordResponse getMsgRecordList(String accessToken, long start, long end, int msgId, int number) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        String data = "{\"starttime\":" + start + ",\"endtime\":" + end
                + ",\"msgid\":" + msgId + ",\"number\":" + number + "}";
        return HttpUtil.getJsonBean(MSG_RECORD_GET_LIST, params, MsgRecordResponse.class);
    }

}
