package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Student;
@WebServlet("/TestjQueryAjaxServlet")
public class TestjQueryAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求和响应字符编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String sage = request.getParameter("sage");
		String sdept = request.getParameter("sdept");
		int isage = Integer.parseInt(sage);
		//创建学生对象
		Student s = new Student(sno, sname,isage,sdept);
		//创建Jackson插件的ObjectMapper对象
		ObjectMapper mapper = new ObjectMapper();
		//将一个Java对象转换成JSON
		mapper.writeValue(response.getWriter(), s);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
