package cn.yxswallow.protocols.exception;


import cn.yxswallow.protocols.exception.code.BizError;
import cn.yxswallow.protocols.exception.code.ClientError;
import cn.yxswallow.protocols.exception.code.SysError;
import cn.yxswallow.protocols.exception.code.ThirdError;

/**
 * @author yaoxing
 */
public abstract class BaseRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -5972313863492734644L;
    protected transient Object body;
    protected String code;
    protected String message;

    protected BaseRuntimeException() {
    }

    public BaseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseRuntimeException(Throwable cause) {
        super(cause);
    }

    protected BaseRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    protected BaseRuntimeException(String message) {
        this.message = message;
        this.code = SysError.S0001.name();
    }
    protected BaseRuntimeException(BaseRuntimeException exception) {
        this(exception.getCode(),exception.getMessage(),exception.getBody());
    }
    protected BaseRuntimeException(BaseException exception) {
        this(exception.getCode(),exception.getMessage(),exception.getBody());
    }
    protected BaseRuntimeException(ClientError clientError) {
        this.setCode(clientError.name());
        this.setMessage(clientError.getDesc());
    }

    protected BaseRuntimeException(BizError bizError) {
        this.setCode(bizError.name());
        this.setMessage(bizError.getDesc());
    }

    protected BaseRuntimeException(SysError sysError) {
        this.setCode(sysError.name());
        this.setMessage(sysError.getDesc());
    }

    protected BaseRuntimeException(ThirdError thirdError) {
        this.setCode(thirdError.name());
        this.setMessage(thirdError.getDesc());
    }

    protected BaseRuntimeException(ClientError clientError, String message) {
        this.setCode(clientError.name());
        this.setMessage(message);
    }

    protected BaseRuntimeException(BizError bizError, String message) {
        this.setCode(bizError.name());
        this.setMessage(message);
    }

    protected BaseRuntimeException(SysError sysError, String message) {
        this.setCode(sysError.name());
        this.setMessage(message);
    }

    protected BaseRuntimeException(ThirdError thirdError, String message) {
        this.setCode(thirdError.name());
        this.setMessage(message);
    }

    protected BaseRuntimeException(String code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    protected BaseRuntimeException(String code, String message, Object body) {
        this.setCode(code);
        this.setBody(body);
        this.setMessage(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
