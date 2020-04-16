package com.usertb.service;

import com.usertb.dao.SiteDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class SiteServiceImplTest {

	@Resource
	private SiteDao siteDao;

	@Resource
	private SiteService siteService;

	@Test
	public void deleteSite(){
		int i = siteService.deleteSite(2);
		System.out.println("i = " + i);
	}

}
