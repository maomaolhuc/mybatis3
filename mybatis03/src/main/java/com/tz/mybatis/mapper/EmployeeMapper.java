package com.tz.mybatis.mapper;

import java.util.List;

import com.tz.mybatis.dto.EmpDto;
import com.tz.mybatis.entity.Employee;

public interface EmployeeMapper {

	public List<Employee> getEmpByEmpDto(EmpDto empDto);
}
