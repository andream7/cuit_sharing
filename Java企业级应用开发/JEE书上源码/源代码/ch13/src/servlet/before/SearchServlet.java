package servlet.before;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BeforeUserService;
@WebServlet(name = "before_search", urlPatterns = { "/before_search" })
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mykey = request.getParameter("mykey");
		BeforeUserService bs = new BeforeUserService();
		List<Map<String, Object>> list = bs.search(mykey);
		request.setAttribute("searchlist", list);
		request.getRequestDispatcher("beforeUser/searchResult.jsp").forward(request, response);
	}
}
