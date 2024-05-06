package servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
@WebServlet("/selectGoodsByPageServlet")
public class SelectGoodsByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement ps = null;
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
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("select * from goods ");
			rs.last();//移到最后一行
			int totalCount = rs.getRow();//分页查询，数据总数
			int totalPage = 0;
			if (totalCount == 0) {
				totalPage = 0;//总页数
			} else {
				//返回大于或者等于指定表达式的最小整数
				totalPage = (int) Math.ceil((double) totalCount / 3);
			}
			String pageCur11 = request.getParameter("pageCur");//获得当前页码
			if (pageCur11 == null) {//首页面
				pageCur11 = "1";
			}
			int  pageCur = Integer.parseInt(pageCur11);
			if ((pageCur - 1) * 3 > totalCount) {
				pageCur = pageCur - 1;
			}
			int startIndex = (pageCur - 1) * 3;//起始位置
			int perPageSize = 3;//每页3个
			//预处理
			ps = con.prepareStatement("select * from goods limit ?, ?");
			ps.setInt(1, startIndex);
			ps.setInt(2, perPageSize);
			//发送查询SQL语句，返回结果集
			rs = ps.executeQuery();
			//将查询结果装到集合ArrayList<Goods>中
			allGoods = new ArrayList<Goods>();
			while(rs.next()){
				Goods g = new Goods();
				g.setId(rs.getInt(1));
				g.setGname(rs.getString(2));
				g.setGprice(rs.getDouble(3));
				allGoods.add(g);
			}  
			//存到request对象，以便在页面showAllGoods.jsp中显示
			request.setAttribute("allGoods", allGoods);
			request.setAttribute("totalCount", totalCount);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("pageCur", pageCur);
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//跳转到showAllGoods.jsp显示商品
		RequestDispatcher dis = request.getRequestDispatcher("showGoodsByPage.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
