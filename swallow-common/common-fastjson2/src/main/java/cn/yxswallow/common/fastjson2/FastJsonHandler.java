package cn.yxswallow.common.fastjson2;

import cn.yxswallow.protocols.utils.JsonHandler;
import com.alibaba.fastjson2.JSON;

public class FastJsonHandler implements JsonHandler {
    @Override
    public String toJsonString(Object obj){
        return JSON.toJSONString(obj);
    }
}
