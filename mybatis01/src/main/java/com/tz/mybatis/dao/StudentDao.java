package com.tz.mybatis.dao;

import java.util.List;

import com.tz.mybatis.entity.Student;

public interface StudentDao {
	
	public Student getStudentById(int id);
	
	public List<Student> getStudentList();
	
	public void addStudent(Student stu);
	
	public void delStudent(int id);
	
	public void uptStudent(Student stu);

}
