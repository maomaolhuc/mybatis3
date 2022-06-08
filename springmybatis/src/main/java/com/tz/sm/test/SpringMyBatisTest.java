package com.tz.sm.test;

import com.github.pagehelper.PageInfo;
import com.tz.sm.entity.Employee;
import com.tz.sm.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMyBatisTest {

    private ApplicationContext ctx = null;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void test() {
        EmployeeService employeeService = (EmployeeService) ctx.getBean("employeeService");
        Employee emp = employeeService.getEmpByIdLazyLoad(45);
        System.out.println(emp);
    }


    @Test
    public void testEmpPage() {
        EmployeeService employeeService = (EmployeeService) ctx.getBean("employeeService");
        PageInfo<Employee> emppageInfo = employeeService.getEmpPage(2, 10);

        System.out.println("员工总数 : " + emppageInfo.getTotal());
        System.out.println("当前页 : " + emppageInfo.getPageNum());
        System.out.println("一页多少数 : " + emppageInfo.getPageSize());
        System.out.println("总页数 : " + emppageInfo.getPages());
        System.out.println("最后一行: " + emppageInfo.getEndRow());

        for (Employee emp : emppageInfo.getList()) {
            System.out.println(emp);
        }

    }
}
