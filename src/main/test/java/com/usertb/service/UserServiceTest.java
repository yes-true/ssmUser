package com.usertb.service;

import com.usertb.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserServiceTest {

	@Resource
	private UserService userService;

	@Autowired
	private User user;

	@Test
	public void saveUser(){

		String menbername = "hhjj1472588";
		String password = "123456";
		String phone = "14523652001";
		String email = "1452@qq.com";
		Timestamp atime = new Timestamp(new Date().getTime());
		Timestamp utime = new Timestamp(new Date().getTime());
		User user = new User(2,menbername,password,phone,email,atime,utime);

		String s = userService.saveUser(user);
		System.out.println(s);
	}

	@Test
	public void getUserById(){
		User user = userService.getUserById(1);
		System.out.println("user = " + user);
	}

	@Test
	public void getUser(){
		String menbername = "hhjj1472288";
		String password = "123456";
		String phone = "14523652101";
		String email = "1451@qq.com";
		user.setMenbername(menbername);
		user.setEmail(email);
		boolean b = userService.getUserByPhoneOrEmailOrmenbername(user);
		if (b == true){
			System.out.println("不存在");
		}else{
			System.out.println("存在");
		}

	}

}
