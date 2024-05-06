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
		//设置请求和响应字符编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//使用Map模拟学生信息的数据库
		/*Map<String, String> stus = new HashMap<String, String>();
		stus.put("20190101", "陈恒01,77,计算机学院");
		stus.put("20190102", "陈恒02,88,软件学院");
		stus.put("20190103", "陈恒03,99,信息学院");*/
		//定义3个学生信息对象
		Student s1 = new Student("20190101", "陈恒01",77,"计算机学院");
		Student s2 = new Student("20190102", "陈恒02",88,"软件学院");
		Student s3 = new Student("20190103", "陈恒03",99,"信息学院");
		//使用Map模拟学生信息的数据库
		Map<String, Student> stus = new HashMap<String, Student>();
		stus.put(s1.getSno(), s1);
		stus.put(s2.getSno(), s2);
		stus.put(s3.getSno(), s3);
		//获取Ajax请求的数据
		String sno = request.getParameter("sno");
		//根据学号从模拟数据库中查询学生信息
		Student stu = stus.get(sno);
		if(stu == null) {
			stu = new Student("error","error", 0,"error");
		}
		//创建Jackson插件的ObjectMapper对象
		ObjectMapper mapper = new ObjectMapper();
		//将一个Java对象转换成JSON
		mapper.writeValue(response.getWriter(), stu);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
