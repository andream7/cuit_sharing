package servlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import entity.Student;
@WebServlet("/AjaxTestServlet")
public class AjaxTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����������Ӧ�ַ�����
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//ʹ��Mapģ��ѧ����Ϣ�����ݿ�
		/*Map<String, String> stus = new HashMap<String, String>();
		stus.put("20190101", "�º�01,77,�����ѧԺ");
		stus.put("20190102", "�º�02,88,���ѧԺ");
		stus.put("20190103", "�º�03,99,��ϢѧԺ");*/
		//����3��ѧ����Ϣ����
		Student s1 = new Student("20190101", "�º�01",77,"�����ѧԺ");
		Student s2 = new Student("20190102", "�º�02",88,"���ѧԺ");
		Student s3 = new Student("20190103", "�º�03",99,"��ϢѧԺ");
		//ʹ��Mapģ��ѧ����Ϣ�����ݿ�
		Map<String, Student> stus = new HashMap<String, Student>();
		stus.put(s1.getSno(), s1);
		stus.put(s2.getSno(), s2);
		stus.put(s3.getSno(), s3);
		//��ȡAjax���������
		String sno = request.getParameter("sno");
		//����ѧ�Ŵ�ģ�����ݿ��в�ѯѧ����Ϣ
		Student stu = stus.get(sno);
		if(stu == null) {
			stu = new Student("error","error", 0,"error");
		}
		//����Jackson�����ObjectMapper����
		ObjectMapper mapper = new ObjectMapper();
		//��һ��Java����ת����JSON
		mapper.writeValue(response.getWriter(), stu);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
