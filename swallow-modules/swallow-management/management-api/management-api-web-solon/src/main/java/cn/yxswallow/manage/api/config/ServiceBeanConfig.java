package cn.yxswallow.manage.api.config;

import cn.yxswallow.manage.client.service.DemoService;
import cn.yxswallow.manage.domain.gateway.DemoGateway;
import cn.yxswallow.manage.service.demo.DemoServiceImpl;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;

@Configuration
public class ServiceBeanConfig {
    @Bean
    public DemoService demoService(@Inject DemoGateway demoGateway){
        return new DemoServiceImpl(demoGateway);
    }
}
