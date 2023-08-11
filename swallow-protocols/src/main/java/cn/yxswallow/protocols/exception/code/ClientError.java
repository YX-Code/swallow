package cn.yxswallow.protocols.exception.code;

/**
 * @author yaoxing
 */

public enum ClientError {
    C0001("用户端错误"),
    C0210("用户密码错误"),
    C0211("用户输入密码错误次数超限"),
    C0230("用户未登录或会话已过期"),
    C0301("访问未授权"),
    C0400("用户请求参数错误"),
    C0410("请求必填参数为空"),
    C0420("请求参数超出允许范围");
    private final String desc;

    ClientError(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
