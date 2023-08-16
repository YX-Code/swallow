package cn.yxswallow.manage.domain.gateway;

import cn.yxswallow.manage.domain.Department;

import java.util.List;

public interface DemoGateway {
    List<Department> queryAll();
}
