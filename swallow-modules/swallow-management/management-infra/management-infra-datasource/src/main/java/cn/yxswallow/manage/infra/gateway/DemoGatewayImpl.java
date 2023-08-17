package cn.yxswallow.manage.infra.gateway;

import cn.yxswallow.manage.client.dto.form.SysDeptForm;
import cn.yxswallow.manage.domain.gateway.DemoGateway;
import cn.yxswallow.manage.infra.db.dept.SysDept;
import cn.yxswallow.manage.infra.db.dept.SysDeptMapper;
import org.beetl.sql.solon.annotation.Db;
import org.noear.solon.annotation.ProxyComponent;

import java.util.List;
@ProxyComponent
public class DemoGatewayImpl implements DemoGateway {
    @Db
    SysDeptMapper sysDeptMapper;
    @Override
    public List<SysDeptForm> queryAll() {
        List<SysDept> all = sysDeptMapper.all();
        return List.of();
    }
}
