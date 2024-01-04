package cn.yxswallow.protocols.dto.response;

import java.util.HashMap;
import java.util.Map;

/**
 * Response with single record to return
 * <p/>
 * 
 * @author yaoxing
 */
public class SingleResponse<T> extends Response {

    private static final long serialVersionUID = 1L;

    /**
     * 请求返回数据
     */
    private transient T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> SingleResponse<T> buildSuccess() {
        SingleResponse<T> response = new SingleResponse<>();
        response.setSuccess(true);
        return response;
    }

    public static <T> SingleResponse<T> buildFailure(String errCode, String errMessage) {
        SingleResponse<T> response = new SingleResponse<>();
        response.setSuccess(false);
        response.setCode(errCode);
        response.setMessage(errMessage);
        return response;
    }

    public static <T> SingleResponse<T> of(T data) {
        SingleResponse<T> response = new SingleResponse<>();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    public static <T> SingleResponse<Map<String, T>> of(String key, T value) {
        SingleResponse<Map<String, T>> response = new SingleResponse<>();
        response.setSuccess(true);
        Map<String, T> result = new HashMap<>();
        result.put(key, value);
        response.setData(result);
        return response;
    }
}
