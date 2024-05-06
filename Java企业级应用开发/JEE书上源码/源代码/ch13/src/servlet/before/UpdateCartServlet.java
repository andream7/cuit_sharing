package servlet.before;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserDTO;
import service.BeforeUserService;
@WebServlet("/before_updateCart")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shoppingnum = request.getParameter("shoppingnum");
		String gno = request.getParameter("gno");
		HttpSession session = request.getSession(true);
		int bid = ((UserDTO)session.getAttribute("user")).getId();
		//ÒµÎñ²ã
		BeforeUserService bs = new BeforeUserService();
		RequestDispatcher rds = null;
		if(bs.updateCart(shoppingnum,gno, bid)){
			rds = request.getRequestDispatcher("before_selectCart");
		}else{
			rds = request.getRequestDispatcher("beforeUser/operateerror.jsp");
		}
		rds.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
