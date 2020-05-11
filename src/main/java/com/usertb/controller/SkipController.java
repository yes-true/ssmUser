package com.usertb.controller;

import com.usertb.service.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class SkipController {

	@Resource
	private UserService userService;

	/**
	 * 跳转用户登录
	 * @return
	 */
	@RequestMapping(value = "/userLogin")
	public String jumIndex(){
		return "user/userLogin";
	}

	/**
	 * 跳转用户注册
	 * @return
	 */
	@RequestMapping(value = "/userReg")
	public String jumUserReg(){
		return "user/userReg";
	}

	/**
	 * 跳转用户首页
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateUserDatum")
	public String jumUpdateUser(@RequestParam("uid") Integer id, Model model){
		model.addAttribute("user",userService.getUserById(id));
		return "user/userUpdate";
	}

	/**
	 * 跳转用户修改头像
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateUserPhoto")
	public String jumUpdateUserPhoto(@RequestParam("uid") Integer id, Model model){
		model.addAttribute("user",userService.getUserById(id));
		return "user/upPhoto";
	}

	/**
	 * 跳转用户资料页
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/site")
	public String jumUpdateUserStie(@RequestParam("uid") Integer id, Model model){
		model.addAttribute("user",userService.getUserById(id));
		return "user/site";
	}

	/**
	 * 管理员登录页面
	 * @return
	 */
	@RequestMapping(value = "/adminLogin")
	public String adminLogin(){
		return "admin/adminLogin";
	}
}
