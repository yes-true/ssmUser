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
	 * 修改头像
	 * @param photo 头像名
	 * @param id 用户ID
	 * @return
	 */
	Integer updatePhoto(String photo, int id);

	/**
	 * 分页查询所有用户
	 * @param currentPage 页数*页面大小
	 * @param pageSize 页面大小
	 * @return
	 */
	List<User> listPageUsers(int currentPage, int pageSize);

	/**
	 * 查询用户总数据
	 * @return
	 */
	int getUsers();
}
