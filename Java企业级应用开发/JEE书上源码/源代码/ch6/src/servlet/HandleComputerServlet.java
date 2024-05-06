package servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ComputerBean;
@WebServlet(name = "handleComputer", urlPatterns = { "/handleComputer" })
public class HandleComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GBK");     //…Ë÷√±‡¬Î£¨∑¿÷π÷–Œƒ¬“¬Î
		String numberOne =request.getParameter("numberOne");
		String operator =request.getParameter("operator");
		String numberTwo =request.getParameter("numberTwo");
		ComputerBean gb=new ComputerBean();
		gb.setNumberOne(Double.parseDouble(numberOne));
		gb.setNumberTwo(Double.parseDouble(numberTwo));
		gb.setOperator(operator);
		request.setAttribute("computer",gb); 
		RequestDispatcher dis=request.getRequestDispatcher("showResult.jsp");
		dis.forward(request, response);
	}
}
