package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository("userDao")
public class UserDao extends BaseDao{
	public List<Map<String, Object>> isUse(String uname){
		String sql = "select * from usertable where uname = ?";
		String param[] = {uname};
		return findByParam(sql, param);
	}
	public boolean regist(String uname, String upass) {
		String sql = "insert into usertable values(?,?)";
		String param[] = {uname, upass};
		return updateByParam(sql, param);
	}
	public List<Map<String, Object>> login(String uname, String upass) {
		String sql = "select * from usertable where uname = ? and upwd = ?";
		String param[] = {uname, upass};
		return findByParam(sql, param);
	}
	public List<Map<String, Object>> selectAll() {
		String sql = "select * from usertable";
		return findByParam(sql, null);
	}
}
