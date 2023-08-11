package cn.yxswallow.protocols.exception;


import cn.yxswallow.protocols.exception.code.BizError;
import cn.yxswallow.protocols.exception.code.ClientError;
import cn.yxswallow.protocols.exception.code.SysError;
import cn.yxswallow.protocols.exception.code.ThirdError;

/**
 * @author yaoxing
 */
public class BaseException extends Exception{
    private static final long serialVersionUID = -5265715385428040438L;
    protected transient Object body;
    protected String code;
    protected String message;

    protected BaseException() {
    }
    protected BaseException(String message) {
        this.message = message;
        this.code = SysError.S0001.name();
    }
    protected BaseException(BaseRuntimeException exception) {
        this(exception.getCode(),exception.getMessage(),exception.getBody());
    }
    protected BaseException(BaseException exception) {
        this(exception.getCode(),exception.getMessage(),exception.getBody());
    }
    protected BaseException(ClientError clientError) {
        this.setCode(clientError.name());
        this.setMessage(clientError.getDesc());
    }

    protected BaseException(BizError bizError) {
        this.setCode(bizError.name());
        this.setMessage(bizError.getDesc());
    }

    protected BaseException(SysError sysError) {
        this.setCode(sysError.name());
        this.setMessage(sysError.getDesc());
    }

    protected BaseException(ThirdError thirdError) {
        this.setCode(thirdError.name());
        this.setMessage(thirdError.getDesc());
    }

    protected BaseException(ClientError clientError, String message) {
        this.setCode(clientError.name());
        this.setMessage(message);
    }

    protected BaseException(BizError bizError, String message) {
        this.setCode(bizError.name());
        this.setMessage(message);
    }

    protected BaseException(SysError sysError, String message) {
        this.setCode(sysError.name());
        this.setMessage(message);
    }

    protected BaseException(ThirdError thirdError, String message) {
        this.setCode(thirdError.name());
        this.setMessage(message);
    }

    protected BaseException(String code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    protected BaseException(String code, String message, Object body) {
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
