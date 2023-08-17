package cn.yxswallow.manage.service.demo;

import cn.yxswallow.manage.client.dto.form.SysDeptForm;
import cn.yxswallow.manage.client.service.DemoService;
import cn.yxswallow.manage.domain.gateway.DemoGateway;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.ProxyComponent;

import java.util.List;

@Slf4j
@ProxyComponent
public class DemoServiceImpl implements DemoService {
    @Inject
    DemoGateway demoGateway;
    
    @Override
    public List<SysDeptForm> queryAllDept() {
        List<SysDeptForm> departments = demoGateway.queryAll();
        log.info("查询完成");
        return departments;
    }
    
}
