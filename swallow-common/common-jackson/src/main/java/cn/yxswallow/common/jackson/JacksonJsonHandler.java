package cn.yxswallow.common.jackson;

import cn.yxswallow.protocols.exception.SysException;
import cn.yxswallow.protocols.utils.JsonHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJsonHandler implements JsonHandler {
    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String toJsonString(Object obj){
        if(obj == null){
            return null;
        }
        try {
            return obj instanceof String str? str :  objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new SysException(e);
        }
    }
}
