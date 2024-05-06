package servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Goods;
@WebServlet("/selectGoodsByPageServlet")
public class SelectGoodsByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//����ѯ���װ������ArrayList<Goods>�У�������ҳ����ʾ
		ArrayList<Goods> allGoods = null;
		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//��������
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8","root","root");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("select * from goods ");
			rs.last();//�Ƶ����һ��
			int totalCount = rs.getRow();//��ҳ��ѯ����������
			int totalPage = 0;
			if (totalCount == 0) {
				totalPage = 0;//��ҳ��
			} else {
				//���ش��ڻ��ߵ���ָ�����ʽ����С����
				totalPage = (int) Math.ceil((double) totalCount / 3);
			}
			String pageCur11 = request.getParameter("pageCur");//��õ�ǰҳ��
			if (pageCur11 == null) {//��ҳ��
				pageCur11 = "1";
			}
			int  pageCur = Integer.parseInt(pageCur11);
			if ((pageCur - 1) * 3 > totalCount) {
				pageCur = pageCur - 1;
			}
			int startIndex = (pageCur - 1) * 3;//��ʼλ��
			int perPageSize = 3;//ÿҳ3��
			//Ԥ����
			ps = con.prepareStatement("select * from goods limit ?, ?");
			ps.setInt(1, startIndex);
			ps.setInt(2, perPageSize);
			//���Ͳ�ѯSQL��䣬���ؽ����
			rs = ps.executeQuery();
			//����ѯ���װ������ArrayList<Goods>��
			allGoods = new ArrayList<Goods>();
			while(rs.next()){
				Goods g = new Goods();
				g.setId(rs.getInt(1));
				g.setGname(rs.getString(2));
				g.setGprice(rs.getDouble(3));
				allGoods.add(g);
			}  
			//�浽request�����Ա���ҳ��showAllGoods.jsp����ʾ
			request.setAttribute("allGoods", allGoods);
			request.setAttribute("totalCount", totalCount);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("pageCur", pageCur);
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//��ת��showAllGoods.jsp��ʾ��Ʒ
		RequestDispatcher dis = request.getRequestDispatcher("showGoodsByPage.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
