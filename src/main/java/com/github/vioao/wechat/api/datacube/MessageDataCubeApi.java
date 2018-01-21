package com.github.vioao.wechat.api.datacube;

import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.bean.response.datacube.MessageDataCubeResponse;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * 消息分析统计接口.
 * todo: 校验时间入参
 *
 * @author vioao
 */
public class MessageDataCubeApi {

    /**
     * 获取消息分析统计结果.
     *
     * @param url         接口地址
     * @param accessToken 调用凭证
     * @param beginDate   开始时间
     * @param endDate     结束时间
     */
    private static MessageDataCubeResponse getDataCube(String url, String accessToken,
                                                       String beginDate, String endDate) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        String postData = "{\"begin_date\":\"" + beginDate + "\",\"end_date\":\"" + endDate + "\"}";
        return HttpUtil.postJsonBean(url, params, postData, MessageDataCubeResponse.class);
    }

    private static final String UPSTREAMMSG_HOUR = Const.Uri.API_URI + "/datacube/getupstreammsghour";

    /**
     * 获取消息分送分时数据.
     * 最大时间跨度:1
     */
    public static MessageDataCubeResponse getUpStreamMsgHour(String accessToken, String date) {
        return getDataCube(UPSTREAMMSG_HOUR, accessToken, date, date);
    }

    private static final String UPSTREAM_MSG = Const.Uri.API_URI + "/datacube/getupstreammsg";

    /**
     * 获取消息发送概况数据.
     * 最大时间跨度:7
     */
    public static MessageDataCubeResponse getUpStreamMsg(String accessToken, String beginDate, String endDate) {
        return getDataCube(UPSTREAM_MSG, accessToken, beginDate, endDate);
    }

    private static final String UPSTREAMMSG_WEEK = Const.Uri.API_URI + "/datacube/getupstreammsgweek";

    /**
     * 获取消息发送周数据.
     * 最大时间跨度:30
     */
    public static MessageDataCubeResponse getUpStreamMsgWeek(String accessToken, String beginDate, String endDate) {
        return getDataCube(UPSTREAMMSG_WEEK, accessToken, beginDate, endDate);
    }

    private static final String UPSTREAMMSG_MONTH = Const.Uri.API_URI + "/datacube/getupstreammsgmonth";

    /**
     * 获取消息发送月数据.
     * 最大时间跨度:30
     */
    public static MessageDataCubeResponse getUpStreamMsgMonth(String accessToken, String beginDate, String endDate) {
        return getDataCube(UPSTREAMMSG_MONTH, accessToken, beginDate, endDate);
    }

    private static final String UPSTREAMMSG_DIST = Const.Uri.API_URI + "/datacube/getupstreammsgdist";

    /**
     * 获取消息发送分布数据.
     * 最大时间跨度:15
     */
    public static MessageDataCubeResponse getUpStreamMsgDist(String accessToken, String beginDate, String endDate) {
        return getDataCube(UPSTREAMMSG_DIST, accessToken, beginDate, endDate);
    }

    private static final String UPSTREAMMSG_DIST_WEEK = Const.Uri.API_URI + "/datacube/getupstreammsgdistweek";

    /**
     * 获取消息发送分布周数据.
     * 最大时间跨度:15
     */
    public static MessageDataCubeResponse getUpStreammsgDistWeek(String accessToken, String beginDate,
                                                                 String endDate) {
        return getDataCube(UPSTREAMMSG_DIST_WEEK, accessToken, beginDate, endDate);
    }

    private static final String UPSTREAMMSG_DIST_MONTH = Const.Uri.API_URI + "/datacube/getupstreammsgdistmonth";

    /**
     * 获取消息发送分布月数据.
     * 最大时间跨度:15
     */
    public static MessageDataCubeResponse getUpStreamMsgDistMonth(String accessToken, String beginDate,
                                                                  String endDate) {
        return getDataCube(UPSTREAMMSG_DIST_MONTH, accessToken, beginDate, endDate);
    }
}
