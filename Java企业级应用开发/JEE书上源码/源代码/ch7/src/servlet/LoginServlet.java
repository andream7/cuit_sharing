package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("user");
		if (null == name || name.trim().length() == 0) {
			response.sendRedirect("login.jsp");
		}else{
			out.println("<htm><head><title>第二个页面</title></head><body>");
			out.println("<form action='greet' " + "method='post'>");
			out.println("<input type='hidden' name='user' value=" + name +">");//隐藏表单域
			out.println(name + "<br>");
			out.println("<input type='submit' value='转向下一个页面看一看' >");
			out.println("</form>");
			out.println("</body></htm>");
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
