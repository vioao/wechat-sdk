package com.github.vioao.wechat.utils.serialize.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.vioao.wechat.Const;
import com.github.vioao.wechat.utils.serialize.SerializeDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Jackson 实现的json和xml序列化.
 *
 * @author vioao
 */
public class JacksonSerialize implements SerializeDelegate {
    private static final Logger LOGGER = LoggerFactory.getLogger(JacksonSerialize.class);
    private static final ObjectMapper OBJECT_MAPPER;
    private static final XmlMapper XML_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        XML_MAPPER  = new XmlMapper(module);
        XML_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        XML_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        XML_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        XML_MAPPER.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
    }

    @Override
    public <T> T jsonToBean(String json, Class<T> clazz) {
        T result = null;
        try {
            result = OBJECT_MAPPER.readValue(new ByteArrayInputStream(json.getBytes(Const.Charset.UTF_8)), clazz);
        } catch (IOException e) {
            LOGGER.error("Convert json to bean " + clazz.getName() + " error.", e);
        }
        return result;
    }

    @Override
    public String beanToJson(Object object) {
        String result = null;
        try {
            result = OBJECT_MAPPER.writeValueAsString(object);
        } catch (Exception e) {
            LOGGER.error("Convert bean" + object.getClass().getName() + " to json error.", e);
        }
        return result;
    }

    @Override
    public <T> T xmlToBean(String xml, Class<T> c) {
        T t = null;
        try {
            t = XML_MAPPER.readValue(new ByteArrayInputStream(xml.getBytes(Const.Charset.UTF_8)), c);
        } catch (IOException e) {
            LOGGER.error("Convert xml to bean " + c.getName() + " error.", e);
        }
        return t;
    }

    @Override
    public String beanToXml(Object obj) {
        String result = null;
        try {
            result = XML_MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            LOGGER.error("Convert bean" + obj.getClass().getName() + " to xml error.", e);
        }

        return result;
    }
}
