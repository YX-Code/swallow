package cn.yxswallow.manage.service.demo;

import cn.yxswallow.manage.client.dto.form.SysDeptForm;
import cn.yxswallow.manage.client.service.DemoService;
import cn.yxswallow.manage.domain.Department;
import cn.yxswallow.manage.domain.gateway.DemoGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class DemoServiceImpl implements DemoService {
    private final DemoGateway demoGateway;
    
    @Override
    public List<SysDeptForm> queryAllDept() {
        List<Department> departments = demoGateway.queryAll();
        log.info("查询完成");
        return List.of();
    }
    
}
