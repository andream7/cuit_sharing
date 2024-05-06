package bean;
import java.sql.*;
import java.util.ArrayList;
public class ConnectionPool {
	// 存放Connection对象的数组，数组被看成连接池
	ArrayList<Connection> list = new ArrayList<Connection>();
	// 构造方法，创建15个连接对象，放到连接池中
	public ConnectionPool() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 15; i++) {
			try {
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8","root","root");
				list.add(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	// 从连接池中取出一个连接对象
	public synchronized Connection getOneCon() {
		if (list.size() > 0) {
			// 删除数组的第一个元素，并返回该元素中的连接对象
			return list.remove(0);
		} else {
			// 连接对象被用完
			return null;
		}
	}
	// 把连接对象放回连接池中
	public synchronized void releaseCon(Connection con) {
		list.add(con);
	}
}
