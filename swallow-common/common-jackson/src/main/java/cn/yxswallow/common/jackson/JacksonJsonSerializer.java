package cn.yxswallow.common.jackson;

import cn.yxswallow.protocols.annotation.Nullable;
import cn.yxswallow.protocols.exception.SerializationException;
import cn.yxswallow.protocols.utils.Assert;
import cn.yxswallow.protocols.utils.JsonSerializer;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import static cn.yxswallow.protocols.constants.Default.EMPTY_ARRAY;

public class JacksonJsonSerializer implements JsonSerializer {
    private final JavaType javaType;
    private ObjectMapper objectMapper = new ObjectMapper();

    public JacksonJsonSerializer() {
        this.javaType = this.getJavaType(Object.class);
    }

    public JacksonJsonSerializer(Class<Object> type) {
        this.javaType = this.getJavaType(type);
    }

    public JacksonJsonSerializer(JavaType javaType) {
        this.javaType = javaType;
    }

    public Object deserialize(@Nullable byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) {
            return null;
        } else {
            try {
                return this.objectMapper.readValue(bytes, 0, bytes.length, this.javaType);
            } catch (Exception var3) {
                throw new SerializationException("Could not read JSON: " + var3.getMessage());
            }
        }
    }

    public byte[] serialize(@Nullable Object t) throws SerializationException {
        if (t == null) {
            return EMPTY_ARRAY;
        } else {
            try {
                return this.objectMapper.writeValueAsBytes(t);
            } catch (Exception var3) {
                throw new SerializationException("Could not write JSON: " + var3.getMessage());
            }
        }
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        Assert.notNull(objectMapper, "'objectMapper' must not be null");
        this.objectMapper = objectMapper;
    }

    protected JavaType getJavaType(Class<?> clazz) {
        return TypeFactory.defaultInstance().constructType(clazz);
    }

}
