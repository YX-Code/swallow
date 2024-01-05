package cn.yxswallow.component.json;

import cn.yxswallow.protocols.utils.JsonHandler;
import cn.yxswallow.protocols.utils.JsonSerializer;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonUtil {
    private static final JsonHandler jsonHandler;
    private static final JsonSerializer jsonSerializer;
    static {
        jsonHandler = JsonHandlerFactory.getJsonHandler();
        jsonSerializer = JsonSerializerFactory.getJsonSerializer();
    }
    public static String toJsonString(Object obj){
        return jsonHandler.toJsonString(obj);
    }
    public static<T> byte[] serialize(T obj){
        return jsonSerializer.serialize(obj);
    }
    public static<T> T deserialize(byte[] bytes){
        return (T)jsonSerializer.deserialize(bytes);
    }
}
