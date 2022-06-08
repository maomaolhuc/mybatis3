package com.tz.sm.mapper;

import com.tz.sm.entity.Employee;

import java.util.List;

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
	
	
	public  List<Employee> getEmpPage();
}
