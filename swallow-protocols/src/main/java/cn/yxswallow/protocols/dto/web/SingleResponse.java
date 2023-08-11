package cn.yxswallow.protocols.dto.web;

import java.util.HashMap;
import java.util.Map;

/**
 * Response with single record to return
 * <p/>
 * @author yaoxing
 */
public class SingleResponse<T> extends Response {

    private static final long serialVersionUID = 1L;

    /**
     * 请求返回数据
     */
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public static <T> SingleResponse<T> success() {
        SingleResponse<T> response = new SingleResponse<>();
        response.setSuccess(true);
        return response;
    }

    public static <T> SingleResponse<T> failure(String errCode, String errMessage) {
        SingleResponse<T> response = new SingleResponse<>();
        response.setSuccess(false);
        response.setCode(errCode);
        response.setMessage(errMessage);
        return response;
    }
    public static SingleResponse<?> buildSuccess() {
        SingleResponse<?> response = new SingleResponse<>();
        response.setSuccess(true);
        return response;
    }

    public static SingleResponse buildFailure(String errCode, String errMessage) {
        SingleResponse response = new SingleResponse();
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
    public static SingleResponse<Object> of(String key, Object value) {
        SingleResponse<Object> response = new SingleResponse<>();
        response.setSuccess(true);
        Map<String, Object> result = new HashMap<>();
        result.put(key, value);
        response.setData(result);
        return response;
    }
    public SingleResponse<Object> add(String key, Object value) {
        if (this.getData() == null) {
            return SingleResponse.of(key, value);
        }
        if (this.getData() instanceof Map) {
            Map<String,Object> mapData = (Map<String,Object>)this.getData();
            mapData.put(key, value);
            return (SingleResponse<Object>) this;
        }
        throw new IllegalArgumentException("data泛型类型不正确");
    }
}
