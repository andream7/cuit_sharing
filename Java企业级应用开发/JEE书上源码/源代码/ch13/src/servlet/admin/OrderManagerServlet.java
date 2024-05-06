package servlet.admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.AdminService;
@WebServlet("/admin_orderManager")
public class OrderManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String act = request.getParameter("act");//获得动作类型
	AdminService as = new AdminService();
	PrintWriter out = response.getWriter();
	List<Map<String, Object>> list = as.selectOrders();
	request.setAttribute("orderList", list);
	RequestDispatcher rds = null;
	//查询
	if("manager".equals(act)){
		rds = request.getRequestDispatcher("admin/orderManager.jsp");
		rds.forward(request, response);
	}else if("delete".equals(act)){//删除
		String ordersn = request.getParameter("ordersn");
		if(as.deleteOrder(ordersn)){
			out.println("删除成功！3秒钟返回！");
		}else{
			out.println("删除失败！3秒钟返回！");
		}
		response.setHeader("refresh", "3; url=admin_orderManager?act=manager");
		return;
	}
	}
}
