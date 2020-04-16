package com.usertb.dao;

import com.usertb.dao.RightcontrolDao;
import com.usertb.entity.Rightcontrol;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class RigDaoTest {

	@Resource
	private RightcontrolDao rightcontrolDao;

	@Test
	public void getRig(){
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("uid",1);
		Rightcontrol rig = rightcontrolDao.getRigByUidOrAid(map);
		System.out.println("rig = " + rig.toString() + "hascode:" + rig.hashCode());
	}
}
