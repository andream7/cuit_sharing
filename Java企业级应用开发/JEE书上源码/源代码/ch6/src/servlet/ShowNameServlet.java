package servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(name = "showMyName", urlPatterns = { "/showMyName" })
public class ShowNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
  
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		String name = (String) session.getAttribute("myName");
		if (null == name || name.trim().length() == 0) {
			response.sendRedirect(response.encodeRedirectURL("useSession.jsp"));
		}else{
			out.println("<htm><body>");
			out.println("您请求的servlet对象是：" + getServletName());
			out.println("<br>您的会话ID是：" + session.getId());
			out.println("<br>您的会话中存储的用户名是：" + name);
			out.println("<br><a href=" + response.encodeRedirectURL("useSession.jsp") + ">重新登录</a>");
			out.println("</body></htm>");
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
