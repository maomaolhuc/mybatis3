package com.tz.sm.test;

import com.tz.sm.entity.Department;
import com.tz.sm.entity.Employee;
import com.tz.sm.mapper.DepartmentMapper;
import com.tz.sm.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
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
    public void testGetDepartmentById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department dept = deptMapper.getDepartmentById(1002);
        System.out.println(dept);
        sqlSession.close();
    }

    /**
     * 演示一对一，从员工查询部门的延迟加载
     */
    @Test
    public void testGetEmpByIdLazyLoad() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper empMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp = empMapper.getEmpByIdLazyLoad(45);
        System.out.println(emp);
        System.out.println("======================");
        System.out.println(emp.getDept());
        sqlSession.close();
    }

    @Test
    public void testGetEmpsByDeptIdLazyLoad() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper empMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> emps = empMapper.getEmpsByDeptIdLazyLoad(1002);
        for (Employee emp : emps) {
            System.out.println(emp);
        }
        sqlSession.close();
    }

    /**
     * 演示一对多，从部门查询部门的员工的延迟加载
     */
    @Test
    public void testGetEmpsByDeptIdLazyLoad1() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department dept = deptMapper.getDeptById(1002);
        System.out.println(dept);
        System.out.println("======================");
        for (Employee emp : dept.getEmps()) {
            System.out.println(emp);
        }

        sqlSession.close();
    }


    /**
     * 测试一级缓存
     * <p>getDeptById
     * 如果commit后，一级缓存失效
     */
    @Test
    public void testCache1() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department dept = deptMapper.getDepartmentById(1002);
        System.out.println(dept);

        System.out.println("=============================");

        Department dept1 = deptMapper.getDepartmentById(1002);
        System.out.println(dept1);

        sqlSession.close();
    }

    /**
     * 测试二级缓存
     */
    @Test
    public void testCache2() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department dept = deptMapper.getDepartmentById(1002);
        System.out.println(dept);
        sqlSession.close();
        System.out.println("=============================");

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        DepartmentMapper deptMapper1 = sqlSession1.getMapper(DepartmentMapper.class);
        Department dept1 = deptMapper1.getDepartmentById(1002);
        System.out.println(dept1);
        sqlSession.close();
    }

    /**
     * 测试禁用缓存
     */
    @Test
    public void testNOCache() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department dept = deptMapper.getDeptById(1002);
        System.out.println(dept);

        sqlSession.close();

        System.out.println("=============================");

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        DepartmentMapper deptMapper1 = sqlSession1.getMapper(DepartmentMapper.class);
        Department dept1 = deptMapper1.getDeptById(1002);
        System.out.println(dept1);

        sqlSession.close();
    }


}
