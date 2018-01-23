package com.github.vioao.wechat.api;

import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.bean.entity.poi.Poi;
import com.github.vioao.wechat.bean.response.BaseResponse;
import com.github.vioao.wechat.bean.response.poi.CategoryListResponse;
import com.github.vioao.wechat.bean.response.poi.PoiListResponse;
import com.github.vioao.wechat.bean.response.poi.PoiResponse;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.client.HttpUtil;
import com.github.vioao.wechat.utils.serialize.SerializeUtil;

import java.util.Map;

/**
 * 微信门店.
 *
 * @author vioao
 */
public class PoiApi {

    private static final String ADD_POI = Const.Uri.API_URI + "/cgi-bin/poi/addpoi";

    /**
     * 创建门店.
     */
    public static BaseResponse addPoi(String accessToken, String postJson) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(ADD_POI, params, postJson, BaseResponse.class);
    }

    /**
     * 创建门店.
     */
    public static BaseResponse addPoi(String accessToken, Poi poi) {
        return addPoi(accessToken, SerializeUtil.beanToJson(poi));
    }

    private static final String GET_POI = Const.Uri.API_URI + "/cgi-bin/poi/getpoi";

    /**
     * 查询门店信息.
     */
    public static PoiResponse getPoi(String accessToken, String poiId) {
        String data = String.format("{\"poi_id\": \"%s\"}", poiId);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(GET_POI, params, data, PoiResponse.class);
    }

    private static final String GET_POI_LIST = Const.Uri.API_URI + "/cgi-bin/poi/getpoilist";

    /**
     * 查询门店列表.
     *
     * @param begin 开始位置，0 即为从第一条开始查询
     * @param limit 返回数据条数，最大允许50，默认为20
     */
    public static PoiListResponse getPoiList(String accessToken, int begin, int limit) {
        String data = String.format("{\"begin\":%d, \"limit\": %d}", begin, limit);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(GET_POI_LIST, params, data, PoiListResponse.class);
    }

    private static final String UPDATE_POI = Const.Uri.API_URI + "/cgi-bin/poi/updatepoi";

    /**
     * 修改门店服务信息.
     */
    public static BaseResponse updatePoi(String accessToken, String postJson) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(UPDATE_POI, params, postJson, BaseResponse.class);
    }

    /**
     * 修改门店服务信息.
     */
    public static BaseResponse updatePoi(String accessToken, Poi poi) {
        return updatePoi(accessToken, SerializeUtil.beanToJson(poi));
    }

    private static final String DEL_POI = Const.Uri.API_URI + "/cgi-bin/poi/delpoi";

    /**
     * 删除门店.
     */
    public static BaseResponse delPoi(String accessToken, String poiId) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        String data = String.format("{\"poi_id\": \"%s\"}", poiId);
        return HttpUtil.postJsonBean(DEL_POI, params, data, PoiListResponse.class);
    }

    private static final String GET_WX_CATEGORY = Const.Uri.API_URI + "/cgi-bin/poi/getwxcategory";

    /**
     * 获取门店类目表.
     */
    public static CategoryListResponse getWxCategory(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.getJsonBean(GET_WX_CATEGORY, params, CategoryListResponse.class);
    }
}
