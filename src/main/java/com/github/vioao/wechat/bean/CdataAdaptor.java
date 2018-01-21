package com.github.vioao.wechat.bean;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CdataAdaptor extends XmlAdapter<String, String> {
    private static final String CDATA_END = "]]>";
    private static final String CDATA_BEGIN = "<![CDATA[";

    @Override
    public String unmarshal(String v) throws Exception {
        if (v.startsWith(CDATA_BEGIN) && v.endsWith(CDATA_END)) {
            v = v.substring(CDATA_BEGIN.length(), v.length() - CDATA_END.length());
        }
        return v;
    }

    @Override
    public String marshal(String v) throws Exception {
        return CDATA_BEGIN + v + CDATA_END;
    }
}
