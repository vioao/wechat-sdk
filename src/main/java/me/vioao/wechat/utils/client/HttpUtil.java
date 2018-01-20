package me.vioao.wechat.utils.client;

import me.vioao.wechat.bean.MediaFile;
import me.vioao.wechat.utils.client.httpclient.HttpClientDelegate;
import me.vioao.wechat.utils.serialize.SerializeUtil;

import java.io.File;
import java.util.Map;

/**
 * Http请求工具类.
 *
 * @author vioao
 */
public class HttpUtil {
    // 如果使用了自定义的实现类需要调整该处
    private static final HttpDelegate delegate = new HttpClientDelegate();

    private HttpUtil() {
    }

    public static String get(String url, Map<String, String> params) {
        return delegate.get(url, params);
    }

    public static String post(String url, Map<String, String> params, String postData) {
        return delegate.post(url, params, postData);
    }

    public static String upload(String url, Map<String, String> params, File file) {
        return delegate.upload(url, params, file);
    }

    public static MediaFile download(String url, Map<String, String> params) {
        return delegate.download(url, params);
    }

    public static <T> T getJsonBean(String url, Map<String, String> params, Class<T> clazz) {
        return SerializeUtil.jsonToBean(get(url, params), clazz);
    }

    public static <T> T postJsonBean(String url, Map<String, String> params, String postData, Class<T> clazz) {
        return SerializeUtil.jsonToBean(post(url, params, postData), clazz);
    }

    public static <T> T uploadJsonBean(String url, Map<String, String> params, File file, Class<T> clazz) {
        return SerializeUtil.jsonToBean(upload(url, params, file), clazz);
    }

    public static <T> T getXmlBean(String url, Map<String, String> params, Class<T> clazz) {
        return SerializeUtil.xmlToBean(get(url, params), clazz);
    }

    public static <T> T postXmlBean(String url, Map<String, String> params, String postData, Class<T> clazz) {
        return SerializeUtil.xmlToBean(post(url, params, postData), clazz);
    }
}
