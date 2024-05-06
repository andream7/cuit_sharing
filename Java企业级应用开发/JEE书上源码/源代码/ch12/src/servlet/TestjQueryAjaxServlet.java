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
		//�����������Ӧ�ַ�����
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String sage = request.getParameter("sage");
		String sdept = request.getParameter("sdept");
		int isage = Integer.parseInt(sage);
		//����ѧ������
		Student s = new Student(sno, sname,isage,sdept);
		//����Jackson�����ObjectMapper����
		ObjectMapper mapper = new ObjectMapper();
		//��һ��Java����ת����JSON
		mapper.writeValue(response.getWriter(), s);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
