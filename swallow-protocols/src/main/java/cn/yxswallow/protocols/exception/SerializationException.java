package cn.yxswallow.protocols.exception;

import cn.yxswallow.protocols.exception.code.SysError;

import java.io.Serial;

public class SerializationException extends SysException{
    @Serial
    private static final long serialVersionUID = -3145761319047122276L;

    public SerializationException() {
        super();
    }

    public SerializationException(BaseRuntimeException exception) {
        super(exception);
    }

    public SerializationException(BaseException exception) {
        super(exception);
    }

    public SerializationException(String message) {
        super(message);
    }

    public SerializationException(SysError sysError) {
        super(sysError);
    }

    public SerializationException(SysError sysError, String message) {
        super(sysError, message);
    }

    public SerializationException(String code, String message) {
        super(code, message);
    }

    public SerializationException(String code, String message, Object body) {
        super(code, message, body);
    }
}
