package cn.yxswallow.protocols.exception;


import cn.yxswallow.protocols.exception.code.BizError;

/**
 * @author yaoxing
 */
public class BizException extends BaseException {
    private static final long serialVersionUID = 7527968181033410628L;

    public BizException() {
    }

    public BizException(BaseRuntimeException exception) {
        super(exception);
    }

    public BizException(BaseException exception) {
        super(exception);
    }


    public BizException(String message) {
        super(message);
    }

    public BizException(BizError bizError) {
        super(bizError);
    }


    public BizException(BizError bizError, String message) {
        super(bizError, message);
    }


    public BizException(String code, String message) {
        super(code, message);
    }

    public BizException(String code, String message, Object body) {
        super(code, message, body);
    }
}
