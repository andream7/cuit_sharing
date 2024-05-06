package servlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UserCheck;
import dto.User;
@WebServlet(name = "loginCheckServlet", urlPatterns = { "/loginCheckServlet" })
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		User user = new User();// 实例化实体模型user
		user.setName(name);// 把数据存在模型user中
		user.setPwd(pwd);// 把数据存在模型user中
		UserCheck uc = new UserCheck();// 实例化业务模型userCheck
		if (uc.validate(user)) {
			// 把装有数据的实体模型user，存储到request范围内
			request.setAttribute("user", user);
			RequestDispatcher dis = request
					.getRequestDispatcher("loginSuccess.jsp");
			dis.forward(request, response);
		} else {
			response.sendRedirect("loginCheck.jsp");
		}
	}
}
