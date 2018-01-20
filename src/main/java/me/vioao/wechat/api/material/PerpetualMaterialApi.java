package me.vioao.wechat.api.material;

import me.vioao.wechat.Const;
import me.vioao.wechat.bean.MediaFile;
import me.vioao.wechat.bean.entity.material.Description;
import me.vioao.wechat.bean.entity.material.MaterialType;
import me.vioao.wechat.bean.entity.message.Article;
import me.vioao.wechat.bean.response.BaseResponse;
import me.vioao.wechat.bean.response.material.NewsItemResponse;
import me.vioao.wechat.bean.response.material.MaterialBatchGetResponse;
import me.vioao.wechat.bean.response.material.MaterialCountResponse;
import me.vioao.wechat.bean.response.media.MediaResponse;
import me.vioao.wechat.bean.response.media.UrlResponse;
import me.vioao.wechat.bean.response.media.VideoMediaResponse;
import me.vioao.wechat.utils.Params;
import me.vioao.wechat.utils.client.HttpUtil;
import me.vioao.wechat.utils.serialize.SerializeUtil;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 永久素材.
 * 1、最近更新：永久图片素材新增后，将带有URL返回给开发者，开发者可以在腾讯系域名内使用（腾讯系域名外使用，图片将被屏蔽）
 * 2、公众号的素材库保存总数量有上限：图文消息素材、图片素材上限为5000，其他类型为1000。
 * 3、素材的格式大小等要求与公众平台官网一致：
 * 图片（image）: 2M，支持bmp/png/jpeg/jpg/gif格式
 * 语音（voice）：2M，播放长度不超过60s，mp3/wma/wav/amr格式
 * 视频（video）：10MB，支持MP4格式
 * 缩略图（thumb）：64KB，支持JPG格式
 * 4、图文消息的具体内容中，微信后台将过滤外部的图片链接，图片url需通过"上传图文消息内的图片获取URL"接口上传图片获取。
 * 5、"上传图文消息内的图片获取URL"接口所上传的图片，不占用公众号的素材库中图片数量的5000个的限制，图片仅支持jpg/png格式，大小必须在1MB以下。
 * 6、图文消息支持正文中插入自己帐号和其他公众号已群发文章链接的能力。
 *
 * @author vioao
 */
public class PerpetualMaterialApi {
    private static final String ADD_NEWS = Const.Uri.API_URI + "/cgi-bin/material/add_news";
    private static final String UPDATE_NEWS = Const.Uri.API_URI + "/cgi-bin/material/update_news";
    private static final String ADD_MATERIAL = Const.Uri.API_URI + "/cgi-bin/material/add_material";
    private static final String GET_MATERIAL = Const.Uri.API_URI + "/cgi-bin/material/get_material";
    private static final String BATCH_GET_MATERIAL = Const.Uri.API_URI + "/cgi-bin/material/batchget_material";
    private static final String DEL_MATERIAL = Const.Uri.API_URI + "/cgi-bin/material/del_material";
    private static final String GET_MATERIAL_COUNT = Const.Uri.API_URI + "/cgi-bin/material/get_materialcount";
    private static final String UPLOAD_IMG = Const.Uri.API_URI + "/cgi-bin/media/uploadimg";
    private static final String UPLOAD_NEWS = Const.Uri.API_URI + "/cgi-bin/media/uploadnews";

    /**
     * 上传图文消息素材(订阅号与服务号认证后均可用).
     *
     * @param articles 图文信息 1-10 个
     */
    public static MediaResponse uploadNews(String accessToken, List<Article> articles) {
        String str = SerializeUtil.beanToJson(articles);
        String messageJson = "{\"articles\":" + str + "}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(UPLOAD_NEWS, params, messageJson, MediaResponse.class);
    }

