package com.tz.mybatis.test;

import com.tz.mybatis.dto.EmpDto;
import com.tz.mybatis.entity.Admin;
import com.tz.mybatis.entity.Department;
import com.tz.mybatis.entity.Employee;
import com.tz.mybatis.mapper.AdminMapper;
import com.tz.mybatis.mapper.DepartmentMapper;
import com.tz.mybatis.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyBatisMapperTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws IOException {
		String configFile = "mybatis-config.xml";
		InputStream intputStream = Resources.getResourceAsStream(configFile);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(intputStream);
	}

	@Test
	public void test() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		EmployeeMapper empMapper = sqlSession.getMapper(EmployeeMapper.class);
		EmpDto empDto = new EmpDto();
		Employee employee = new Employee();
		employee.setEmpName("吴");
		//employee.setGender("男");
		empDto.setEmployee(employee);
		
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1000);
		ids.add(1001);
		ids.add(1002);
		
		empDto.setIds(ids);
		
		List<Employee> emps = empMapper.getEmpByEmpDto(empDto);
		for(Employee emp : emps){
			System.out.println(emp);
		}
		sqlSession.close();
	}
	
	@Test
	public void testSelectKey() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		Admin admin = new Admin();
		admin.setName("潭州学院");
		adminMapper.addAdmin(admin);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testGetAdminAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		List<Admin> admins = adminMapper.getAdminAll();
		for(Admin admin : admins){
			System.out.println(admin);
		}
		sqlSession.close();
	}
	
	@Test
	public void testGetDepartmentTypeTwo() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);
		List<Department> depts = deptMapper.getDepartmentTypeTwo();
		for(Department dept : depts){
			System.out.println(dept);
		}
		sqlSession.close();
	}
	
	
	@Test
	public void testGetDepartmentEmp() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);
		List<Department> depts = deptMapper.getDepartmentEmp(1002);
		for(Department dept : depts){
			System.out.println(dept);
		}
		sqlSession.close();
	}
	
	@Test
	public void testGetDepartmentEmpALL() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);
		List<Department> depts = deptMapper.getDepartmentEmpAll(1002);
		for(Department dept : depts){
			System.out.println(dept);
		}
		sqlSession.close();
	}
	
	
}
