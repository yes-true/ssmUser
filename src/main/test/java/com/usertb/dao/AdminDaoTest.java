package com.usertb.dao;

import com.usertb.dao.AdminDao;
import com.usertb.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class AdminDaoTest {

	@Resource
	private AdminDao adminDao;

	@Test
	public void getAdmin(){
		Admin admin = adminDao.getAdminById(1);
		System.out.println("admin = " + admin.toString());
	}

	@Test
	public void getAdmin2(){
		Admin admin = new Admin();
		admin.setEmail("1223@qq.com");
		admin.setPhone("14725836900");
		Integer i = adminDao.queryAdminByPhoneOrEmailAndPassword(admin);
		System.out.println("i = " + i);
	}
}
