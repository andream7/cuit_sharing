package servlet.before;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BeforeUserService;
@WebServlet(name = "before_pay", urlPatterns = { "/before_pay" })
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ordersn = request.getParameter("ordersn");
		//ҵ���
		BeforeUserService bs = new BeforeUserService();
		if(bs.pay(ordersn)){
			PrintWriter out = response.getWriter();
			out.println("֧���ɹ���3���ӷ�����ҳ��");
			response.setHeader("refresh", "3; url=before_first?typeid=0");
			return;
		}else{
			request.getRequestDispatcher("beforeUser/operateerror.jsp").forward(request, response);
		}
	}
}
