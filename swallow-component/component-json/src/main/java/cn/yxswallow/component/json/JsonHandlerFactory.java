package cn.yxswallow.component.json;

import cn.yxswallow.common.fastjson2.FastJsonHandler;
import cn.yxswallow.protocols.exception.SysException;
import cn.yxswallow.protocols.utils.ClassUtils;
import cn.yxswallow.protocols.utils.JsonHandler;

public abstract class JsonHandlerFactory {

    public static JsonHandler getJsonHandler() {
        if (ClassUtils.isPresent("cn.yxswallow.common.fastjson2.FastJsonHandler", (ClassLoader) null)) {
            return new FastJsonHandler();
        } else {
            throw new SysException("no JsonHandler implements in classPath,try add [common-fastjson2] or others");
        }
    }
}
