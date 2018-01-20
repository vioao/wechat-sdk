package me.vioao.wechat.api;

import me.vioao.wechat.Const;
import me.vioao.wechat.bean.entity.message.massmsg.MassMessage;
import me.vioao.wechat.bean.entity.message.msg.Message;
import me.vioao.wechat.bean.response.BaseResponse;
import me.vioao.wechat.bean.response.message.MessageSendResponse;
import me.vioao.wechat.bean.response.message.MessageSendSpeedResponse;
import me.vioao.wechat.bean.response.message.MessageSendStatusResponse;
import me.vioao.wechat.utils.Params;
import me.vioao.wechat.utils.client.HttpUtil;
import me.vioao.wechat.utils.serialize.SerializeUtil;

import java.util.Map;

/**
 * 群发接口和原创校验.
 *
 * @author vioao
 */
public class MassMsgApi {
    private static final String MSG_MASS_SEND_ALL = Const.Uri.API_URI + "/cgi-bin/message/mass/sendall";

    /**
     * 根据标签进行群发(订阅号与服务号认证后均可用).
     */
    public static MessageSendResponse sendMassMessageToAll(String accessToken, String messageJson) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(MSG_MASS_SEND_ALL, params, messageJson, MessageSendResponse.class);
    }

    /**
     * 根据标签进行群发(订阅号与服务号认证后均可用).
     */
    public static MessageSendResponse sendMassMessageToAll(String accessToken, MassMessage massMessage) {
        String str = SerializeUtil.beanToJson(massMessage);
        return sendMassMessageToAll(accessToken, str);
    }

    private static final String MSG_MASS_SEND = Const.Uri.API_URI + "/cgi-bin/message/mass/send";

    /**
     * 根据OpenID列表群发(订阅号不可用，服务号认证后可用).
     */
    public static MessageSendResponse sendMassMessageByOpenIds(String accessToken, String messageJson) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(MSG_MASS_SEND, params, messageJson, MessageSendResponse.class);
    }

    /**
     * 根据OpenID列表群发(订阅号不可用，服务号认证后可用).
     */
    public static MessageSendResponse sendMassMessage(String accessToken, MassMessage massMessage) {
        String data = SerializeUtil.beanToJson(massMessage);
        return sendMassMessageByOpenIds(accessToken, data);
    }

    private static final String MSG_MASS_DELETE = Const.Uri.API_URI + "/cgi-bin/message/mass/delete";

    /**
     * 删除群发(订阅号与服务号认证后均可用).
     * 注意:
     * 1、只有已经发送成功的消息才能删除
     * 2、删除消息是将消息的图文详情页失效，已经收到的用户，还是能在其本地看到消息卡片。
     * 3、删除群发消息只能删除图文消息和视频消息，其他类型的消息一经发送，无法删除。
     * 4、如果多次群发发送的是一个图文消息，那么删除其中一次群发，就会删除掉这个图文消息也，导致所有群发都失效
     *
     * @param msgId      发送出去的消息ID
     * @param articleIdx 要删除的文章在图文消息中的位置，第一篇编号为1，该字段不填或填0会删除全部文章
     */
    public static BaseResponse deleteMassMessage(String accessToken, String msgId, String articleIdx) {
        String messageJson = "{\"msgid\":\"" + msgId + "\", \"article_idx\":\"" + articleIdx + "\"}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(MSG_MASS_DELETE, params, messageJson, BaseResponse.class);
    }

    private static final String MSG_MASS_PREVIEW = Const.Uri.API_URI + "/cgi-bin/message/mass/preview";

    /**
     * 预览接口(订阅号与服务号认证后均可用).
     */
    public static BaseResponse previewMassMessage(String accessToken, Message message) {
        String data = SerializeUtil.beanToJson(message);
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(MSG_MASS_PREVIEW, params, data, BaseResponse.class);
    }

    private static final String MSG_MASS_GET = Const.Uri.API_URI + "/cgi-bin/message/mass/get";

    /**
     * 查询群发消息发送状态(订阅号与服务号认证后均可用).
     */
    public static MessageSendStatusResponse getMassMessage(String accessToken, String msgId) {
        String data = "{\"msgid\":\"" + msgId + "\"}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(MSG_MASS_GET, params, data, MessageSendStatusResponse.class);
    }

    private static final String MSG_MASS_SPEED_GET = Const.Uri.API_URI + "/cgi-bin/message/mass/speed/get";

    /**
     * 获取群发速度.
     *
     * @param accessToken access_token2
     */
    public static MessageSendSpeedResponse getMassSpeed(String accessToken) {
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.getJsonBean(MSG_MASS_SPEED_GET, params, MessageSendSpeedResponse.class);
    }

    private static final String MSG_MASS_SPEED_SET = Const.Uri.API_URI + "/cgi-bin/message/mass/speed/set";

    /**
     * 设置群发速度.
     *
     * @param accessToken 调用凭证
     * @param speed       群发速度的级别，是一个0到4的整数，数字越大表示群发速度越慢。
     *                    0(80w/分钟),1(60w/分钟),2(45w/分钟),3(30w/分钟),4(10w/分钟)
     */
    public static BaseResponse setMassSpeed(String accessToken, Integer speed) {
        String data = "{\"speed\":" + speed + "}";
        Map<String, String> params = Params.create("access_token", accessToken).get();
        return HttpUtil.postJsonBean(MSG_MASS_SPEED_SET, params, data, BaseResponse.class);
    }
}
