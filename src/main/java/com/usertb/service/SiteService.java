package com.usertb.service;

import com.usertb.entity.Site;

public interface SiteService {

	/**
	 * 删除用户收货地址
	 * @param id
	 * @return
	 */
	int deleteSite(Integer id);

	/**
	 * 添加用户收货地址
	 * @param site
	 * @return
	 */
	int saveSite(Site site);
}
