package cn.yxswallow.manage.api.web.demo;

import cn.yxswallow.manage.api.web.DemoAPI;
import cn.yxswallow.manage.client.dto.form.SysDeptForm;
import cn.yxswallow.manage.client.service.DemoService;
import cn.yxswallow.protocols.dto.response.MultiResponse;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

/**
 * @author yaoxing
 */
@Controller
public class DemoAPISolon implements DemoAPI {
    @Inject
    private DemoService demoService;
    
    @Override
    @Mapping(DemoAPI.QUERY_ALL)
    public MultiResponse<SysDeptForm> queryAll() {
        return MultiResponse.of(demoService.queryAllDept());
    }
}
