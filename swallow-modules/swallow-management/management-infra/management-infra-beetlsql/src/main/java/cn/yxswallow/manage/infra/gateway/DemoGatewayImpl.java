package cn.yxswallow.manage.infra.gateway;

import cn.yxswallow.manage.domain.Department;
import cn.yxswallow.manage.domain.gateway.DemoGateway;
import cn.yxswallow.manage.infra.db.beetlsql.dept.SysDept;
import cn.yxswallow.manage.infra.db.beetlsql.dept.SysDeptMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class DemoGatewayImpl implements DemoGateway {

    private final SysDeptMapper sysDeptMapper;
    @Override
    public List<Department> queryAll() {
        List<SysDept> all = sysDeptMapper.all();
        return List.of();
    }
}
