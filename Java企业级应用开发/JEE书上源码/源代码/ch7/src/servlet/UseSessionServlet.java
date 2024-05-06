package servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(name = "useSession", urlPatterns = { "/sendMyName" })
public class UseSessionServlet extends HttpServlet {
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
			response.sendRedirect(response.encodeRedirectURL("useSession.jsp"));
		} else {
			HttpSession session = request.getSession(true);
			session.setAttribute("myName", name);
			out.println("<htm><body>");
			out.println("您请求的servlet对象是：" + getServletName());
			out.println("<br>您的会话ID是：" + session.getId());
			out.println("<br>请单击请求另一个servlet：");
			out.println("<br><a href=" + response.encodeURL("showMyName") + ">请求另一个servlet</a>");
			out.println("</body></htm>");
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
