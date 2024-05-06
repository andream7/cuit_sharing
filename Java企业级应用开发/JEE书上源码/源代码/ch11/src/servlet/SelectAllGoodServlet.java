package servlet;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Goods;
import util.GetAllGoods;
@WebServlet("/selectAllGoodServlet")
public class SelectAllGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//将查询结果装到集合ArrayList<Goods>中，并返回页面显示
		ArrayList<Goods> allGoods = GetAllGoods.getAllGoods();
		//存到request对象，以便在页面showAllGoods.jsp中显示
		request.setAttribute("allGoods", allGoods);
		//跳转到showExportGoods.jsp显示商品
		RequestDispatcher dis = request.getRequestDispatcher("showExportGoods.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
