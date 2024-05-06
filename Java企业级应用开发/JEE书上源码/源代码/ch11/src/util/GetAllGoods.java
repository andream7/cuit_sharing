package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Goods;
public class GetAllGoods {
	public static ArrayList<Goods> getAllGoods(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//����ѯ���װ������ArrayList<Goods>�У�������ҳ����ʾ
		ArrayList<Goods> allGoods = null;
		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//��������
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8","root","root");
			//Ԥ����
			ps = con.prepareStatement("select * from goods ");
			//���Ͳ�ѯSQL��䣬���ؽ����
			rs = ps.executeQuery();
			//����ѯ���װ������ArrayList<Goods>��
			allGoods = new ArrayList<Goods>();
			while(rs.next()){
				Goods g = new Goods();
				g.setId(rs.getInt(1));
				g.setGname(rs.getString(2));
				g.setGprice(rs.getDouble(3));
				allGoods.add(g);
			}  
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allGoods;
	}
}
