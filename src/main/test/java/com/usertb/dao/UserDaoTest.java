package com.usertb.dao;

import com.usertb.dao.UserDao;
import com.usertb.entity.Page;
import com.usertb.entity.User;
import com.usertb.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserDaoTest {

	@Resource
	private UserDao userDao;

	@Resource
	private User user;

	@Test
	public void getUser(){
		User user = userDao.getUserById(1);
		System.out.println("user = " + user.toString());
		System.out.println(user.getRightcontrol());
		System.out.println("user = " + user.getSites());
		System.out.println("user.getDatum() = " + user.getDatum());
	}

	@Test
	public void saveUser(){
		String menbername = "hhjj1472588";
		String password = "123456";
		String phone = "14523652001";
		String email = "1452@qq.com";
		Timestamp atime = new Timestamp(new Date().getTime());
		Timestamp utime = new Timestamp(new Date().getTime());
		User user = new User(null,menbername,password,phone,email,atime,utime);

		userDao.saveUser(user);
	}

	@Test
	public void deleteUser(){
		userDao.deleteUserById(4);
	}

	@Test
	public void updateUser(){

		String password = "22655";
		String phone = "14789998001";
		String email = "1845642152@qq.com";
		Timestamp utime = new Timestamp(new Date().getTime());
		User user = new User(5,password,phone,email,utime);
		userDao.updateUser(user);
	}

	@Test
	public void getUserByPassword(){
		user.setEmail("123456@qq.com");
		Integer user = userDao.getUserByPhoneOrEmailOrmenbername(this.user);
		if (user != null)
			System.out.println("存在");
		if (user == null)
			System.out.println("不存在");
	}

	@Test
	public void listuser(){
		List<User> users = userDao.listUser(2*5,5);
		for (User user: users) {
			System.out.println("user = " + user);
		}
	}

	@Test
	public void getUsers(){
		int users = userDao.getUsers();
		System.out.println("users = " + users);
	}
}
