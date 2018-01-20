package me.vioao.wechat.utils.client.httpclient;

import me.vioao.wechat.Const;
import me.vioao.wechat.bean.MediaFile;
import me.vioao.wechat.utils.client.HttpDelegate;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Map;


/**
 * @author vioao
 */
public class HttpClientDelegate implements HttpDelegate {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientDelegate.class);
    private static final CloseableHttpClient httpClient = HttpClientBuilder.custom().build();
    private static final StringResponseHandler stringHandler = new StringResponseHandler();
    private static final MediaFileResponseHandler fileHandler = new MediaFileResponseHandler();

    @Override
    public String get(String url, Map<String, String> params) {
        String response = null;
        try {
            response = httpClient.execute(buildGetRequest(url, params), stringHandler);
        } catch (Exception e) {
            LOGGER.error("Get error.url: " + url + ", params: " + params, e);
        }
        return response;
    }

    @Override
    public String post(String url, Map<String, String> params, String postData) {
        String response = null;
        try {
            response = httpClient.execute(buildPostRequest(url, params, postData), stringHandler);
        } catch (Exception e) {
            LOGGER.error("Post error.url: " + url + ", params: " + params + ", postData: " + postData, e);
        }
        return response;
    }

    @Override
    public String upload(String url, Map<String, String> params, File file) {
        String response = null;
        try {
            response = httpClient.execute(buildUploadRequest(url, params, file), stringHandler);
        } catch (Exception e) {
            LOGGER.error("Upload error.url: " + url + ", params: " + params, e);
        }
        return response;
    }

    @Override
    public MediaFile download(String url, Map<String, String> params) {
        MediaFile response = null;
        try {
            response = httpClient.execute(buildGetRequest(url, params), fileHandler);
        } catch (Exception e) {
            LOGGER.error("Download error.url: " + url + ", params: " + params, e);
        }
        return response;
    }

    /**
     * 构造GET请求.
     */
    private static HttpUriRequest buildGetRequest(String url, Map<String, String> params) {
        return buildRequest(HttpGet.METHOD_NAME, url, params, null, null);
    }

    /**
     * 构造POST请求.
     */
    private static HttpUriRequest buildPostRequest(String url, Map<String, String> params, String data) {
        return buildRequest(HttpPost.METHOD_NAME, url, params, data, null);
    }

    /**
     * 构造文件上传请求.
     */
    private static HttpUriRequest buildUploadRequest(String url, Map<String, String> params, File file) {
        return buildRequest(HttpPost.METHOD_NAME, url, params, null, file);
    }

    /**
     * 构造HttpUriRequest请求.
     *
     * @param method 请求方法
     * @param url    请求地址
     * @param params 请求(key,value)数据
     * @param data   请求体文本数据
     * @param file   请求体二进制文件
     */
    private static HttpUriRequest buildRequest(String method, String url, Map<String, String> params,
                                               String data, File file) {
        RequestBuilder builder = RequestBuilder.create(method).setUri(url);
        if (params != null) {
            for (String key : params.keySet()) {
                builder.addParameter(new BasicNameValuePair(key, params.get(key)));
            }
        }
        if (data != null) {
            builder.setEntity(new StringEntity(data, Const.Charset.UTF_8));
        }
        if (file != null) {
            MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create().addBinaryBody("media", file);
            builder.setEntity(entityBuilder.build());
        }
        return builder.build();
    }

    private static class StringResponseHandler implements ResponseHandler<String> {
        @Override
        public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                String str = EntityUtils.toString(entity);
                LOGGER.debug("Get response: " + str);
                return str;
            } else {
                throw new ClientProtocolException("Unexpected response status:" + status);
            }
        }
    }

    private static class MediaFileResponseHandler implements ResponseHandler<MediaFile> {
        @Override
        public MediaFile handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
            MediaFile mediaFile = new MediaFile();
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                String contentType = response.getEntity().getContentType().getValue();
                if (contentType.equalsIgnoreCase("text/plain")) {
                    // 定义BufferedReader输入流来读取URL的响应
                    HttpEntity entity = response.getEntity();
                    String str = EntityUtils.toString(entity, Const.Charset.UTF_8);
                    mediaFile.setError(str);
                } else {
                    Header dispositionHeader = response.getFirstHeader("Content-disposition");
                    if (dispositionHeader != null) {
                        String ds = response.getFirstHeader("Content-disposition").getValue();
                        String fullName = ds.substring(ds.indexOf("filename=\"") + 10, ds.length() - 1);
                        String relName = fullName.substring(0, fullName.lastIndexOf("."));
                        String suffix = fullName.substring(relName.length() + 1);
                        mediaFile.setFullName(fullName);
                        mediaFile.setFileName(relName);
                        mediaFile.setSuffix(suffix);
                    }
                    mediaFile.setContentLength(response.getEntity().getContentLength());
                    mediaFile.setContentType(contentType);
                    BufferedInputStream bis = new BufferedInputStream(response.getEntity().getContent());
                    mediaFile.setFileStream(bis);
                }
            }
            return mediaFile;
        }
    }
}
