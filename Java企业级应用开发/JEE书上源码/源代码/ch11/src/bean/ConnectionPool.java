package bean;
import java.sql.*;
import java.util.ArrayList;
public class ConnectionPool {
	// ���Connection��������飬���鱻�������ӳ�
	ArrayList<Connection> list = new ArrayList<Connection>();
	// ���췽��������15�����Ӷ��󣬷ŵ����ӳ���
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
	// �����ӳ���ȡ��һ�����Ӷ���
	public synchronized Connection getOneCon() {
		if (list.size() > 0) {
			// ɾ������ĵ�һ��Ԫ�أ������ظ�Ԫ���е����Ӷ���
			return list.remove(0);
		} else {
			// ���Ӷ�������
			return null;
		}
	}
	// �����Ӷ���Ż����ӳ���
	public synchronized void releaseCon(Connection con) {
		list.add(con);
	}
}
