package com.tz.mybatis.mapper;

import java.util.List;

import com.tz.mybatis.entity.Employee;

public interface EmployeeMapper {

	/**
	 * 根据员工ID查询员工信息
	 * @param empId
	 * @return
	 */
	public Employee getEmpByIdLazyLoad(int empId);
	
	/**
	 * 根据部门ID查询员工们
	 * @param deptId
	 * @return
	 */
	public List<Employee> getEmpsByDeptIdLazyLoad(int deptId);
}
