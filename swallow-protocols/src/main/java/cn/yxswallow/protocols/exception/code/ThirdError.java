package cn.yxswallow.protocols.exception.code;

/**
 * @author yaoxing
 */

public enum ThirdError {
    /**
     * 一级宏观错误码
     */
    T0001("调用第三方服务出错");
    private final String desc;

    ThirdError(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
