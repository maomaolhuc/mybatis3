package com.tz.mybatis.mapper;

import java.util.List;

import com.tz.mybatis.entity.Department;

public interface DepartmentMapper {

	public List<Department> getDepartmentTypeTwo();
	
	public List<Department> getDepartmentEmp(int deptid);
	
	public List<Department> getDepartmentEmpAll(int deptid);
	
}
