package com.usertb.service;

import com.usertb.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class AdminServiceTest {

	@Resource
	private AdminService adminService;

	@Test
	public void getAdmin(){
		Admin admin = new Admin();
		admin.setEmail("1232@qq.com");
		admin.setPhone("147258369002");
		admin.setPassWord("123456");
		boolean b = adminService.adminJudge(admin);
		System.out.println("b = " + b);
	}

}
