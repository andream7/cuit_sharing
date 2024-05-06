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
		//将查询结果装到集合ArrayList<Goods>中，并返回页面显示
		ArrayList<Goods> allGoods = null;
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//建立连接
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8","root","root");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			//发送查询SQL语句，返回结果集
			rs = st.executeQuery("select * from goods ");
			// 将游标移动到最后一行：
			rs.last();
			// 获取最后一行的行号：
			int lownumber = rs.getRow();
			//存到request对象，以便在页面showMoveGoods.jsp中显示
			request.setAttribute("lownumber", lownumber);
			//将查询结果装到集合ArrayList<Goods>中
			allGoods = new ArrayList<Goods>();
			// 为了逆序输出记录，需将游标移动到最后一行之后：
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
		//存到request对象，以便在页面showMoveGoods.jsp中显示
		request.setAttribute("allGoods", allGoods);
		//跳转到showAllGoods.jsp显示商品
		RequestDispatcher dis = request.getRequestDispatcher("showMoveGoods.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
