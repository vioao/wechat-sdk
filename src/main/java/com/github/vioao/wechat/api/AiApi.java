package com.github.vioao.wechat.api;

import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.bean.response.BaseResponse;
import com.github.vioao.wechat.bean.response.ai.TranslateResponse;
import com.github.vioao.wechat.bean.response.ai.VoiceToTextResponse;
import com.github.vioao.wechat.utils.Params;
import com.github.vioao.wechat.utils.client.HttpUtil;

import java.io.File;
import java.util.Map;

/**
 * AI开放接口.
 *
 * @author vioao
 */
public class AiApi {
    private static final String ADD_VOICE_TO_RECO = Const.Uri.API_URI + "/cgi-bin/media/voice/addvoicetorecofortext";

    /**
     * 提交语音.
     *
     * @param accessToken 调用凭证
     * @param voiceId     语音唯一标识
     * @param lang        语言，zh_CN 或 en_US，默认中文
     * @param file        文件格式 （只支持mp3，16k，单声道，最大1M）
     * @return {@link BaseResponse}
     */
    private static BaseResponse addVoice(String accessToken, String voiceId, String lang, File file) {
        Map<String, String> params = Params.create("access_token", accessToken).put("format", "mp3")
                .put("voice_id", voiceId).put("lang", lang).get();
        return HttpUtil.uploadJsonBean(ADD_VOICE_TO_RECO, params, file, BaseResponse.class);
    }

    private static final String QUERY_RECO_RESULT = Const.Uri.API_URI + "/cgi-bin/media/voice/queryrecoresultfortext";

    /**
     * 获取语音识别结果. <br>
     * 请注意，添加完文件之后10s内调用这个接口.
     *
     * @param accessToken 调用凭证
     * @param voiceId     语音唯一标识
     * @param lang        语言，zh_CN 或 en_US，默认中文
     * @return {@link VoiceToTextResponse}
     */
    private static VoiceToTextResponse queryResult(String accessToken, String voiceId, String lang) {
        Map<String, String> params = Params.create("access_token", accessToken).put("voice_id", voiceId)
                .put("lang", lang).get();
        return HttpUtil.postJsonBean(QUERY_RECO_RESULT, params, null, VoiceToTextResponse.class);
    }

    private static final String TRANSLATE_CONTENT = Const.Uri.API_URI + "/cgi-bin/media/voice/translatecontent";

    /**
     * 微信翻译.
     *
     * @param accessToken 调用凭证
     * @param lFrom       源语言，zh_CN 或 en_US
     * @param lTo         目标语言，zh_CN 或 en_US
     * @param file        最大600Byte
     * @return {@link BaseResponse}
     */
    private static TranslateResponse translateContent(String accessToken, String lFrom, String lTo, File file) {
        Map<String, String> params = Params.create("access_token", accessToken)
                .put("lfrom", lFrom).put("lto", lTo).get();
        return HttpUtil.uploadJsonBean(TRANSLATE_CONTENT, params, file, TranslateResponse.class);
    }
}
