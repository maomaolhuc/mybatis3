package com.tz.mybatis.mapper;

import com.tz.mybatis.dto.UserDto;
import com.tz.mybatis.entity.User;

import java.util.List;
import java.util.Map;

/**
 * ORM  object - relationship map
 * 
 * 基于SQL语句的ORM映射
 * @author Administrator
 *
 */
public interface UserMapper {
	
	public User getUserById(int id);
	
	public List<User> getUserList();
	
	public void addUser(User user);
	
	public void delUser(int id);
	
	public void uptUser(User user);
	
	/**
	 * 用户名和密码登录
	 */
	public User getUserByNameAndPwd(String name, String pwd);
	
	/**
	 * 通过包装类查询
	 */
	public List<User> getUserByUserDto(UserDto userDto);
	
	/**
	 * 统计数量
	 * @return
	 */
	public int getUserCount();
	
	/**
	 * 返回HashMap
	 */
	public List<Map<Object,Object>> getUserListMap();

	/**
	 * 用resultMap
	 */
	public List<User> getUserListByResultMap();
}
