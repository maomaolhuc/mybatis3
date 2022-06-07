package com.tz.mybatis.entity;

public class Admin {
	
	private int deptId;
	
	private String name;
	
	private String deptName;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Admin [deptId=" + deptId + ", name=" + name + ", deptName=" + deptName + "]";
	}

	

}
