package me.vioao.wechat.api.material;

import me.vioao.wechat.Const;
import me.vioao.wechat.bean.MediaFile;
import me.vioao.wechat.bean.entity.material.MaterialType;
import me.vioao.wechat.bean.response.media.VideoUrlResponse;
import me.vioao.wechat.bean.response.media.MediaResponse;
import me.vioao.wechat.utils.Params;
import me.vioao.wechat.utils.client.HttpUtil;

import java.io.File;
import java.util.Map;

/**
 * 临时素材:
 * 1、临时素材media_id是可复用的。
 * 2、媒体文件在微信后台保存时间为3天，即3天后media_id失效。
 * 3、上传临时素材的格式、大小限制与公众平台官网一致。
 * 4、需使用https调用本接口。
 *
 * @author vioao
 */
public class TemporaryMediaApi {
    private static final String UPLOAD = Const.Uri.API_URI + "/cgi-bin/media/upload";
    private static final String GET = Const.Uri.API_URI + "/cgi-bin/media/get";
    private static final String JS_SDK_GET = Const.Uri.API_URI + "/cgi-bin/media/get/jssdk";

    /**
     * 上传图片临时素材.
     * 图片（image）: 2M，支持PNG\JPEG\JPG\GIF格式.
     */
    public static MediaResponse uploadImg(String accessToken, File file) {
        return upload(accessToken, MaterialType.IMAGE.name().toLowerCase(), file);
    }

    /**
     * 上传语音临时素材.
     * 语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
     */
    public static MediaResponse uploadVoice(String accessToken, File file) {
        return upload(accessToken, MaterialType.VOICE.name().toLowerCase(), file);
    }

    /**
     * 上传视频临时素材.
     * 视频（video）：10MB，支持MP4格式
     */
    public static MediaResponse uploadVideo(String accessToken, File file) {
        return upload(accessToken, MaterialType.VIDEO.name().toLowerCase(), file);
    }

    /**
     * 上传缩略图临时素材.
     * 缩略图（thumb）：64KB，支持JPG格式
     */
    public static MediaResponse uploadThumb(String accessToken, File file) {
        return upload(accessToken, MaterialType.THUMB.name().toLowerCase(), file);
    }

    /**
     * 新增临时素材.
     *
     * @param accessToken 调用凭证
     * @param type        素材类型，图片（image），语音（voice），视频（video），缩略图（thumb）
     * @param file        文件
     */
    private static MediaResponse upload(String accessToken, String type, File file) {
        Map<String, String> params = Params.create("access_token", accessToken).put("type", type).get();
        return HttpUtil.uploadJsonBean(UPLOAD, params, file, MediaResponse.class);
    }

    /**
     * 公众号可以使用本接口获取临时素材（即下载临时的多媒体文件.
     * 请注意，视频文件不支持https下载，调用该接口需http协议.
     *
     * @param accessToken 调用凭证
     * @param mediaId     素材媒体id
     */
    public static MediaFile download(String accessToken, String mediaId) {
        Map<String, String> params = Params.create("access_token", accessToken).put("media_id", mediaId).get();
        return HttpUtil.download(GET, params);
    }

    /**
     * 高清语音素材获取接口.
     * 公众号可以使用本接口获取从JSSDK的uploadVoice接口上传的临时语音素材，格式为speex，16K采样率。
     * 该音频比上文的临时素材获取接口（格式为amr，8K采样率）更加清晰，适合用作语音识别等对音质要求较高的业务。
     */
    public static MediaFile downloadHq(String accessToken, String mediaId) {
        Map<String, String> params = Params.create("access_token", accessToken).put("media_id", mediaId).get();
        return HttpUtil.download(JS_SDK_GET, params);
    }

    /**
     * 获取视频临时素材下载地址.
     */
    public static VideoUrlResponse downloadVideo(String accessToken, String mediaId) {
        Map<String, String> params = Params.create("access_token", accessToken).put("media_id", mediaId).get();
        return HttpUtil.getJsonBean(GET, params, VideoUrlResponse.class);
    }
}
