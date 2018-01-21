package com.github.vioao.wechat.bean.xml.in;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author vioao
 */
@XmlRootElement(name = "xml")
public class InMessage {

    ///////////////////////
    // 以下都是微信推送过来的消息的xml的element所对应的属性.
    ///////////////////////
    private String toUserName;
    private String fromUserName;
    private Long createTime;
    private String msgType;
    private String msgId;
    private String event;
    private String eventKey;
    private String content;
    private String picUrl;
    private String mediaId;
    private String format;
    private String thumbMediaId;
    private String locationX;
    private String locationY;
    private String scale;
    private String label;
    private String title;
    private String description;
    private String url;
    private String ticket;
    private String latitude;
    private String longitude;
    private String precision;
    private String recognition;
    private String menuId;

    ///////////////////////////////////////
    // 群发消息返回的结果
    ///////////////////////////////////////

    // 群发的结果
    private String status;

    // group_id下粉丝数；或者openid_list中的粉丝数.
    private Integer totalCount;

    // 过滤（过滤是指特定地区、性别的过滤、用户设置拒收的过滤，用户接收已超4条的过滤）后，准备发送的粉丝数
    // 原则上，filterCount = sentCount + errorCount
    private Integer filterCount;
    // 发送成功的粉丝数
    private Integer sentCount;

    // 发送失败的粉丝数
    private Integer errorCount;

    ///////////////////////////////////////
    // 客服会话管理相关事件推送
    ///////////////////////////////////////

    // 创建或关闭客服会话时的客服帐号
    private String kfAccount;

    // 转接客服会话时的转入客服帐号
    private String toKfAccount;

    // 转接客服会话时的转出客服帐号
    private String fromKfAccount;

    ///////////////////////////////////////
    // 门店审核事件推送
    ///////////////////////////////////////

    // 商户自己内部ID，即字段中的sid
    private String storeUniqId;

    // 微信的门店ID，微信内门店唯一标示ID
    private String poiId;

    // 审核结果，成功succ 或失败fail
    private String result;

    // 成功的通知信息，或审核失败的驳回理由
    private String msg;

    ///////////////////////////////////////
    // 微信认证事件推送
    ///////////////////////////////////////
    /**
     * ExpiredTime
     * 资质认证成功/名称认证成功: 有效期 (整形)，指的是时间戳，将于该时间戳认证过期.
     * 年审通知: 有效期 (整形)，指的是时间戳，将于该时间戳认证过期，需尽快年审.
     * 认证过期失效通知: 有效期 (整形)，指的是时间戳，表示已于该时间戳认证过期，需要重新发起微信认证.
     */
    private Long expiredTime;

    // 失败发生时间 (整形)，时间戳
    private Long failTime;

    // 认证失败的原因
    private String failReason;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getFilterCount() {
        return filterCount;
    }

    public void setFilterCount(Integer filterCount) {
        this.filterCount = filterCount;
    }

    public Integer getSentCount() {
        return sentCount;
    }

    public void setSentCount(Integer sentCount) {
        this.sentCount = sentCount;
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    public String getKfAccount() {
        return kfAccount;
    }

    public void setKfAccount(String kfAccount) {
        this.kfAccount = kfAccount;
    }

    public String getToKfAccount() {
        return toKfAccount;
    }

    public void setToKfAccount(String toKfAccount) {
        this.toKfAccount = toKfAccount;
    }

    public String getFromKfAccount() {
        return fromKfAccount;
    }

    public void setFromKfAccount(String fromKfAccount) {
        this.fromKfAccount = fromKfAccount;
    }

    public String getStoreUniqId() {
        return storeUniqId;
    }

    public void setStoreUniqId(String storeUniqId) {
        this.storeUniqId = storeUniqId;
    }

    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Long expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Long getFailTime() {
        return failTime;
    }

    public void setFailTime(Long failTime) {
        this.failTime = failTime;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }
}
