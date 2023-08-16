package cn.yxswallow.protocols.dto;

import java.io.Serial;

/**
 * 可以既是请求也是响应的实体，是对页面表单和后台数据库的统一表达
 *
 * @author yaoxing
 */
public abstract class Form extends DTO {
    
    @Serial
    private static final long serialVersionUID = -8212239366091301383L;
}
