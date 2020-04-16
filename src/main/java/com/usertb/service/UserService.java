package com.usertb.service;

import com.usertb.entity.Page;
import com.usertb.entity.User;

import java.util.List;

public interface UserService {
	/**
	 * 根据id获取一个user对象
	 * @param id
	 * @return
	 */
	User getUserById(Integer id);

	/**
	 * 添加Usre并同时为他赋权，添加一行null资料
	 * @param user
	 * @return
	 */
	String saveUser(User user);

	/**
	 * 判断数据库中该user对象是否存在
	 * @param user
	 * @return
	 */
	boolean getUserByPhoneOrEmailOrmenbername(User user);

	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	Integer LogInUser(User user);

	/**
	 * 用户修改信息
	 * @param user
	 * @return
	 */
	Integer updateUser(User user);

	/**
	 * 分页查询所有
	 * @return
	 */
	List<User> listPageUsers(Page page);

	/**
	 * 查询用户总数据
	 * @return
	 */
	int getUsers();
}
