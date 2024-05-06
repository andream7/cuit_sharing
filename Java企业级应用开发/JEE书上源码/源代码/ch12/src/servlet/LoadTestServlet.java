package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import entity.Student;

@WebServlet("/LoadTestServlet")
public class LoadTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String sname = request.getParameter("sname");
		System.out.println("sname:" + sname);
		//����ѧ������
		Student s = new Student("001", "�º�",88,"��ϢѧԺ");
		//����Jackson�����ObjectMapper����
		ObjectMapper mapper = new ObjectMapper();
		//��һ��Java����ת����JSON
		mapper.writeValue(response.getWriter(), s);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
