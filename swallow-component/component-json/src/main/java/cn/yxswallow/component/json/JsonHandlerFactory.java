package cn.yxswallow.component.json;

import cn.yxswallow.common.fastjson2.FastJsonHandler;
import cn.yxswallow.common.jackson.JacksonJsonHandler;
import cn.yxswallow.protocols.exception.SysException;
import cn.yxswallow.protocols.utils.ClassUtils;
import cn.yxswallow.protocols.utils.JsonHandler;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class JsonHandlerFactory {

    public static JsonHandler getJsonHandler() {
        if (ClassUtils.isPresent("cn.yxswallow.common.jackson.JacksonJsonHandler", null)) {
            return new JacksonJsonHandler();
        } else if (ClassUtils.isPresent("cn.yxswallow.common.fastjson2.FastJsonHandler", null)) {
            return new FastJsonHandler();
        } else {
            throw new SysException("no JsonHandler implements in classPath,try add [common-fastjson2] or others");
        }
    }
}
