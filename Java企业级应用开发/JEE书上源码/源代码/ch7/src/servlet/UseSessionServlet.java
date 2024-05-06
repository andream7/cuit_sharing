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
			out.println("�������servlet�����ǣ�" + getServletName());
			out.println("<br>���ĻỰID�ǣ�" + session.getId());
			out.println("<br>�뵥��������һ��servlet��");
			out.println("<br><a href=" + response.encodeURL("showMyName") + ">������һ��servlet</a>");
			out.println("</body></htm>");
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
