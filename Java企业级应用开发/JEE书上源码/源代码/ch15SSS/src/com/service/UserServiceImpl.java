package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.UserDao;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	/**
	 * 检查用户是否可用
	 */
	@Override
	public String isUse(String uname) {
		List<Map<String, Object>> allU = userDao.isUse(uname);
		if(allU.size() > 0) {
			return "no";
		}
		return "ok";
	}
	@Override
	public String regist(String uname, String upass) {
		if(userDao.regist(uname, upass)) {
			return "login";
		}
		return "register";
	}
	@Override
	public String login(Model model, String uname, String upass) {
		if(userDao.login(uname, upass).size() > 0) {
			model.addAttribute("allUsers", userDao.selectAll());
			return "main";
		}
		model.addAttribute("errorMsg", "用户名密码错误！");
		return "login";
	}

}
