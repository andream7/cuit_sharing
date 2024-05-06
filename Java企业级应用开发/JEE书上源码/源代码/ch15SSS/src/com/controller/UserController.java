package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * 验证用户名是否可以
	 */
	@RequestMapping("/isUse")
	@ResponseBody
	public String isUse(@RequestBody String uname) {
		//返回JSON字符串
		return userService.isUse(uname);
	}
	/**
	 * 实现注册功能
	 */
	@RequestMapping("/regist")
	public String regist(String uname, String upass) {
		return userService.regist(uname, upass);
	}
	/**
	 * 实现登录功能
	 */
	@RequestMapping("/login")
	public String login(Model model, String uname, String upass) {
		return userService.login(model, uname, upass);
	}
}
