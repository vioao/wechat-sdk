package com.github.vioao.wechat.utils.serialize;

/**
 * 微信交互数据序列化代理实现接口.不同的序列化需要实现该接口.
 *
 * @author vioao
 */
public interface SerializeDelegate {
    /**
     * JSON字符串转Bean.
     */
    <T> T jsonToBean(String json, Class<T> clazz);

    /**
     * Bean转JSON字符串.
     */
    String beanToJson(Object object);

    /**
     * 将xml转换为对象.
     */
    <T> T xmlToBean(String xml, Class<T> c);

    /**
     * 将对象转换为xml.
     */
    String beanToXml(Object obj);
}
