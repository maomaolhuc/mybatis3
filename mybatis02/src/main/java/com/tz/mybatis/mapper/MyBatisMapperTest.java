package com.tz.mybatis.mapper;

import com.tz.mybatis.dto.UserDto;
import com.tz.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MyBatisMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String configFile = "mybatis-config.xml";
        InputStream intputStream = Resources.getResourceAsStream(configFile);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(intputStream);
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.getUserById(1));
        sqlSession.close();
    }

    @Test
    public void testGetUserList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getUserList();
        for (User u : users) {
            System.out.println(u);
        }
        sqlSession.close();
    }

    @Test
    public void testAddUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("GoodLuck");
        user.setPassword("123");
        user.setAge(22);
        user.setCreateTime(new Date());
        userMapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDelUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.delUser(6);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUptUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(6);
        user.setName("满村");
        user.setPassword("123");
        user.setAge(22);
        user.setCreateTime(new Date());
        userMapper.uptUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testGetUserByNameAndPwd() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByNameAndPwd("Tom", "123");
        System.out.println(user);
        sqlSession.close();
    }

    /**
     * 模糊查询
     */
    @Test
    public void testGetUserByUserDto() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserDto userDto = new UserDto();
        User user = new User();
        user.setName("同学");
        userDto.setUser(user);

        List<User> users = userMapper.getUserByUserDto(userDto);
        for (User u : users) {
            System.out.println(u);
        }
        sqlSession.close();
    }

    @Test
    public void testGetUserCount() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int a = userMapper.getUserCount();
        System.out.println(a);
    }

    @Test
    public void testGetUserListMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<Map<Object, Object>> users = userMapper.getUserListMap();
        for (Map<Object, Object> u : users) {
            System.out.println(u);
        }
        sqlSession.close();
    }

    @Test
    public void testGetUserListByResultMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getUserListByResultMap();
        for (User u : users) {
            System.out.println(u);
        }
        sqlSession.close();
    }

}
