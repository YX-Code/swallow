package cn.yxswallow.manage.api.config;

import cn.yxswallow.manage.domain.gateway.DemoGateway;
import cn.yxswallow.manage.infra.db.beetlsql.dept.SysDeptMapper;
import cn.yxswallow.manage.infra.gateway.DemoGatewayImpl;
import org.beetl.sql.solon.annotation.Db;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;

@Configuration
public class GatewayBeanConfig {
    
    @Bean
    public DemoGateway demoGateway(@Db SysDeptMapper sysDeptMapper) {
        return new DemoGatewayImpl(sysDeptMapper);
    }
}
