package com.tz.mybatis.mapper;

import java.util.List;

import com.tz.mybatis.entity.Admin;

public interface AdminMapper {
	
	public void addAdmin(Admin admin);
	
	public List<Admin> getAdminAll();
	
	

}
