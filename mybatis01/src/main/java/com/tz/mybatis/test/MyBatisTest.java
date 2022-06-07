package com.tz.mybatis.test;

import com.tz.mybatis.dao.StudentDao;
import com.tz.mybatis.dao.impl.StudentDaoImpl;
import com.tz.mybatis.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        // 1.读取配置文件
        String configFile = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(configFile);
        // 2.通过SqlSessionFactoryBuilder创建一个SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testGetStudentById() {
        StudentDao stuDao = new StudentDaoImpl(sqlSessionFactory);
        System.out.println(stuDao.getStudentById(1));
    }

    @Test
    public void testGetStudentList() {
        StudentDao stuDao = new StudentDaoImpl(sqlSessionFactory);
        List<Student> stus = stuDao.getStudentList();
        for (Student stu : stus) {
            System.out.println(stu);
        }
    }

    @Test
    public void testAddStudent() {
        StudentDao stuDao = new StudentDaoImpl(sqlSessionFactory);
        Student stu = new Student();
        stu.setName("玉面书生同学");
        stu.setAge(22);
        stu.setCreateTime(new Date());
        stuDao.addStudent(stu);
    }

    @Test
    public void testDelStudent() {
        StudentDao stuDao = new StudentDaoImpl(sqlSessionFactory);
        stuDao.delStudent(3);
    }

    @Test
    public void testUptStudent() {
        StudentDao stuDao = new StudentDaoImpl(sqlSessionFactory);
        Student stu = new Student();
        stu.setId(4);
        stu.setName("未知同学");
        stu.setAge(18);
        stu.setCreateTime(new Date());
        stuDao.uptStudent(stu);
    }
}
