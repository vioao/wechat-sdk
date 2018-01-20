package me.vioao.wechat.api.datacube;

import me.vioao.wechat.Const;
import me.vioao.wechat.bean.response.datacube.ArticleDataCubeResponse;
import me.vioao.wechat.utils.Params;
import me.vioao.wechat.utils.client.HttpUtil;

import java.util.Map;

/**
 * 图文分析统计接口.
 * todo: 校验时间入参
 *
 * @author vioao
 */
public class ArticleDataCubeApi {

    /**
     * 获取图文分析统计结果.
     *
     * @param url         接口地址
     * @param accessToken 调用凭证
     * @param beginDate   开始时间
     * @param endDate     结束时间
     */
    private static ArticleDataCubeResponse getDataCube(String url, String accessToken,
                                                       String beginDate, String endDate) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        String postData = "{\"begin_date\":\"" + beginDate + "\",\"end_date\":\"" + endDate + "\"}";
        return HttpUtil.postJsonBean(url, params, postData, ArticleDataCubeResponse.class);
    }

    private static final String ARTICLE_SUMMARY = Const.Uri.API_URI + "/datacube/getarticlesummary";

    /**
     * 获取图文群发每日数据.
     * 最大时间跨度:1
     */
    public static ArticleDataCubeResponse getArticleSummary(String accessToken, String date) {
        return getDataCube(ARTICLE_SUMMARY, accessToken, date, date);
    }

    private static final String ARTICLE_TOTAL = Const.Uri.API_URI + "/datacube/getarticletotal";

    /**
     * 获取图文群发总数据.
     * 最大时间跨度:1
     */
    public static ArticleDataCubeResponse getArticleTotal(String accessToken, String date) {
        return getDataCube(ARTICLE_TOTAL, accessToken, date, date);
    }

    private static final String USER_READ = Const.Uri.API_URI + "/datacube/getuserread";

    /**
     * 获取图文统计数据.
     * 最大时间跨度:3
     */
    public static ArticleDataCubeResponse getUserRead(String accessToken, String beginDate, String endDate) {
        return getDataCube(USER_READ, accessToken, beginDate, endDate);
    }

    private static final String USER_READ_HOUR = Const.Uri.API_URI + "/datacube/getuserreadhour";

    /**
     * 获取图文统计分时数据.
     * 最大时间跨度:1
     */
    public static ArticleDataCubeResponse getUserReadHour(String accessToken, String date) {
        return getDataCube(USER_READ_HOUR, accessToken, date, date);
    }

    private static final String USER_SHARE = Const.Uri.API_URI + "/datacube/getusershare";

    /**
     * 获取图文分享转发数据.
     * 最大时间跨度:7
     */
    public static ArticleDataCubeResponse getUserShare(String accessToken, String beginDate, String endDate) {
        return getDataCube(USER_SHARE, accessToken, beginDate, endDate);
    }

    private static final String USER_SHARE_HOUR = Const.Uri.API_URI + "/datacube/getusersharehour";

    /**
     * 获取图文分享转发分时数据.
     * 最大时间跨度:1
     */
    public static ArticleDataCubeResponse getUserShareHour(String accessToken, String date) {
        return getDataCube(USER_SHARE_HOUR, accessToken, date, date);
    }

}
