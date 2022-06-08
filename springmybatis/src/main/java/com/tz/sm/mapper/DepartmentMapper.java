package com.tz.sm.mapper;

import com.tz.sm.entity.Department;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {

	
	public Department getDepartmentById(@Param("deptId") int deptId);
	
	
	public Department getDeptById(int deptId);
}
