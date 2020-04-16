package com.usertb.dao;

import com.usertb.dao.SiteDao;
import com.usertb.entity.Site;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class SiteDaoTest {

	@Resource
	private SiteDao siteDao;

	@Test
	public void saveSite(){
		Site site = new Site(null,1,500556,"贵州省凯里市开发区XXX小区","14563698521", "某某某");
		siteDao.saveSite(site);
	}

	@Test
	public void updateSite(){
		Site site = new Site(2,500056,"贵州省凯里市开发区XXX小区","14563698521", "某某HHH某");
		siteDao.updateSite(site);

	}

	@Test
	public void delete(){
		siteDao.deleteSite(3);
	}

	@Test
	public void getSite(){
		List<Site> sites = siteDao.listSitesByUid(1);
		for (Site s : sites)
			System.out.println("s = " + s.toString());
	}

}
