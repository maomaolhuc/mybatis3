package com.tz.mybatis.entity;

import java.util.List;

public class Department {

	private int deptId;

	private String deptName;

	// private Admin admin;

	// private List<Employee> emps;

	private int empId;

	private String empName;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	// public Admin getAdmin() {
	// return admin;
	// }
	//
	// public void setAdmin(Admin admin) {
	// this.admin = admin;
	// }

	// public List<Employee> getEmps() {
	// return emps;
	// }
	//
	// public void setEmps(List<Employee> emps) {
	// this.emps = emps;
	// }


	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", empId=" + empId + ", empName=" + empName
				+ "]";
	}

}
