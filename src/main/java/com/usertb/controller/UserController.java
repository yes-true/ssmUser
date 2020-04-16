package com.usertb.controller;

import com.usertb.entity.Datum;
import com.usertb.entity.Param;
import com.usertb.entity.Site;
import com.usertb.entity.User;
import com.usertb.service.SiteService;
import com.usertb.service.UserService;
import com.usertb.utility.randomString;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

	@Resource
	private UserService userService;

	@Resource
	private User user;

	@Resource
	private Datum datum;

	/**
	 * 验证用户登录
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/ulogin", method = RequestMethod.POST)
	@ResponseBody
	public Map userLogin(/*@RequestParam("userid") String userid,
			@RequestParam("password") String password,*/
			@RequestBody Map<String,String> map){
		/*System.out.println("登录controller");
		System.out.println("userid = " + userid);
		System.out.println("password = " + password);
		user.setPhone(userid);
		user.setEmail(userid);
		user.setPassword(password);*/
		for (String key: map.keySet()) {
			if ("userid".equals(key)){
				user.setEmail(map.get(key));
				user.setPhone(map.get(key));
			}
			if ("password".equals(key)){
				user.setPassword(map.get(key));
			}

		}

		Integer key = userService.LogInUser(user);

		if (key == -1){
			map.put("key","-1");
			return map;
		}
		//User userLog = userService.getUserById(key);
		map.put("key",""+key);
		return map;
	}

	/**
	 * 判断数据库中是否存在相同的menbername、Email、Phone
	 * @param userR
	 * @return
	 */
	@RequestMapping(value = "/uJudge", method = RequestMethod.POST)
	@ResponseBody
	public Map userJudgeIsExist(@RequestBody User userR){
		boolean key = userService.getUserByPhoneOrEmailOrmenbername(userR);
		Map<String,String> map = new HashMap<String, String>();
		if (!key){
			map.put("error","-1");
			return map;
		}
		map.put("ok","0");
		return map;
	}

	/**
	 * user修改信息
	 * 判断数据库中是否存在相同的menbername、Email、Phone
	 * @param userR
	 * @return
	 */
	@RequestMapping(value = "/userUpdateJudge", method = RequestMethod.POST)
	@ResponseBody
	public Map userUpdateJudgeIsExist(@RequestBody User userR){

		boolean key = userService.getUserByPhoneOrEmailOrmenbername(userR);
		User userById = userService.getUserById(userR.getId());
		Map<String,Integer> map = new HashMap<String, Integer>();

		if (!key){
			if (userById.getEmail().equals(userR.getEmail())){
				map.put("ok",0);
				return map;
			}
			if (userR.getPhone() != null ){
				if (userR.getPhone().equals(userById.getPhone())){
					map.put("ok",0);
					return map;
				}
			}
			map.put("error",-1);
			return map;
		}

		map.put("ok",0);
		return map;
	}

	/**
	 * 用户注册
	 * @param userR
	 * @return
	 */
	@RequestMapping(value = "/uReg", method = RequestMethod.POST)
	@ResponseBody
	public Map userReg(@RequestBody User userR){

		Map<String,Integer> map = new HashMap<String, Integer>();
		//long watime = Long.parseLong(atime);
		//long wutime = Long.parseLong(utime);
		//userR.setAtime(new Timestamp(watime));
		//userR.setUtime(new Timestamp(wutime));
		userService.saveUser(userR);
		User uLoginOK = new User();
		uLoginOK.setEmail(userR.getEmail());
		uLoginOK.setPassword(userR.getPassword());
		Integer uid = userService.LogInUser(uLoginOK);
		map.put("uid",uid);
		return map;
	}

	/**
	 * 获取用户id，跳转
	 * @param id
	 * @param model
	 * @return 用户信息
	 */
	@RequestMapping(value = "/udatum")
	public String uDatum(@RequestParam("userid") Integer id,Model model){
		user = userService.getUserById(id);
		//Map<String,User> map = new HashMap<String, User>();
		//map.put("user",user);
		model.addAttribute("user",user);
		return "user/userDatum";
	}

	/**
	 * 用户修改信息
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public Map updateUser(@RequestBody Param param){
		user = param.getUser();
		datum = param.getDatum();
		user.setDatum(datum);
		Integer integer = userService.updateUser(user);
		Map<String,String> map = new HashMap<String, String>();
		if (integer == null){
			 map.put("error","-1");
			 return map;
		}
		map.put("error","0");
		return map;
	}

	@Resource
	private SiteService siteService;

	/**
	 * 删除收货地址
	 * @param id
	 * @param uid
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/deleteSite")
	public String deleteSite(@RequestParam("id") Integer id,@RequestParam("uid") Integer uid,Map<String,Integer> map){
		int i = siteService.deleteSite(id);
		map.put("uid",uid);
		return "redirect:/site";
	}

	@NotNull
	private Map getMap(int i) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		if (i == 0){
			map.put("error",-1);
			return map;
		}
		map.put("error",0);
		return map;
	}

	/**
	 * 保存收货地址
	 * @param site
	 * @return
	 */
	@RequestMapping(value = "/saveSite")
	@ResponseBody
	public Map saveSite(@RequestBody Site site){
		int i = siteService.saveSite(site);
		return getMap(i);
	}

}
