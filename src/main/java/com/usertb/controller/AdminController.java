package com.usertb.controller;

import com.usertb.entity.Admin;
import com.usertb.entity.Page;
import com.usertb.entity.User;
import com.usertb.service.AdminService;
import com.usertb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
			return map;
		}
		map.put("error",-1);
		return map;
	}

	/**
	 * 管理员首页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/userList")
	public String adminHome(Model model,
	                        @RequestParam(value = "cp",defaultValue = "0") int currentPage,
	                        @RequestParam(value = "ps",defaultValue = "5") int pageSize){
		Page page = new Page();
		page.setTotalUsers(userService.getUsers());
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);
		List<User> users = userService.listPageUsers(currentPage*pageSize,pageSize);
		page.setUsers(users);
		model.addAttribute("users",page);
		return "admin/adminHome";
	}
}
