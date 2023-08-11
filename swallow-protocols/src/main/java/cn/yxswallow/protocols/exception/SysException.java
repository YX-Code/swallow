package cn.yxswallow.protocols.exception;


import cn.yxswallow.protocols.exception.code.SysError;

/**
 * @author yaoxing
 */
public class SysException extends BaseRuntimeException {
    private static final long serialVersionUID = -2063084529259210208L;

    public SysException() {
    }

    public SysException(BaseRuntimeException exception) {
        super(exception);
    }

    public SysException(BaseException exception) {
        super(exception);
    }

    public SysException(String message) {
        super(message);
    }


    public SysException(SysError sysError) {
        super(sysError);
    }


    public SysException(SysError sysError, String message) {
        super(sysError, message);
    }


    public SysException(String code, String message) {
        super(code, message);
    }

    public SysException(String code, String message, Object body) {
        super(code, message, body);
    }
}
