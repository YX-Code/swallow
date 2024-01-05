package cn.yxswallow.spring.data.redis;

import cn.yxswallow.component.json.JsonUtil;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 *
 */
public class JsonRedisSerializer<T> implements RedisSerializer<T> {

    @Override
    public byte[] serialize(T t) throws SerializationException {
        return JsonUtil.serialize(t);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        return JsonUtil.deserialize(bytes);
    }
}
