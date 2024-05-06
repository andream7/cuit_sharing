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
@WebServlet("/selectGoodsServlet")
public class SelectGoodsServlet extends HttpServlet {
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
			st = con.createStatement();
			request.setCharacterEncoding("utf-8");
			String gname = request.getParameter("gname");
			String gprice = request.getParameter("gprice");
			String sql = "select * from goods where 1=1 ";
			if(gname != null && gname.length() > 0) {
				sql = sql + " and gname like '%" + gname + "%'";
			}
			if(gprice != null && gprice.length() > 0) {
				sql = sql + " and gprice>" + gprice;
			}
			//���Ͳ�ѯSQL��䣬���ؽ����
			rs = st.executeQuery(sql);
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
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//�浽request�����Ա���ҳ��showGoods.jsp����ʾ
		request.setAttribute("allGoods", allGoods);
		//��ת��showAllGoods.jsp��ʾ��Ʒ
		RequestDispatcher dis = request.getRequestDispatcher("showGoods.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
