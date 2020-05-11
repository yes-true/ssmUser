package com.usertb.service.impl;

import com.usertb.dao.SiteDao;
import com.usertb.entity.Site;
import com.usertb.service.SiteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("siteService")
@Transactional(rollbackFor = Exception.class)
public class SiteServiceImpl implements SiteService {

	@Resource
	private SiteDao siteDao;

	public int deleteSite(Integer id) {
		return siteDao.deleteSite(id);
	}

	public int saveSite(Site site) {
		return siteDao.saveSite(site);
	}
}
