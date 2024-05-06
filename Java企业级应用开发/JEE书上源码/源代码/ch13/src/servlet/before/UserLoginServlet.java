package servlet.before;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.BeforeUserService;
import dto.UserDTO;
@WebServlet(name = "userLogin", urlPatterns = { "/before_userLogin" })
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String bemail = request.getParameter("bemail");
	String bpwd = request.getParameter("bpwd");
	String code1 = request.getParameter("code");
	HttpSession session = request.getSession(true);
	//实体
	UserDTO ud = new UserDTO();
	ud.setBemail(bemail);
	ud.setBpwd(bpwd);
	//业务
	BeforeUserService bs = new BeforeUserService();
	//获取验证码
	String code2 = (String)session.getAttribute("rand");
	RequestDispatcher rds = null;
	//验证码输入正确
	if(code2.equalsIgnoreCase(code1)){
		//邮箱输入错误
		if(bs.isExit(ud).size() < 1 ){
			request.setAttribute("bemailError", "邮箱输入错误！");
			rds = request.getRequestDispatcher("beforeUser/userLogin.jsp");
		}else if(bs.isLogin(ud).size() < 1){//邮箱正确，密码错误
			request.setAttribute("bpwdError", "密码输入错误！");
			rds = request.getRequestDispatcher("beforeUser/userLogin.jsp");
		}else{
			//把bid存到ud中
			ud.setId((Integer)(bs.isLogin(ud).get(0)).get("id"));
			session.setAttribute("user", ud);
			//登录成功，转到首页
			rds = request.getRequestDispatcher("before_first?typeid=0");
		}
	}else{
		request.setAttribute("codeError", "验证码输入错误！");
		rds = request.getRequestDispatcher("beforeUser/userLogin.jsp");
	}
	rds.forward(request, response);
	}
}
