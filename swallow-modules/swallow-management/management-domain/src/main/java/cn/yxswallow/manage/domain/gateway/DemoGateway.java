package cn.yxswallow.manage.domain.gateway;

import cn.yxswallow.manage.client.dto.form.SysDeptForm;

import java.util.List;

public interface DemoGateway {
    List<SysDeptForm> queryAll();
}
