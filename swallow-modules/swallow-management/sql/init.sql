-- `system`.sys_dept definition

CREATE TABLE `sys_dept`
(
    `dept_id`     bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '部门id',
    `parent_id`   bigint unsigned                                                       DEFAULT '0' COMMENT '父部门id',
    `ancestors`   varchar(50)  DEFAULT '' COMMENT '祖级列表',
    `dept_name`   varchar(30)  DEFAULT '' COMMENT '部门名称',
    `order_num`   int                                                          DEFAULT '0' COMMENT '显示顺序',
    `leader`      varchar(20)  DEFAULT NULL COMMENT '负责人',
    `phone`       varchar(11)  DEFAULT NULL COMMENT '联系电话',
    `email`       varchar(50)  DEFAULT NULL COMMENT '邮箱',
    `status`      char(1)      DEFAULT '0' COMMENT '部门状态（1正常 0停用）',
    `del_flag`    char(1)      DEFAULT '0' COMMENT '删除标志（Y代表删除 N代表存在）',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime                                                     DEFAULT NULL COMMENT '更新时间',
    `short_name`  varchar(50)                                                  DEFAULT NULL COMMENT '部门简称',
    PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB COMMENT ='部门表';