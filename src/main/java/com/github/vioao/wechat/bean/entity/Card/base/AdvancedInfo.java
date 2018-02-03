package com.github.vioao.wechat.bean.entity.card.base;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 卡券公共信息-高级信息.
 *
 * @author vioao
 */
@Data
@Builder
public class AdvancedInfo {
    /**
     * 使用门槛（条件）字段，<br>
     * 若不填写使用条件则在券面拼写：无最低消费限制，全场通用，不限品类；<br>
     * 并在使用说明显示：可与其他优惠共享
     */
    private UseCondition useCondition;

    /**
     * 封面摘要 <br>
     * 添加必填
     */
    private Abstract _abstract;

    /**
     * 图文列表，显示在详情内页，优惠券券开发者须至少传入一组图文列表 <br>
     * 添加必填
     */
    private List<TextImage> textImageList;

    /**
     * 使用时段限制<br>
     * 添加必填
     */
    private List<TimeLimit> timeLimit;

    /**
     * 商家服务类型：<br>
     * BIZ_SERVICE_DELIVER 外卖服务；<br>
     * BIZ_SERVICE_FREE_PARK 停车位；<br>
     * BIZ_SERVICE_WITH_PET 可带宠物；<br>
     * BIZ_SERVICE_FREE_WIFI 免费wifi，可多选
     */
    private List<String> businessService;

    @Data
    @Builder
    public static class UseCondition {
        /**
         * 指定可用的商品类目，仅用于代金券类型，填入后将在券面拼写适用于xxx
         */
        private String acceptCategory;

        /**
         * 指定可用的商品类目，仅用于代金券类型，填入后将在券面拼写不适用于xxxx
         */
        private String rejectCategory;

        /**
         * 满减门槛字段，可用于兑换券和代金券，填入后将在全面拼写消费满xx元可用。
         */
        private Integer leastCost;

        /**
         * 购买xx可用类型门槛，仅用于兑换，填入后自动拼写购买xxx可用。<br>
         * 长度：512
         */
        private String objectUseFor;

        /**
         * 不可以与其他类型共享门槛，填写false时系统将在使用须知里拼写“不可与其他优惠共享”，<br>
         * 填写true时系统将在使用须知里拼写“可与其他优惠共享”，默认为true
         */
        private Boolean canUseWithOtherDiscount;
    }

    @Data
    @Builder
    public static class Abstract {
        /**
         * 指定可用的商品类目，仅用于代金券类型，填入后将在券面拼写适用于xxx
         */
        private String acceptCategory;

        /**
         * 指定可用的商品类目，仅用于代金券类型，填入后将在券面拼写不适用于xxxx
         */
        private String rejectCategory;

        /**
         * 满减门槛字段，可用于兑换券和代金券，填入后将在全面拼写消费满xx元可用。
         */
        private Integer leastCost;

        /**
         * 购买xx可用类型门槛，仅用于兑换，填入后自动拼写购买xxx可用。<br>
         * 长度：512
         */
        private String objectUseFor;

        /**
         * 不可以与其他类型共享门槛，填写false时系统将在使用须知里拼写“不可与其他优惠共享”，<br>
         * 填写true时系统将在使用须知里拼写“可与其他优惠共享”，默认为true
         */
        private Boolean canUseWithOtherDiscount;
    }

    @Data
    @Builder
    public static class TextImage {
        /**
         * 图片链接，必须调用上传图片接口上传图片获得链接，并在此填入，否则报错 <br>
         * 添加必填，长度：128
         */
        private String imageUrl;

        /**
         * 图文描述 <br>
         * 添加必填，长度：512
         */
        private String text;
    }

    @Data
    @Builder
    public static class TimeLimit {
        /**
         * 限制类型枚举值：支持填入 <br>
         * MONDAY 周一 <br>
         * TUESDAY 周二 <br>
         * WEDNESDAY 周三 <br>
         * THURSDAY 周四 <br>
         * FRIDAY 周五 <br>
         * SATURDAY 周六 <br>
         * SUNDAY 周日 <br>
         * 此处只控制显示， 不控制实际使用逻辑，不填默认不显示
         */
        private String type;

        /***
         * 当前type类型下的起始时间（小时），<br>
         * 如当前结构体内填写了MONDAY，此处填写了10，则此处表示周一 10:00可用
         */
        private Integer beginHour;

        /**
         * 当前type类型下的结束时间（小时），<br>
         * 如当前结构体内填写了MONDAY，此处填写了20，则此处表示周一 10:00-20:00可用
         */
        private Integer endHour;

        /**
         * 当前type类型下的起始时间（分钟），<br>
         * 如当前结构体内填写了MONDAY，begin_hour填写10，此处填写了59，则此处表示周一 10:59可用
         */
        private Integer beginMinute;

        /**
         * 当前type类型下的结束时间（分钟），<br>
         * 如当前结构体内填写了MONDAY，begin_hour填写10，此处填写了59，则此处表示周一 10:59-00:59可用
         */
        private Integer endMinute;
    }
}
