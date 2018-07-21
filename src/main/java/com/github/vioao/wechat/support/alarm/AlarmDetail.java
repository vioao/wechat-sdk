package com.github.vioao.wechat.support.alarm;

import lombok.Data;

import java.util.List;

/**
 * 预警信息列表.
 *
 * @author vioao
 */
@Data
public class AlarmDetail {
    List<Station> station;
}
