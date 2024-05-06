package servlet;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Goods;
import util.GetAllGoods;
@WebServlet("/selectAllGoodServlet")
public class SelectAllGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ѯ���װ������ArrayList<Goods>�У�������ҳ����ʾ
		ArrayList<Goods> allGoods = GetAllGoods.getAllGoods();
		//�浽request�����Ա���ҳ��showAllGoods.jsp����ʾ
		request.setAttribute("allGoods", allGoods);
		//��ת��showExportGoods.jsp��ʾ��Ʒ
		RequestDispatcher dis = request.getRequestDispatcher("showExportGoods.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
