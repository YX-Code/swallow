package cn.yxswallow.protocols.dto.response;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Response with batch record to return,
 * usually use in conditional query
 * <p/>
 *
 * @author yaoxing
 */
public class MultiResponse<T> extends Response {
    
    @Serial
    private static final long serialVersionUID = 1L;
    
    private Collection<T> data;
    
    public List<T> getData() {
        if (null == data) {
            return Collections.emptyList();
        }
        if (data instanceof List) {
            return (List<T>) data;
        }
        return new ArrayList<>(data);
    }
    
    public void setData(Collection<T> data) {
        this.data = data;
    }
    
    public boolean isEmpty() {
        return data == null || data.isEmpty();
    }
    
    public boolean isNotEmpty() {
        return !isEmpty();
    }
    
    public static MultiResponse<Object> buildSuccess() {
        MultiResponse<Object> response = new MultiResponse<>();
        response.setSuccess(true);
        return response;
    }
    
    public static MultiResponse<Object> buildFailure(String errCode, String errMessage) {
        MultiResponse<Object> response = new MultiResponse<>();
        response.setSuccess(false);
        response.setCode(errCode);
        response.setMessage(errMessage);
        return response;
    }
    
    public static <T> MultiResponse<T> success() {
        MultiResponse<T> response = new MultiResponse<>();
        response.setSuccess(true);
        return response;
    }
    
    public static <T> MultiResponse<T> failure(String errCode, String errMessage) {
        MultiResponse<T> response = new MultiResponse<>();
        response.setSuccess(false);
        response.setCode(errCode);
        response.setMessage(errMessage);
        return response;
    }
    
    public static <T> MultiResponse<T> of(Collection<T> data) {
        MultiResponse<T> response = new MultiResponse<>();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }
    
}
