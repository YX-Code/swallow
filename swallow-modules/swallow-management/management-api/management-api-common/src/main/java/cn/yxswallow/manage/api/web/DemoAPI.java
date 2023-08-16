package cn.yxswallow.manage.api.web;

import cn.yxswallow.manage.client.dto.form.SysDeptForm;
import cn.yxswallow.protocols.dto.response.MultiResponse;

/**
 * @author yaoxing
 */
public interface DemoAPI {
    
    String QUERY_ALL = "/demo/queryAll";
    MultiResponse<SysDeptForm> queryAll();
}
