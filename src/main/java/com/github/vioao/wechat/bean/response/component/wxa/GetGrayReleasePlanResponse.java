package com.github.vioao.wechat.bean.response.component.wxa;

import com.github.vioao.wechat.bean.response.BaseResponse;

/**
 * 小程序当前分阶段发布详情.
 *
 * @author vioao
 */
public class GetGrayReleasePlanResponse extends BaseResponse {
    private GrayReleasePlan grayReleasePlan;

    public GrayReleasePlan getGrayReleasePlan() {
        return grayReleasePlan;
    }

    public void setGrayReleasePlan(GrayReleasePlan grayReleasePlan) {
        this.grayReleasePlan = grayReleasePlan;
    }

    @Override
    public String toString() {
        return "GetGrayReleasePlanResponse{"
                + "grayReleasePlan=" + grayReleasePlan
                + ", errcode=" + super.getErrcode()
                + ", errmsg='" + super.getErrmsg() + '\''
                + '}';
    }

    public static class GrayReleasePlan {
        private Integer status; // 0:初始状态 1:执行中 2:暂停中 3:执行完毕 4:被删除
        private Long createTimestamp; // 创建时间
        private Integer grayPercentage; // 灰度的百分比，1到100的整数

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Long getCreateTimestamp() {
            return createTimestamp;
        }

        public void setCreateTimestamp(Long createTimestamp) {
            this.createTimestamp = createTimestamp;
        }

        public Integer getGrayPercentage() {
            return grayPercentage;
        }

        public void setGrayPercentage(Integer grayPercentage) {
            this.grayPercentage = grayPercentage;
        }

        @Override
        public String toString() {
            return "GrayReleasePlan{" +
                    "status=" + status +
                    ", createTimestamp=" + createTimestamp +
                    ", grayPercentage=" + grayPercentage +
                    '}';
        }
    }
}
