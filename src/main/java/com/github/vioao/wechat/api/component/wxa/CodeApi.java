package com.github.vioao.wechat.api.component.wxa;

import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.bean.MediaFile;
import com.github.vioao.wechat.bean.entity.component.wxa.Commit;
import com.github.vioao.wechat.bean.entity.component.wxa.SubmitAudit;
import com.github.vioao.wechat.bean.response.BaseResponse;
import com.github.vioao.wechat.bean.response.component.wxa.*;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.client.HttpUtil;
import com.github.vioao.wechat.utils.serialize.SerializeUtil;

import java.util.Map;

/**
 * 代码管理.<br>
 * 第三方平台在开发者工具上开发完成后，可点击上传，代码将上传到开放平台草稿箱中，第三方平台可选择将代码添加到代码中，
 * 获得代码模版ID后，可调用以下接口进行代码管理。
 *
 * @author vioao
 */
public class CodeApi {
    private static final String COMMMIT = Const.Uri.API_URI + "/wxa/commit";

    /**
     * 为授权的小程序帐号上传小程序代码.
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     * @param commit      代码提交信息
     */
    public static BaseResponse commit(String accessToken, Commit commit) {
        String data = SerializeUtil.beanToJson(commit);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(COMMMIT, params, data, BaseResponse.class);
    }

    private static final String GET_QR_CODE = Const.Uri.API_URI + "/wxa/get_qrcode";

    /**
     * 获取体验小程序的体验二维码.
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     */
    public static MediaFile getQrCode(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.download(GET_QR_CODE, params);
    }

    private static final String GET_CATEGORY = Const.Uri.API_URI + "/wxa/get_category";

    /**
     * 获取授权小程序帐号的可选类目.
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     */
    public static GetCategoryResponse getCategory(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.getJsonBean(GET_CATEGORY, params, GetCategoryResponse.class);
    }

    private static final String GET_PAGE = Const.Uri.API_URI + "/wxa/get_page";

    /**
     * 获取小程序的第三方提交代码的页面配置（仅供第三方开发者代小程序调用）.
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     */
    public static GetPageResponse getPage(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.getJsonBean(GET_PAGE, params, GetPageResponse.class);
    }

    private static final String SUBMIT_AUDIT = Const.Uri.API_URI + "/wxa/submit_audit";

    /**
     * 将第三方提交的代码包提交审核（仅供第三方开发者代小程序调用）.
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     * @param submitAudit 代码包信息
     */
    public static SubmitAuditResponse submitAudit(String accessToken, SubmitAudit submitAudit) {
        String data = SerializeUtil.beanToJson(submitAudit);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(SUBMIT_AUDIT, params, data, SubmitAuditResponse.class);
    }


    private static final String GET_AUDIT_STATUS = Const.Uri.API_URI + "/wxa/get_auditstatus";

    /**
     * 查询某个指定版本的审核状态（仅供第三方代小程序调用）.
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     * @param auditId     提交审核时获得的审核id
     */
    public static GetAuditstatusResponse getAuditStatus(String accessToken, String auditId) {
        String data = String.format("{\"auditid\":\"%s\"}", auditId);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(GET_AUDIT_STATUS, params, data, GetAuditstatusResponse.class);
    }


    private static final String GET_LATEST_AUDIT_STATUS = Const.Uri.API_URI + "/wxa/get_latest_auditstatus";

    /**
     * 查询最新一次提交的审核状态（仅供第三方代小程序调用）.
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     * @param auditId     提交审核时获得的审核id
     */
    public static GetAuditstatusResponse getLatestAuditStatus(String accessToken, String auditId) {
        String data = String.format("{\"auditid\":\"%s\"}", auditId);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(GET_LATEST_AUDIT_STATUS, params, data, GetAuditstatusResponse.class);
    }


    private static final String RELEASE = Const.Uri.API_URI + "/wxa/release";

    /**
     * 发布已通过审核的小程序（仅供第三方代小程序调用）.
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     */
    public static BaseResponse release(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(RELEASE, params, "{}", BaseResponse.class);
    }


    private static final String REVERT_CODE_RELEASE = Const.Uri.API_URI + "/wxa/revertcoderelease";

    /**
     * 小程序版本回退（仅供第三方代小程序调用）.
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     */
    public static BaseResponse revertCoderelease(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(REVERT_CODE_RELEASE, params, "{}", BaseResponse.class);
    }


    private static final String CHANGE_VISIT_STATUS = Const.Uri.API_URI + "/wxa/change_visitstatus";

    /**
     * 修改小程序线上代码的可见状态（仅供第三方代小程序调用）.
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     * @param action      设置可访问状态，发布后默认可访问，close为不可见，open为可见
     */
    public static BaseResponse changeVisitStatus(String accessToken, String action) {
        String data = String.format("{\"action\":\"%s\"}", action);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(CHANGE_VISIT_STATUS, params, data, BaseResponse.class);
    }

    /**
     * 关闭小程序线上代码的可见状态.
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     */
    public static BaseResponse closeVisitStatus(String accessToken) {
        return changeVisitStatus(accessToken, "close");
    }

    /**
     * 打开小程序线上代码的可见状态.
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     */
    public static BaseResponse openVisitStatus(String accessToken) {
        return changeVisitStatus(accessToken, "open");
    }

    private static final String GET_WE_APP_SUPPORT_VERSION = Const.Uri.API_URI + "/wxa/getweappsupportversion";

    /**
     * 查询当前设置的最低基础库版本及各版本用户占比 （仅供第三方代小程序调用）.
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     */
    public static WeAppSupportVersionResponse getWeAppSupportVersion(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(GET_WE_APP_SUPPORT_VERSION, params, null, WeAppSupportVersionResponse.class);
    }


    private static final String SET_WE_APP_SUPPORT_VERSION = Const.Uri.API_URI + "/wxa/setweappsupportversion";

    /**
     * 设置最低基础库版本（仅供第三方代小程序调用）.
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     * @param version     版本
     */
    public static BaseResponse setWeAppSupportVersion(String accessToken, String version) {
        String data = String.format("{\"version\":\"%s\"}", version);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(SET_WE_APP_SUPPORT_VERSION, params, data, BaseResponse.class);
    }

    // todo: 实现 设置小程序“扫普通链接二维码打开小程序”能力 相关接口
    // doc: https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1489140610_Uavc4&token=&lang=zh_CN
}
