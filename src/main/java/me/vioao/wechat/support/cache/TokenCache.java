package me.vioao.wechat.support.cache;

/**
 * 接口调用凭证缓存接口.
 *
 * @author vioao
 */
public interface TokenCache {
    /**
     * 获取缓存的access_token.
     *
     * @param appId 公众号唯一标识
     */
    void get(String appId);

    /**
     * 缓存access_token.
     *
     * @param appId 公众号唯一标识
     * @param token 要换存的凭证
     */
    void set(String appId, String token);
}
