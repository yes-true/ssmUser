package com.usertb.service.impl;

import com.usertb.dao.DatumDao;
import com.usertb.dao.RightcontrolDao;
import com.usertb.dao.UserDao;
import com.usertb.entity.Datum;
import com.usertb.entity.User;
import com.usertb.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Resource
	private RightcontrolDao rightcontrolDao;

	//@Resource
	//private Datum datum;

	@Resource
	private DatumDao datumDao;

	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}

	public String saveUser(User user) {
		int ui = userDao.saveUser(user);
		Integer uid = userDao.getUserByPhoneOrEmailOrmenbername(user);
		//datum.setUid(uid);
		user.setDatum(new Datum());
		user.getDatum().setUid(uid);
		//判断用电话是否为空，若不为空则同时为用户资料添加电话
		if (user.getPhone() != null){
			user.getDatum().setPhone(user.getPhone());
		}
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("uid",uid);

		int ri = rightcontrolDao.saveRigUserOrAdmin(map);
		int di = datumDao.saveDatum(user.getDatum());
		return "添加" + ui + "个用户\t" +
				"并成功赋予" + ri + "个用户权限\t" +
				"添加资料" + di;
	}

	public boolean getUserByPhoneOrEmailOrmenbername(User user) {

		Integer i = userDao.getUserByPhoneOrEmailOrmenbername(user);
		if(i == null){
			return true;
		}
		return false;
	}

	public Integer LogInUser(User user) {
		String phone = user.getPhone();
		String email = user.getEmail();
		String password = user.getPassword();
		Integer key = userDao.getUserByPhoneOrEmailOrmenbername(user);
		//判断用户是否存在
		if (key != null) {
			String jdbcpassword = userDao.getUserById(key).getPassword();
			//对比密码是否正确
			if (password.equals(jdbcpassword)){
				return key;
			}
		}
		return -1;
	}

	public Integer updateUser(User user) {
		User userById = userDao.getUserById(user.getId());
		userById.setUtime(user.getUtime());
		if (user.getEmail() != null){
			userById.setEmail(user.getEmail());
		}
		if (user.getPhone() != null){
			userById.setPhone(user.getPhone());
			userById.getDatum().setPhone(user.getPhone());
		}
		if (user.getPassword() != null){
			userById.setPassword(user.getPassword());
		}
		if (user.getDatum().getName() != null){
			userById.getDatum().setName(user.getDatum().getName());
		}
		if (user.getDatum().getGender() != null){
			userById.getDatum().setGender(user.getDatum().getGender());
		}
		if (user.getDatum().getBirthday() != null){
			userById.getDatum().setBirthday(user.getDatum().getBirthday());
		}
		return userDao.updateUser(userById)+datumDao.updateDatum(userById.getDatum());
	}

	public Integer updatePhoto(String photo,int id) {
		return datumDao.updatePhoto(photo,id);
	}

	public List<User> listPageUsers(int currentPage, int pageSize) {
		return userDao.listUser(currentPage, pageSize);
	}

	public int getUsers() {
		return userDao.getUsers();
	}

}
