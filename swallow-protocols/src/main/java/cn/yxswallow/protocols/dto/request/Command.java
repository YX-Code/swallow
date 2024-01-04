package cn.yxswallow.protocols.dto.request;

import cn.yxswallow.protocols.dto.DTO;

import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

/**
 * Command request from Client.
 *
 * @author yaoxing
 */
public abstract class Command extends DTO {
    @Serial
    private static final long serialVersionUID = 1L;
    protected Map<String, Object> params = new HashMap<>();
    
    public Object getParam(String key) {
        if (params != null) {
            return params.get(key);
        }
        return null;
    }
    
    public void putParam(String fieldName, Object value) {
        this.params.put(fieldName, value);
    }
    
    public Map<String, Object> getParams() {
        return params;
    }
    
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
