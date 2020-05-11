package com.usertb.dao;

import com.usertb.dao.DatumDao;
import com.usertb.entity.Datum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class DatumDaoTest {

	@Resource
	private DatumDao datumDao;
	
	@Test
	public void getDatum(){
		Datum datum = datumDao.getDatumByUid(2);
		System.out.println("datum.toString() = " + datum.toString());
	}

	@Test
	public void updatePhoto(){
		datumDao.updatePhoto("123546456", 1);
	}
}
