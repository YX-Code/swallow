package cn.yxswallow.component.json;

import cn.yxswallow.protocols.utils.JsonHandler;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonUtil {
    private static final JsonHandler jsonHandler;
    static {
        jsonHandler = JsonHandlerFactory.getJsonHandler();
    }
    public static String toJsonString(Object obj){
        return jsonHandler.toJsonString(obj);
    }
}
