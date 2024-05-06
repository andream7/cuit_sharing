package servlet.before;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.BeforeUserService;
import dto.UserDTO;
@WebServlet(name = "before_userCenter", urlPatterns = { "/before_userCenter" })
public class UserCenterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		HttpSession session = request.getSession(true);
		int bid = ((UserDTO)session.getAttribute("user")).getId();
		//ҵ���
		BeforeUserService bs = new BeforeUserService();
		if("index".equals(act)){//�û�������ҳ
			//�ҵĶ���
			List<Map<String, Object>> myOrder = bs.myOrder(bid);
			//�ҵĹ�ע
			List<Map<String, Object>> myFocus = bs.myFocus(bid);
			request.setAttribute("myOrder", myOrder);
			request.setAttribute("myFocus", myFocus);
			request.getRequestDispatcher("beforeUser/userCenter.jsp").forward(request, response);
		}else if("detail".equals(act)){
			//��������
			String ordersn = request.getParameter("ordersn");
			List<Map<String, Object>> myOrderDetail = bs.myOrderDetail(ordersn);
			request.setAttribute("myOrderDetail", myOrderDetail);
			request.getRequestDispatcher("beforeUser/userOrderDetail.jsp").forward(request, response);
		}
	}
}
