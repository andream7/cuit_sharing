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
	 * ��֤�û����Ƿ����
	 */
	@RequestMapping("/isUse")
	@ResponseBody
	public String isUse(@RequestBody String uname) {
		//����JSON�ַ���
		return userService.isUse(uname);
	}
	/**
	 * ʵ��ע�Ṧ��
	 */
	@RequestMapping("/regist")
	public String regist(String uname, String upass) {
		return userService.regist(uname, upass);
	}
	/**
	 * ʵ�ֵ�¼����
	 */
	@RequestMapping("/login")
	public String login(Model model, String uname, String upass) {
		return userService.login(model, uname, upass);
	}
}
