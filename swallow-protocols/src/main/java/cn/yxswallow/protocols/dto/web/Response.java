package cn.yxswallow.protocols.dto.web;


import cn.yxswallow.protocols.dto.DTO;

import java.io.Serial;

/**
 * Response to caller
 *
 * @author yaoxing
 */
public class Response extends DTO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 标识本次请求是否成功
     */
    private boolean success;

    /**
     * 请求不成功时用于标识错误代码
     * @mock A0001
     */
    private String code;

    /**
     * 请求不成功时用于标识错误信息
     */
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Response [success=" + success + ", code=" + code + ", message=" + message + "]";
    }

    public static Response buildSuccess() {
        Response response = new Response();
        response.setSuccess(true);
        return response;
    }

    public static Response buildFailure(String errCode, String errMessage) {
        Response response = new Response();
        response.setSuccess(false);
        response.setCode(errCode);
        response.setMessage(errMessage);
        return response;
    }

}
