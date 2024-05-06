package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		String username = request.getParameter("username"); // ��ȡ��������е��û���
		// ��session���������,�ᴥ��HttpSessionAttributeListener�е�attributeAdded����
		if (username != null && !username.equals("")) {
			request.getSession().setAttribute(username, username);
		}
		// ��Ӧ���������л�ȡ�����û����б�
		List<String> online = (List<String>) getServletContext().getAttribute("online");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("");
		out.println("  <title>�û��б�</title>");
		out.println("  ");
		out.println("��ǰ�û��ǣ�" + username);
		out.print("    <hr><h3>�����û��б�</h3>");
		int size = online == null ? 0 : online.size();
		for (int i = 0; i < size; i++) {
			if (i > 0) {
				out.println("<br>");
			}
			out.println(i + 1 + "." + online.get(i));
		}
		// ע��: Ҫ������URL�����Զ���д����
		out.println("<hr/><a href=\"" + response.encodeURL("logoutServlet?id=" + username) + "\">ע��</a>");
		out.println("  ");
		out.println("");
		out.flush();
		out.close();
	}
}
