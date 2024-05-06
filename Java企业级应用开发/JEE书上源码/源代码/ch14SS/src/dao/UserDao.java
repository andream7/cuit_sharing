package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class UserDao extends BaseDao{
	/**
	 * �ж��û����Ƿ����
	 * @throws Exception 
	 */
	public boolean isExit(String uname) throws Exception{
		boolean b = false;//�û���������
		Connection con = getConnection();
		String sql = "select * from usertable where uname=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, uname);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){//�û�������
			b = true;
		}
		close(rs, ps, con);
		return b;
	}
	/**
	 * ע��
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
		if(i > 0){//ע��ɹ�
			b = true;
		}
		close(null, ps, con);
		return b;
	}
	/**
	 * ��¼
	 * @throws Exception 
	 */
	public boolean isLogin(String uname, String upass) throws Exception{
		boolean b = false;//�û���������
		Connection con = getConnection();
		String sql = "select * from usertable where uname=? and upwd=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, uname);
		ps.setString(2, upass);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){//��¼�ɹ�
			b = true;
		}
		close(rs, ps, con);
		return b;
	}
	/**
	 * ��ѯ�����û�
	 */
	public ArrayList<String> getAllUsers() throws Exception{
		Connection con = getConnection();
		String sql = "select * from usertable ";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<String> allUser = new ArrayList<String>();
		while(rs.next()){//��¼�ɹ�
			allUser.add(rs.getString(1));
		}
		close(rs, ps, con);
		return allUser;
	}
}
