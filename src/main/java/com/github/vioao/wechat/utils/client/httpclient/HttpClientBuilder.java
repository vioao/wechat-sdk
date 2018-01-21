package com.github.vioao.wechat.utils.client.httpclient;


import com.github.vioao.wechat.utils.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 自定义HttpClient构建工具.
 *
 * @author vioao
 */
public class HttpClientBuilder {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientBuilder.class);
    private static final int DEFAULT_MAX_TOTAL = 10;
    private static final int DEFAULT_MAX_PER_ROUTE = 100;
    private static final int DEFAULT_TIME_OUT = 60000;

    private final int maxTotal; //线程池大小
    private final int timeout; //连接超时时间
    private final int maxPerRoute;
    private final int retryTimes; //重试次数
    private final HttpHost proxy; //http代理

    HttpClientBuilder(int maxTotal, int timeout, int maxPerRoute, int retryTimes, HttpHost proxy) {
        this.maxTotal = maxTotal;
        this.timeout = timeout;
        this.maxPerRoute = maxPerRoute;
        this.retryTimes = retryTimes;
        this.proxy = proxy;
    }

    private SSLConnectionSocketFactory buildSslConnectionSocketFactory() {
        try {
            return new SSLConnectionSocketFactory(createIgnoreVerifySsl()); // 优先绕过安全证书
        } catch (Exception e) {
            LOGGER.error("ssl connection fail", e);
        }
        return SSLConnectionSocketFactory.getSocketFactory();
    }

    private SSLContext createIgnoreVerifySsl() throws NoSuchAlgorithmException, KeyManagementException {
        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {

            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

        };

        /*SSLContext sc = SSLContexts.createSystemDefault();*/
        //SSLContext sc = SSLContext.getInstance("SSLv3");
        SSLContext sc = SSLContexts.custom().build();
        sc.init(null, new TrustManager[]{trustManager}, null);
        return sc;
    }

    private CloseableHttpClient getClient() {
        Registry<ConnectionSocketFactory> reg = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", buildSslConnectionSocketFactory())
                .build();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(reg);
        connectionManager.setDefaultMaxPerRoute(maxPerRoute);
        connectionManager.setMaxTotal(maxTotal);

        org.apache.http.impl.client.HttpClientBuilder httpClientBuilder = HttpClients.custom();
        httpClientBuilder.setConnectionManager(connectionManager);
        SocketConfig.Builder socketConfigBuilder = SocketConfig.custom();
        socketConfigBuilder.setSoKeepAlive(true).setTcpNoDelay(true);
        socketConfigBuilder.setSoTimeout(timeout);
        SocketConfig socketConfig = socketConfigBuilder.build();
        httpClientBuilder.setDefaultSocketConfig(socketConfig);
        connectionManager.setDefaultSocketConfig(socketConfig);

        if (proxy != null) {
            DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
            httpClientBuilder.setRoutePlanner(routePlanner);
        } else {
            String proxyHost = System.getProperty("proxyHost");
            String proxyPort = System.getProperty("proxyPort");
            if (StringUtils.isNotBlank(proxyHost) && StringUtils.isNotBlank(proxyPort)) {
                DefaultProxyRoutePlanner routePlanner =
                        new DefaultProxyRoutePlanner(new HttpHost(proxyHost, Integer.valueOf(proxyPort)));
                httpClientBuilder.setRoutePlanner(routePlanner);
            }
        }

        if (retryTimes > 0) {
            httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(retryTimes, true));
        }
        return httpClientBuilder.build();
    }


    public static HttpClientBuilder.Builder custom() {
        return new HttpClientBuilder.Builder();
    }

    public static class Builder {
        private int maxTotal;
        private int timeout;
        private int maxPerRoute;
        private int retryTimes;
        private HttpHost proxy;

        Builder() {
            this.maxTotal = DEFAULT_MAX_TOTAL;
            this.timeout = DEFAULT_TIME_OUT;
            this.maxPerRoute = DEFAULT_MAX_PER_ROUTE;
            this.retryTimes = 0;
        }

        public HttpClientBuilder.Builder timeout(final int timeout) {
            this.timeout = timeout;
            return this;
        }

        public HttpClientBuilder.Builder maxTotal(final int maxTotal) {
            this.maxTotal = maxTotal;
            return this;
        }

        public HttpClientBuilder.Builder maxPerRoute(final int maxPerRoute) {
            this.maxPerRoute = maxPerRoute;
            return this;
        }

        public HttpClientBuilder.Builder retryTimes(final int retryTimes) {
            this.retryTimes = retryTimes;
            return this;
        }

        public HttpClientBuilder.Builder proxy(final HttpHost proxy) {
            this.proxy = proxy;
            return this;
        }

        public CloseableHttpClient build() {
            return (new HttpClientBuilder(maxTotal, timeout, maxPerRoute, retryTimes, proxy)).getClient();
        }
    }
}
