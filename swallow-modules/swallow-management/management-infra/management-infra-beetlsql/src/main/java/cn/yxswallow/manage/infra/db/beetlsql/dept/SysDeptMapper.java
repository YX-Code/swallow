package cn.yxswallow.manage.infra.db.beetlsql.dept;

import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.SqlResource;

import java.util.List;

/*
* 
* gen by beetlsql3 mapper 2023-08-15
*/
@SqlResource("SysDeptMapper")
public interface SysDeptMapper extends BaseMapper<SysDept> {
    List<SysDept> sample(SysDept sysDept);
	
}