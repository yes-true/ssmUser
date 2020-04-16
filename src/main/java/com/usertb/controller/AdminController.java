package com.usertb.controller;

import com.usertb.entity.Admin;
import com.usertb.entity.Page;
import com.usertb.entity.User;
import com.usertb.service.AdminService;
import com.usertb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

	@Resource
	private AdminService adminService;

	@Resource
	private UserService userService;

	/**
	 * 判断该管理员是否输入正确
	 * @param admin
	 * @return
	 */
	@RequestMapping(value = "/aLogin")
	@ResponseBody
	public Map adminLogin(@RequestBody Admin admin){
		Map<String,Integer> map = new HashMap<String, Integer>();
		boolean b = adminService.adminJudge(admin);
		if (b){
			map.put("error",0);
			return map;//2222
		}
		map.put("error",-1);
		return map;
	}

	@RequestMapping(value = "/userList")
	public String adminHone(Model model){
		Page page = new Page();
		page.setCurrentPage(0);
		page.setPageSize(5);
		page.setTotalUsers(userService.getUsers());
		List<User> users = userService.listPageUsers(page);
		page.setUsers(users);
		model.addAttribute("users",page);
		return "admin/adminHome";
	}
}
