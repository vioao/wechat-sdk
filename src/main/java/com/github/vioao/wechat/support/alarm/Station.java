package com.github.vioao.wechat.support.alarm;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

/**
 * 预警信息详细.
 *
 * @author vioao
 */
@Data
public class Station {
    @JacksonXmlProperty(isAttribute = true, localName = "stationId")
    private String stationId;
    @JacksonXmlProperty(isAttribute = true, localName = "areaId")
    private String areaId;
    @JacksonXmlProperty(isAttribute = true, localName = "stationName")
    private String stationName;
    @JacksonXmlProperty(isAttribute = true, localName = "lon")
    private String lon;
    @JacksonXmlProperty(isAttribute = true, localName = "lat")
    private String lat;
    @JacksonXmlProperty(isAttribute = true, localName = "signalType")
    private String signalType;
    @JacksonXmlProperty(isAttribute = true, localName = "signalLevel")
    private String signalLevel;
    @JacksonXmlProperty(isAttribute = true, localName = "issueTime")
    private String issueTime;
    @JacksonXmlProperty(isAttribute = true, localName = "relieveTime")
    private String relieveTime;
    @JacksonXmlProperty(isAttribute = true, localName = "issueContent")
    private String issueContent;

}
