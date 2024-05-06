package com.service;

import org.springframework.ui.Model;

public interface UserService {
	public String isUse(String uname);
	public String regist(String uname, String upass);
	public String login(Model model, String uname, String upass);
}
