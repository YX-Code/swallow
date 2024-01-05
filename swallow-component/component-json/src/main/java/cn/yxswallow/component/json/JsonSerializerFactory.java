package cn.yxswallow.component.json;

import cn.yxswallow.common.fastjson2.FastJsonSerializer;
import cn.yxswallow.common.jackson.JacksonJsonSerializer;
import cn.yxswallow.protocols.exception.SysException;
import cn.yxswallow.protocols.utils.ClassUtils;
import cn.yxswallow.protocols.utils.JsonSerializer;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class JsonSerializerFactory {

    public static JsonSerializer getJsonSerializer() {
        if (ClassUtils.isPresent("cn.yxswallow.common.jackson.JacksonJsonSerializer", null)) {
            return new JacksonJsonSerializer();
        } else if (ClassUtils.isPresent("cn.yxswallow.common.fastjson2.FastJsonSerializer", null)) {
            return new FastJsonSerializer();
        } else {
            throw new SysException("no JsonSerializer implements in classPath,try add [common-fastjson2] or others");
        }
    }
}
