package action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
public class UserAction extends ActionSupport implements SessionAware,RequestAware{
	private static final long serialVersionUID = 1L;
	private String uname;
	private String upass;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private ArrayList<String> allUsers;
	private String isResult;
	UserDao ud = new UserDao();
	/**
	 * 检查用户名是否可用
	 */
	public String isUse() {
		try {
			if(ud.isExit(uname)){//用户名存在
				isResult = "no";
			}else{
				isResult = "ok";
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	/**
	 * 注册
	 */
	public String register(){
		try {
			if(ud.isRegist(uname, upass)){
				return SUCCESS;
			}else{
				return "register";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	/**
	 * 登录
	 */
	public String login(){
		try {
			if(ud.isLogin(uname, upass)){
				session.put("userName", uname);
				session.put("userPWD", upass);
				return SUCCESS;
			}
			request.put("errorMsg", "用户名或密码错误！");
			return "loginFail";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
	}
	/**
	 * 查询所有用户
	 */
	public String getAllUser(){
		try {
			allUsers = ud.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
	public String getIsResult() {
		return isResult;
	}
	public void setIsResult(String isResult) {
		this.isResult = isResult;
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		request = arg0;
	}
	public ArrayList<String> getAllUsers() {
		return allUsers;
	}
	public void setAllUsers(ArrayList<String> allUsers) {
		this.allUsers = allUsers;
	}
}
