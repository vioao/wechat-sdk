package com.github.vioao.wechat.api.component.wxa;

import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.bean.response.BaseResponse;
import com.github.vioao.wechat.bean.response.component.wxa.template.LibraryAddResponse;
import com.github.vioao.wechat.bean.response.component.wxa.template.LibraryGetResponse;
import com.github.vioao.wechat.bean.response.component.wxa.template.LibraryListResponse;
import com.github.vioao.wechat.bean.response.component.wxa.template.TemplateListResponse;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.client.HttpUtil;

import java.util.List;
import java.util.Map;

/**
 * 小程序模板设置相关API. <br>
 * 为了便于第三方开发者对小程序模板消息接口的模版进行设置，更好得发送模版消息
 *
 * @author vioao
 */
public class TemplateApi {
    private static final String LIBRARY_LIST = Const.Uri.API_URI + "/cgi-bin/wxopen/template/library/list";

    /**
     * 删除已设置的二维码规则.
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     * @param offset      offset和count用于分页，表示从offset开始，拉取count条记录，offset从0开始，count最大为20。
     * @param count       offset和count用于分页，表示从offset开始，拉取count条记录，offset从0开始，count最大为20。
     */
    public static LibraryListResponse libraryList(String accessToken, Integer offset, Integer count) {
        String data = String.format("{\"offset\":%s,\"count\":%s}", offset, count);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(LIBRARY_LIST, params, data, LibraryListResponse.class);
    }


    private static final String LIBRARY_GET = Const.Uri.API_URI + "/cgi-bin/wxopen/template/library/get";

    /**
     * 获取模板库某个模板标题下关键词库.
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     * @param id          模板标题id，可通过接口获取，也可登录小程序后台查看获取
     */
    public static LibraryGetResponse libraryGet(String accessToken, String id) {
        String data = String.format("{\"id\":\"%s\"}", id);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(LIBRARY_GET, params, data, LibraryGetResponse.class);
    }


    private static final String LIBRARY_ADD = Const.Uri.API_URI + "/cgi-bin/wxopen/template/library/add";

    /**
     * 获取模板库某个模板标题下关键词库.
     *
     * @param accessToken   第三方平台获取到的该小程序授权的authorizer_access_token
     * @param id            模板标题id
     * @param keywordIdList 开发者自行组合好的模板关键词列表，
     *                      关键词顺序可以自由搭配（例如[3,5,4]或[4,5,3]），最多支持10个关键词组合
     */
    public static LibraryAddResponse libraryAdd(String accessToken, String id, List<Integer> keywordIdList) {
        String data = String.format("{\"id\":\"%s\",\"keyword_id_list\":\"%s\"}", id, keywordIdList.toString());
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(LIBRARY_ADD, params, data, LibraryAddResponse.class);
    }


    private static final String LIST = Const.Uri.API_URI + "/cgi-bin/wxopen/template/list";

    /**
     * 获取帐号下已存在的模板列表.
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     * @param offset      offset和count用于分页，表示从offset开始，拉取count条记录，offset从0开始，count最大为20。
     * @param count       offset和count用于分页，表示从offset开始，拉取count条记录，offset从0开始，count最大为20。
     */
    public static TemplateListResponse list(String accessToken, Integer offset, Integer count) {
        String data = String.format("{\"offset\":%s,\"count\":%s}", offset, count);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(LIST, params, data, TemplateListResponse.class);
    }


    private static final String DEL = Const.Uri.API_URI + "/cgi-bin/wxopen/template/del";

    /**
     * 获取模板库某个模板标题下关键词库.
     *
     * @param accessToken 第三方平台获取到的该小程序授权的authorizer_access_token
     * @param templateId  要删除的模板id
     */
    public static BaseResponse del(String accessToken, String templateId) {
        String data = String.format("{\"template_id\":\"%s\"}", templateId);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(DEL, params, data, BaseResponse.class);
    }
}