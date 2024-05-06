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
	String act = request.getParameter("act");//��ö�������
	AdminService as = new AdminService();
	PrintWriter out = response.getWriter();
	List<Map<String, Object>> list = as.selectOrders();
	request.setAttribute("orderList", list);
	RequestDispatcher rds = null;
	//��ѯ
	if("manager".equals(act)){
		rds = request.getRequestDispatcher("admin/orderManager.jsp");
		rds.forward(request, response);
	}else if("delete".equals(act)){//ɾ��
		String ordersn = request.getParameter("ordersn");
		if(as.deleteOrder(ordersn)){
			out.println("ɾ���ɹ���3���ӷ��أ�");
		}else{
			out.println("ɾ��ʧ�ܣ�3���ӷ��أ�");
		}
		response.setHeader("refresh", "3; url=admin_orderManager?act=manager");
		return;
	}
	}
}
