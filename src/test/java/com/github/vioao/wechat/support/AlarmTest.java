package com.github.vioao.wechat.support;

import com.github.vioao.wechat.support.alarm.AlarmDetail;
import com.github.vioao.wechat.support.alarm.AlarmInfo;
import com.github.vioao.wechat.support.alarm.Station;
import com.github.vioao.wechat.utils.client.HttpUtil;
import com.github.vioao.wechat.utils.serialize.SerializeUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author vioao
 */
public class AlarmTest {
    @Test
    public void testParse() {
        AlarmInfo alarmXml = HttpUtil.getXmlBean("http://www.weather.com.cn/data/alarm_xml/alarminfo.xml", null, AlarmInfo.class);
        System.out.println(alarmXml);
    }

    @Test
    public void testXmlToBean() {
        String alarm = "<AlermInfo>\n" +
                "<RoadIcing/>\n" +
                "<SnowStorm/>\n" +
                "<Hail>\n" +
                "<Station stationId=\"53446\" areaId=\"1010802\" stationName=\"包头市\" lon=\"109.530\" lat=\"40.320\" signalType=\"冰雹\" signalLevel=\"橙色\" issueTime=\"20180715133000\" relieveTime=\"20180716133000\" issueContent=\"包头气象台7月15日13时30分发布冰雹橙色预警信号：预计未来6小时内，市区、石拐、固阳、土右可能出现冰雹天气，请注意做好预防。（预警信息来源：国家预警信息发布中心）\"/>\n" +
                "</Hail>\n" +
                "<Gale>\n" +
                "<Station stationId=\"57476\" areaId=\"1012008\" stationName=\"荆州市\" lon=\"112.090\" lat=\"30.210\" signalType=\"大风\" signalLevel=\"黄色\" issueTime=\"20180715160323\" relieveTime=\"20180716160323\" issueContent=\"荆州市气象台2018年07月15日16时03分发布大风黄色预警信号:预计未来3小时，监利东部部分乡镇有8-10级大风，雨量30-50毫米，伴有雷电，请注意防范。 （预警信息来源：国家预警信息发布中心）\"/>\n" +
                "<Station stationId=\"54342\" areaId=\"10107\" stationName=\"辽宁省\" lon=\"\" lat=\"\" signalType=\"大风\" signalLevel=\"蓝色\" issueTime=\"20180715160134\" relieveTime=\"20180716040134\" issueContent=\"大风蓝色预警信号：预计15日20时到16日8时，渤海海域偏南风6级，阵风7级；大连、锦州、营口、盘锦、葫芦岛附近海域和航线将受影响，请注意防范。辽宁省气象灾害监测预警中心2018年7月15日15时59分发布（预警信息来源：国家预警信息发布中心）\"/>\n" +
                "<Station stationId=\"57494\" areaId=\"10120\" stationName=\"湖北省\" lon=\"\" lat=\"\" signalType=\"大风\" signalLevel=\"黄色\" issueTime=\"20180715155300\" relieveTime=\"20180716155300\" issueContent=\"武汉中心气象台2018年07月15日15时53分发布大风黄色预警信号：预计未来3小时，监利局部有8-10级大风，雨量30-50毫米，伴有雷电，请注意防范。（预警信息来源：国家预警信息发布中心）\"/>\n" +
                "<Station stationId=\"54662\" areaId=\"1010702\" stationName=\"大连市\" lon=\"121.380\" lat=\"38.540\" signalType=\"大风\" signalLevel=\"蓝色\" issueTime=\"20180715151700\" relieveTime=\"20180716151700\" issueContent=\"大连市气象台 于 2018-07-15 15:13:37 时 发布 大风蓝色 预警\n" +
                " 预计15日夜间到16日白天：\n" +
                " 渤海偏南风5到6级半夜后增强到6级阵风7级，请注意防范。（预警信息来源：国家预警信息发布中心）\"/>\n" +
                "</Gale>\n" +
                "</AlermInfo>";
        AlarmInfo alarmInfo = SerializeUtil.xmlToBean(alarm, AlarmInfo.class);
        System.out.println(alarmInfo);
    }

    @Test
    public void testBeanToXml() {
        Station station = new Station();
        station.setAreaId("setAreaId");
        AlarmDetail detail = new AlarmDetail();
        detail.setStation(Arrays.asList(station));
        AlarmInfo alarmInfo = new AlarmInfo();
        alarmInfo.setColdWave(detail);
        String alarmInfoDStr = SerializeUtil.beanToXml(alarmInfo);
        System.out.println(alarmInfoDStr);
    }
}
