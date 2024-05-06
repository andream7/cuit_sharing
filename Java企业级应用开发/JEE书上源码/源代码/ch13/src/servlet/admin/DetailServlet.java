package servlet.admin;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.AdminService;
@WebServlet("/admin_detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//获得商品编号
	String gno = request.getParameter("gno");
	AdminService as = new AdminService();
	List<Map<String, Object>> list = as.selectAGoods(gno);
	//把一个商品详细信息存到request中
	request.setAttribute("agoods", list.get(0));
	RequestDispatcher rds = null;
	//详情页面
	if("detail".equals(request.getParameter("act"))){
		rds = request.getRequestDispatcher("admin/detail.jsp");
	}
	//修改一个商品页面
	else if("updateAgoods".equals(request.getParameter("act"))){
		rds = request.getRequestDispatcher("admin/updateAgoods.jsp");
	}
	rds.forward(request, response);
	}
}
