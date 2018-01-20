package me.vioao.wechat.utils;

import me.vioao.wechat.Const;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author vioao
 */
public class UrlUtils {
    public static String encode(String str) {
        try {
            str = URLEncoder.encode(str, Const.Charset.UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return str;
    }
}
