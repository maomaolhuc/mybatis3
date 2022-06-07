package com.tz.mybatis.dao.impl;

import com.tz.mybatis.dao.StudentDao;
import com.tz.mybatis.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * StudentDao的实现类
 *
 * @author Administrator
 */
public class StudentDaoImpl implements StudentDao {

    private SqlSessionFactory sqlSessionFactory;

    public StudentDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Student getStudentById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student stu = sqlSession.selectOne("com.tz.mybatis.xml.StudentMapper.getStudentById", id);
        sqlSession.close();
        return stu;
    }

    @Override
    public List<Student> getStudentList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Student> stus = sqlSession.selectList("com.tz.mybatis.xml.StudentMapper.getStudentList");
        sqlSession.close();
        return stus;
    }

    @Override
    public void addStudent(Student stu) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int rows = sqlSession.insert("com.tz.mybatis.xml.StudentMapper.addStudent", stu);
        System.out.println("行数   ： " + rows);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delStudent(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int rows = sqlSession.delete("com.tz.mybatis.xml.StudentMapper.delStudent", id);
        System.out.println("行数   ： " + rows);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void uptStudent(Student stu) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int rows = sqlSession.update("com.tz.mybatis.xml.StudentMapper.uptStudent", stu);
        System.out.println("行数   ： " + rows);
        sqlSession.commit();
        sqlSession.close();
    }

}
