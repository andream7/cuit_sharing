package servlet;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Goods;
import util.ReadExcelFile;
@WebServlet("/readExcelFileServlet")
public class ReadExcelFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String filePath = request.getParameter("filePath");
		ReadExcelFile ref = new ReadExcelFile();
		//��ȡExcel���ݴ���List
		List<Goods> ls = ref.getExcelInfo(new File(filePath));
		//��List�����������浽���ݿ�
		Connection con = null;
		PreparedStatement ps = null;
		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//��������
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8","root","root");
			ps = con.prepareStatement("insert into goods values(null,?,?)");
			if(ls != null){
				for(int i = 0; i < ls.size(); i++){//������¼
					ps.setString(1, ls.get(i).getGname());
					ps.setDouble(2, ls.get(i).getGprice());
					ps.addBatch();
				}
				//��������
				ps.executeBatch();
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//������Ӧ����������
		response.setContentType("text/html;charset=utf-8");
		//ȡ���������
		PrintWriter out=response.getWriter();
		out.print("����ɹ���������" + ls.size() + "�����ݣ�");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
