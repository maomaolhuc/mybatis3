package com.tz.sm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tz.sm.entity.Employee;
import com.tz.sm.mapper.EmployeeMapper;
import com.tz.sm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Override
	public Employee getEmpByIdLazyLoad(int empId) {
		// TODO Auto-generated method stub
		return employeeMapper.getEmpByIdLazyLoad(empId);
	}

	@Override
	public List<Employee> getEmpsByDeptIdLazyLoad(int deptId) {
		// TODO Auto-generated method stub
		return employeeMapper.getEmpsByDeptIdLazyLoad(deptId);
	}

	@Override
	public PageInfo<Employee> getEmpPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		/**
		 * 第一个参数：页码
		 * 第二个参数 ： 一页多少条数据
		 */
		PageHelper.startPage(pageNum, pageSize); 
		List<Employee> emps =  employeeMapper.getEmpPage();
		PageInfo<Employee> pageInfo = new PageInfo<Employee>(emps);
		return pageInfo;
	}

}
