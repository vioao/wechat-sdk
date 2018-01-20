package me.vioao.wechat.api.datacube;

import me.vioao.wechat.Const;
import me.vioao.wechat.bean.response.datacube.InterfaceDataCubeResponse;
import me.vioao.wechat.utils.Params;
import me.vioao.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * 接口分析统计接口.
 * todo: 校验时间入参
 *
 * @author vioao
 */
public class InterfaceDataCubeApi {

    /**
     * 获取接口分析统计结果.
     *
     * @param url         接口地址
     * @param accessToken 调用凭证
     * @param beginDate   开始时间
     * @param endDate     结束时间
     */
    private static InterfaceDataCubeResponse getDataCube(String url, String accessToken,
                                                         String beginDate, String endDate) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        String postData = "{\"begin_date\":\"" + beginDate + "\",\"end_date\":\"" + endDate + "\"}";
        return HttpUtil.postJsonBean(url, params, postData, InterfaceDataCubeResponse.class);
    }


    private static final String INTERFACE_SUMMARY = Const.Uri.API_URI + "/datacube/getinterfacesummary";

    /**
     * 获取接口分析数据.
     * 最大时间跨度:30
     */
    public static InterfaceDataCubeResponse getInterfaceSummary(String accessToken, String beginDate, String endDate) {
        return getDataCube(INTERFACE_SUMMARY, accessToken, beginDate, endDate);
    }

    private static final String INTERFACE_SUMMARY_HOUR = Const.Uri.API_URI + "/datacube/getinterfacesummaryhour";

    /**
     * 获取接口分析分时数据.
     * 最大时间跨度:1
     */
    public static InterfaceDataCubeResponse getInterfaceSummaryHour(String accessToken, String date) {
        return getDataCube(INTERFACE_SUMMARY_HOUR, accessToken, date, date);
    }

}
