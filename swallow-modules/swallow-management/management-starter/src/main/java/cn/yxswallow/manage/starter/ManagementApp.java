package cn.yxswallow.manage.starter;

import org.noear.solon.Solon;
import org.noear.solon.annotation.Import;

@Import(scanPackages = {"cn.yxswallow.manage.api","cn.yxswallow.manage.infra","cn.yxswallow.manage.service"})
public class ManagementApp {
    public static void main(String[] args) {
        Solon.start(ManagementApp.class, args);
    }
}