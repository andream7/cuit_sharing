package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//建议urlPatterns的值和类名一样，方便维护。可使用@WebServlet("/secondServlet")简化注解。
@WebServlet(name = "secondServlet", urlPatterns = { "/secondServlet" }) 
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应的内容类型
		response.setContentType("text/html;charset=utf-8");
		//取得输出对象
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		//在浏览器中显示：第二个Servlet类
		out.println("第二个Servlet类");
		out.println("</body></html>");
	}
}
