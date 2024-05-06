package servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Goods;
@WebServlet("/MoveSelectServlet")
public class MoveSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		Statement st = null;
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
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			//���Ͳ�ѯSQL��䣬���ؽ����
			rs = st.executeQuery("select * from goods ");
			// ���α��ƶ������һ�У�
			rs.last();
			// ��ȡ���һ�е��кţ�
			int lownumber = rs.getRow();
			//�浽request�����Ա���ҳ��showMoveGoods.jsp����ʾ
			request.setAttribute("lownumber", lownumber);
			//����ѯ���װ������ArrayList<Goods>��
			allGoods = new ArrayList<Goods>();
			// Ϊ�����������¼���轫�α��ƶ������һ��֮��
			rs.afterLast();
			while (rs.previous()) {
				int i = rs.getRow();
				if (i % 2 == 0) {
					Goods g = new Goods();
					g.setRowno(i);
					g.setId(rs.getInt(1));
					g.setGname(rs.getString(2));
					g.setGprice(rs.getDouble(3));
					allGoods.add(g);
				}
			}  
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//�浽request�����Ա���ҳ��showMoveGoods.jsp����ʾ
		request.setAttribute("allGoods", allGoods);
		//��ת��showAllGoods.jsp��ʾ��Ʒ
		RequestDispatcher dis = request.getRequestDispatcher("showMoveGoods.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
