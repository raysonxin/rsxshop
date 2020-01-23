package com.rsxshop.rsx.sod.base.common.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * @className: RedisObjectSerializer.java
 * @author: raysonxin
 * @date: 2020/1/20 4:14 下午
 * @email: raysonxin@163.com
 * @description: 使用fastjson对value进行序列化和反序列化
 **/
public class FastJsonRedisSerializer implements RedisSerializer<Object> {

    static final byte[] EMPTY_ARRAY = new byte[0];
    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    static {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(Boolean.TRUE);
    }

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        if (o == null) {
            return EMPTY_ARRAY;
        }

        try {
            return JSON.toJSONString(o, new SerializerFeature[]{SerializerFeature.WriteClassName}).getBytes(DEFAULT_CHARSET);
        } catch (Exception ex) {
            return EMPTY_ARRAY;
        }
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {

        if (bytes == null || bytes.length == 0) {
            return null;
        }

        try {
            String json = new String(bytes, DEFAULT_CHARSET);
            return JSON.parse(json);
        } catch (Exception ex) {
            throw new SerializationException("Cannot deserialize", ex);
        }
    }
}
