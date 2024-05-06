package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
public class BaseDao {
	// list���ӳ�
	static ArrayList<Connection> list = new ArrayList<Connection>();
	/**
	 * �����ӳ��л��һ������
	 */
	public synchronized static Connection getConnection() throws Exception{
		Connection con = null;
		// ������ӳ�������
		if (list.size() > 0) {
			return list.remove(0);
		}
		// ���ӳ���û������
		else {
			Properties p = new Properties();
			//���������ļ�
			p.load(BaseDao.class.getClassLoader().getResourceAsStream("dao/jdbc.properties"));
			String driverClass = p.getProperty("jdbc.driverClass");
			String jdbcUrl = p.getProperty("jdbc.jdbcUrl");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");
			//��������
			Class.forName(driverClass);
			// ��ָ�������ݿ⽨������
			for (int i = 0; i < 10; i++) {
				con = DriverManager.getConnection(jdbcUrl, username,password);
				list.add(con);
			}
		}
		return list.remove(0);
	}
	/**
	 * �رս����
	 * @param rs��������
	 */
	public static void close(ResultSet rs) throws Exception{
		if (rs != null) 
			rs.close();
	}
	/**
	 * �ر�Ԥ�������
	 * @param pst����Ԥ����
	 */
	public static void close(PreparedStatement pst) throws Exception{
		if (pst != null) 
			pst.close();	
	}
	/**
	 * �ر����Ӷ���
	 * @param con�������Ӷ���
	 */
	public synchronized static void close(Connection con) {
		if (con != null)
			list.add(con);
	}
	/**
	 * �رս������Ԥ�������ӵȶ���
	 * @param rs �����
	 * @param ps Ԥ����
	 * @param con ����
	 */
	public static void close(ResultSet rs, PreparedStatement ps, Connection con) throws Exception{
		close(rs);
		close(ps);
		close(con);
	}
}
