package cn.yxswallow.protocols.utils;

import cn.yxswallow.protocols.exception.SerializationException;

public interface JsonSerializer {
    
    byte[] serialize(Object value) throws SerializationException;

    Object deserialize(byte[] bytes) throws SerializationException;
}
