package com.github.vioao.wechat.utils.client;

import com.github.vioao.wechat.bean.MediaFile;

import java.io.File;
import java.util.Map;

/**
 * 代理请求实现接口.不同客户端实现需实现该接口.
 *
 * @author vioao
 */
public interface HttpDelegate {

    /**
     * 发送GET请求。
     */
    String get(String url, Map<String, String> params);

    /**
     * 发送POST请求。
     */
    String post(String url, Map<String, String> params, String postData);

    /**
     * 上传文件.
     */
    String upload(String url, Map<String, String> params, File file);

    /**
     * 下载文件.
     */
    MediaFile download(String url, Map<String, String> params);
}
