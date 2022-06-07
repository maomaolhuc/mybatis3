package com.tz.mybatis.dto;

import com.tz.mybatis.entity.Employee;

import java.util.List;

public class EmpDto {

	private Employee employee;
	
	private List<Integer> ids;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
}
