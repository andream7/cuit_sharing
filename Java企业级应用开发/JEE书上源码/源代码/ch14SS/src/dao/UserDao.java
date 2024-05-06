package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class UserDao extends BaseDao{
	/**
	 * 判断用户名是否存在
	 * @throws Exception 
	 */
	public boolean isExit(String uname) throws Exception{
		boolean b = false;//用户名不存在
		Connection con = getConnection();
		String sql = "select * from usertable where uname=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, uname);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){//用户名存在
			b = true;
		}
		close(rs, ps, con);
		return b;
	}
	/**
	 * 注册
	 * @throws Exception 
	 */
	public boolean isRegist(String uname, String upass) throws Exception{
		boolean b = false;
		Connection con = getConnection();
		String sql = "insert into usertable values(?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, uname);
		ps.setString(2, upass);
		int i = ps.executeUpdate();
		if(i > 0){//注册成功
			b = true;
		}
		close(null, ps, con);
		return b;
	}
	/**
	 * 登录
	 * @throws Exception 
	 */
	public boolean isLogin(String uname, String upass) throws Exception{
		boolean b = false;//用户名不存在
		Connection con = getConnection();
		String sql = "select * from usertable where uname=? and upwd=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, uname);
		ps.setString(2, upass);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){//登录成功
			b = true;
		}
		close(rs, ps, con);
		return b;
	}
	/**
	 * 查询所有用户
	 */
	public ArrayList<String> getAllUsers() throws Exception{
		Connection con = getConnection();
		String sql = "select * from usertable ";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<String> allUser = new ArrayList<String>();
		while(rs.next()){//登录成功
			allUser.add(rs.getString(1));
		}
		close(rs, ps, con);
		return allUser;
	}
}
