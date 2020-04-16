package com.usertb.service.impl;

import com.usertb.dao.AdminDao;
import com.usertb.entity.Admin;
import com.usertb.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

	@Resource
	private AdminDao adminDao;

	public boolean adminJudge(Admin admin) {
		Integer i = adminDao.queryAdminByPhoneOrEmailAndPassword(admin);

		if (i != null){
			Admin adminById = adminDao.getAdminById(i);
			//判断密码是否相同
			if (adminById.getPassWord().equals(admin.getPassWord())){
				return true;
			}
			return false;
		}

		return false;
	}
}
