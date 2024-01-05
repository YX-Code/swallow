package cn.yxswallow.common.fastjson2;

import cn.yxswallow.protocols.exception.SerializationException;
import cn.yxswallow.protocols.utils.JsonSerializer;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;

import static cn.yxswallow.protocols.constants.Default.DEFAULT_CHARSET;

public class FastJsonSerializer implements JsonSerializer {
    private Class<Object> clazz;

    public FastJsonSerializer() {
        super();
    }

    public FastJsonSerializer(Class<Object> clazz) {
        super();
        this.clazz = clazz;
    }

    public Class<Object> getClazz() {
        return clazz;
    }

    public void setClazz(Class<Object> clazz) {
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(Object t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        return JSON.toJSONString(t, JSONWriter.Feature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);
        return JSON.parseObject(str, clazz);
    }
}
