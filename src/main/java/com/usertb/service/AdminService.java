package com.usertb.service;

import com.usertb.entity.Admin;

public interface AdminService {

	/**
	 * 判断是否存在该管理员
	 * @param admin
	 * @return
	 */
	boolean adminJudge(Admin admin);
}
