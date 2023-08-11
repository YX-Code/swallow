package cn.yxswallow.protocols.exception;


import cn.yxswallow.protocols.exception.code.ThirdError;

/**
 * @author yaoxing
 */
public class ThirdException extends BaseRuntimeException {
    private static final long serialVersionUID = -9027395156341404933L;

    public ThirdException() {
    }

    public ThirdException(ThirdError thirdError) {
        super(thirdError);
    }

    public ThirdException(ThirdError thirdError, String message) {
        super(thirdError, message);
    }

    public ThirdException(String code, String message) {
        super(code, message);
    }

    public ThirdException(String code, String message, Object body) {
        super(code, message, body);
    }
}
