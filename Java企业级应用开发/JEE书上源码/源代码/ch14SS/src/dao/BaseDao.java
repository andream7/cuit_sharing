package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
public class BaseDao {
	// list连接池
	static ArrayList<Connection> list = new ArrayList<Connection>();
	/**
	 * 从连接池中获得一个连接
	 */
	public synchronized static Connection getConnection() throws Exception{
		Connection con = null;
		// 如果连接池有连接
		if (list.size() > 0) {
			return list.remove(0);
		}
		// 连接池中没有连接
		else {
			Properties p = new Properties();
			//加载配置文件
			p.load(BaseDao.class.getClassLoader().getResourceAsStream("dao/jdbc.properties"));
			String driverClass = p.getProperty("jdbc.driverClass");
			String jdbcUrl = p.getProperty("jdbc.jdbcUrl");
			String username = p.getProperty("jdbc.username");
			String password = p.getProperty("jdbc.password");
			//加载驱动
			Class.forName(driverClass);
			// 和指定的数据库建立连接
			for (int i = 0; i < 10; i++) {
				con = DriverManager.getConnection(jdbcUrl, username,password);
				list.add(con);
			}
		}
		return list.remove(0);
	}
	/**
	 * 关闭结果集
	 * @param rs代表结果集
	 */
	public static void close(ResultSet rs) throws Exception{
		if (rs != null) 
			rs.close();
	}
	/**
	 * 关闭预处理对象
	 * @param pst代表预处理
	 */
	public static void close(PreparedStatement pst) throws Exception{
		if (pst != null) 
			pst.close();	
	}
	/**
	 * 关闭连接对象
	 * @param con代表连接对象
	 */
	public synchronized static void close(Connection con) {
		if (con != null)
			list.add(con);
	}
	/**
	 * 关闭结果集，预处理，连接等对象
	 * @param rs 结果集
	 * @param ps 预处理
	 * @param con 连接
	 */
	public static void close(ResultSet rs, PreparedStatement ps, Connection con) throws Exception{
		close(rs);
		close(ps);
		close(con);
	}
}
