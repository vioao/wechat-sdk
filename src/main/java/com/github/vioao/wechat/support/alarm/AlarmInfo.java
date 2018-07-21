package com.github.vioao.wechat.support.alarm;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 预警信息 from
 * http://www.weather.com.cn/data/alarm_xml/alarminfo.xml
 *
 * @author vioao
 */
@Data
@XmlRootElement(name = "AlermInfo")
public class AlarmInfo {
    private AlarmDetail roadIcing;
    private AlarmDetail snowStorm;
    private AlarmDetail rainStorm;
    private AlarmDetail hail;
    private AlarmDetail gale;
    private AlarmDetail heavyFog;
    private AlarmDetail heatWave;
    private AlarmDetail drought;
    private AlarmDetail coldWave;
    private AlarmDetail sWHazards;
    private AlarmDetail lightning;
    private AlarmDetail haze;
    private AlarmDetail sandStorm;
    private AlarmDetail frost;
    private AlarmDetail typhoon;
    private AlarmDetail other;
}
