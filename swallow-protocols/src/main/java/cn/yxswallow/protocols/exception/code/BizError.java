package cn.yxswallow.protocols.exception.code;

/**
 * @author yaoxing
 */

public enum BizError {
    /**
     * 一级宏观错误码
     */
    B0001("业务规则校验异常");
    private final String desc;

    BizError(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
