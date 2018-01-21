package com.github.vioao.wechat.api;

import com.github.vioao.wechat.bean.response.menu.GetMenuResponse;
import com.github.vioao.wechat.utils.client.HttpUtil;
import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.bean.response.BaseResponse;
import com.github.vioao.wechat.bean.entity.menu.MenuButtons;
import com.github.vioao.wechat.bean.response.menu.TryMatchResponse;
import com.github.vioao.wechat.bean.response.menu.selfmenu.GetCurrentSelfMenuInfoResponse;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.serialize.SerializeUtil;

import java.util.Map;

/**
 * 微信菜单相关API实现.
 *
 * @author vioao
 */
public class MenuApi {

    private static final String MENU_CREATE = Const.Uri.API_URI + "/cgi-bin/menu/create";

    /**
     * 创建菜单.
     * doc: https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141013
     *
     * @param accessToken 公众号的全局唯一接口调用凭据
     * @param menuJson    菜单json 数据 例如{\"button\":[{\"type\":\"click\",\"name\":\"今日歌曲\",\"key\"
     *                    :\"V1001_TODAY_MUSIC\"},{\"type\":\"click\",\"name\":\"歌手简介\",\"key\":
     *                    \"V1001_TODAY_SINGER\"},{\"name\":\"菜单\",\"sub_button\":[{\"type\":\"view\",\"name\":
     *                    \"搜索\",\"url\":\"http://www.soso.com/\"},{\"type\":\"view\",\"name\":\"视频\",
     *                    \"url\":\"http://v.qq.com/\"},{\"type\":\"click\",\"name\":\"赞一下我们\",
     *                    \"key\":\"V1001_GOOD\"}]}]}
     */
    public static BaseResponse create(String accessToken, String menuJson) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(MENU_CREATE, params, menuJson, BaseResponse.class);
    }

    /**
     * 创建菜单.
     *
     * @param accessToken 公众号的全局唯一接口调用凭据
     * @param menuButtons 菜单Bean
     */
    public static BaseResponse create(String accessToken, MenuButtons menuButtons) {
        String str = SerializeUtil.beanToJson(menuButtons);
        return create(accessToken, str);
    }

    private static final String MENU_GET = Const.Uri.API_URI + "/cgi-bin/menu/get";

    /**
     * 获取菜单.
     */
    public static GetMenuResponse get(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.getJsonBean(MENU_GET, params, GetMenuResponse.class);
    }

    private static final String MENU_DELETE = Const.Uri.API_URI + "/cgi-bin/menu/delete";

    /**
     * 删除菜单,在个性化菜单时，调用此接口会删除默认菜单及全部个性化菜单.
     */
    public static BaseResponse delete(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.getJsonBean(MENU_DELETE, params, BaseResponse.class);
    }


    private static final String GET_CURRENT_SELFMENU_INFO = Const.Uri.API_URI + "/cgi-bin/get_current_selfmenu_info";

    /**
     * 获取自定义菜单配置接口.
     */
    public static GetCurrentSelfMenuInfoResponse getCurrentSelfMenuInfo(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.getJsonBean(GET_CURRENT_SELFMENU_INFO, params, GetCurrentSelfMenuInfoResponse.class);
    }

    private static final String MENU_ADD_CONDITIONAL = Const.Uri.API_URI + "/cgi-bin/menu/addconditional";

    /**
     * 创建个性化菜单.
     */
    public static BaseResponse addconditional(String accessToken, MenuButtons menuButtons) {
        String menuJson = SerializeUtil.beanToJson(menuButtons);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(MENU_ADD_CONDITIONAL, params, menuJson, BaseResponse.class);
    }

    private static final String MENU_DELETE_CONDITIONAL = Const.Uri.API_URI + "/cgi-bin/menu/delconditional";

    /**
     * 删除个性化菜单.
     */
    public static BaseResponse delconditional(String accessToken, String menuId) {
        String data = "{\"menuid\":\"" + menuId + "\"}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(MENU_DELETE_CONDITIONAL, params, data, BaseResponse.class);
    }

    private static final String MENU_TRY_MATCH = Const.Uri.API_URI + "/cgi-bin/menu/trymatch";

    /**
     * 测试个性化菜单匹配结果.
     *
     * @param accessToken 公众号的全局唯一接口调用凭据
     * @param userId      可以是粉丝的OpenID，也可以是粉丝的微信号。
     */
    public static TryMatchResponse trymatch(String accessToken, String userId) {
        String data = "{\"user_id\":\"" + userId + "\"}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(MENU_TRY_MATCH, params, data, TryMatchResponse.class);
    }
}