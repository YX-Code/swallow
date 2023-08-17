package cn.yxswallow.manage.infra.db.dept;

import lombok.Data;
import org.beetl.sql.annotation.entity.AutoID;
import org.beetl.sql.annotation.entity.Table;

import java.util.Date;
/*
 * 部门表
 * gen by beetlsql3 2023-08-15
 */
@Data
@Table(name = "sys_dept")
public class SysDept {
    /**
     * 部门id
     */
    @AutoID
    private Long deptId;
    /**
     * 父部门id
     */
    private Long parentId;
    /**
     * 祖级列表
     */
    private String ancestors;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 显示顺序
     */
    private Integer orderNum;
    /**
     * 负责人
     */
    private String leader;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 部门状态（1正常 0停用）
     */
    private String status;
    /**
     * 删除标志（Y代表删除 N代表存在）
     */
    private String delFlag;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新者
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 部门简称
     */
    private String shortName;
    
    public SysDept() {
    }
    
    
}