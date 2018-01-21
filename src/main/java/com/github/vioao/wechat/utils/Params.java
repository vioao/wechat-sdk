package com.github.vioao.wechat.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * key,value请求参数构建工具类.
 *
 * @author vioao
 */
public class Params {
    private Map<String, String> data = new HashMap<String, String>();

    private Params() {
    }

    public static Params create(String key, String value) {
        return (new Params()).put(key, value);
    }

    public Params put(String key, String value) {
        data.put(key, value);
        return this;
    }

    public Map<String, String> get() {
        return data;
    }
}