    /**
     * 上传图文消息内的图片获取URL(订阅号与服务号认证后均可用).
     * 本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下.
     */
    public static UrlResponse uploadImg(String accessToken, File file) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.uploadJsonBean(UPLOAD_IMG, params, file, UrlResponse.class);
    }

    /**
     * 新增永久图文素材.
     *
     * @param accessToken 调用凭证
     * @param articles    图文条目
     */
    public static MediaResponse addNews(String accessToken, List<Article> articles) {
        String str = SerializeUtil.beanToJson(articles);
        String data = "{\"articles\":" + str + "}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(ADD_NEWS, params, data, MediaResponse.class);
    }

    /**
     * 修改永久图文素材.
     *
     * @param accessToken 调用凭证
     * @param mediaId     要修改的图文消息的id
     * @param index       要更新的文章在图文消息中的位置（多图文消息时，此字段才有意义），第一篇为0
     * @param articles    图文条目
     */
    public static BaseResponse updateNews(String accessToken, String mediaId, int index, List<Article> articles) {
        //todo:写测试用例
        String str = SerializeUtil.beanToJson(articles);
        String data = "{\"media_id\":\"" + mediaId + "\",\"index\":" + index + ",\"articles\":" + str + "}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(UPDATE_NEWS, params, data, BaseResponse.class);
    }

    /**
     * 新增其他类型永久素材.
     *
     * @param accessToken 调用凭证
     * @param type        素材类型，图片（image），语音（voice），视频（video），缩略图（thumb）
     * @param file        文件
     * @param description 视频文件类型额外字段，其它类型不用添加
     */
    private static MediaResponse addMaterial(String accessToken, String type, File file, Description description) {
        Map<String, String> params = Params.create("access_token", accessToken).put("type", type).get();
        if (description != null) {
            // 上传视频素材时需要此参数
            params.put("description", SerializeUtil.beanToJson(description));
        }
        return HttpUtil.uploadJsonBean(ADD_MATERIAL, params, file, MediaResponse.class);
    }

    /**
     * 新增图片临时素材.
     */
    public static MediaResponse addImgMaterial(String accessToken, File file) {
        return addMaterial(accessToken, MaterialType.IMAGE.name().toLowerCase(), file, null);
    }

    /**
     * 新增语音临时素材.
     */
    public static MediaResponse addVoiceMaterial(String accessToken, File file) {
        return addMaterial(accessToken, MaterialType.VOICE.name().toLowerCase(), file, null);
    }

    /**
     * 新增视频临时素材.
     */
    public static MediaResponse addVideoMaterial(String accessToken, File file, Description description) {
        return addMaterial(accessToken, MaterialType.VIDEO.name().toLowerCase(), file, description);
    }

    /**
     * 新增缩略图临时素材.
     */
    public static MediaResponse addThumbMaterial(String accessToken, File file) {
        return addMaterial(accessToken, MaterialType.THUMB.name().toLowerCase(), file, null);
    }

    /**
     * 获取永久图文素材.
     *
     * @param accessToken accessToken
     * @param mediaId     mediaId
     */
    public static NewsItemResponse getMaterialNewsItem(String accessToken, String mediaId) {
        String data = "{\"media_id\":" + mediaId + "}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(GET_MATERIAL, params, data, NewsItemResponse.class);
    }

    /**
     * 获取永久视频素材.
     *
     * @param accessToken accessToken
     * @param mediaId     mediaId
     */
    public static VideoMediaResponse getMaterialVideo(String accessToken, String mediaId) {
        String data = "{\"media_id\":" + mediaId + "}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(GET_MATERIAL, params, data, VideoMediaResponse.class);
    }

    /**
     * 获取其他永久素材(图片语音等).
     *
     * @param accessToken accessToken
     * @param mediaId     mediaId
     */
    public static MediaFile getMaterialOthers(String accessToken, String mediaId) {
        Map<String, String> params = Params.create("access_token", accessToken).put("media_id", mediaId).get();
        return HttpUtil.download(GET_MATERIAL, params);
    }

    /**
     * 删除永久素材.
     *
     * @param accessToken accessToken
     * @param mediaId     mediaId
     */
    public static BaseResponse delMaterial(String accessToken, String mediaId) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        String data = "{\"media_id\":" + mediaId + "}";
        return HttpUtil.postJsonBean(DEL_MATERIAL, params, data, BaseResponse.class);
    }

    /**
     * 获取素材总数.
     *
     * @param accessToken 调用凭证.
     * @return
     */
    public static MaterialCountResponse getMaterialcount(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.getJsonBean(GET_MATERIAL_COUNT, params, MaterialCountResponse.class);
    }

    /**
     * 获取素材列表.
     *
     * @param accessToken accessToken
     * @param type        素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
     * @param offset      从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
     * @param count       返回素材的数量，取值在1到20之间
     */
    public static MaterialBatchGetResponse batchgetMaterial(String accessToken, String type, int offset,
                                                            int count) {
        String data = "{\"type\":\"" + type + "\",\"offset\":" + offset + ",\"count\":" + count + "}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(BATCH_GET_MATERIAL, params, data, MaterialBatchGetResponse.class);
    }

}
