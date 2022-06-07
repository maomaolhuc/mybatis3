package com.tz.mybatis.test;

import com.tz.mybatis.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MainTest {

    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        String configFile = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(configFile);
        //2.通过SqlSessionFactoryBuilder创建一个SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.通过SqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.调用SqlSession接口方法来执行数据库的操作
        Student stu = sqlSession.selectOne("com.tz.mybatis.xml.StudentMapper.getStudentById", 1);
        //5.测试
        System.out.println(stu);
        //6.关闭sqlSession
        sqlSession.close();
    }

}
