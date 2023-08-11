package cn.yxswallow.protocols.exception.code;

/**
 * @author yaoxing
 */

public enum SysError {
    /**
     * 一级宏观错误码
     */
    S0001("系统执行出错"),
    S0002("系统数据异常"),
    S0003("当前操作不被支持");
    private final String desc;

    SysError(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
