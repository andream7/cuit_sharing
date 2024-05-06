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
import dto.UserDTO;
import service.BeforeUserService;
@WebServlet(name="before_selectCart", urlPatterns = { "/before_selectCart" })
public class SelectCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//业务层
		BeforeUserService bs = new BeforeUserService();
		HttpSession session = request.getSession(true);
		int bid = ((UserDTO)session.getAttribute("user")).getId();
		List<Map<String, Object>> list = bs.selectCart(bid);
		double sum = 0;
		for (Map<String, Object> map : list) {
			sum = sum + (Double)map.get("smallsum");
		}
		request.setAttribute("total", sum);
		request.setAttribute("cartlist", list);
		String act = request.getParameter("act");
		//购物确认
		if("confirm".equals(act)){
			request.getRequestDispatcher("beforeUser/orderconfirm.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("beforeUser/cart.jsp").forward(request, response);
		}
	}
}
