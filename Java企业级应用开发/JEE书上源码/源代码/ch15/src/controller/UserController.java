package controller;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.UserForm;
@Controller
@RequestMapping("/user")
public class UserController {
	//得到一个用来记录日志的对象，这样打印信息的时候能够标记是打印的那个类的信息
	private static final Log logger = LogFactory.getLog(UserController.class);
	/**
	 * 处理登录
	 * 使用UserForm对象（实体bean）user接收注册页面提交的请求参数
	 */
	@RequestMapping("/login")
	public String login(UserForm user, HttpSession session, Model model) {
			if("zhangsan".equals(user.getUname()) 
					&& "123456".equals(user.getUpass())) {
				session.setAttribute("u", user);
				logger.info("成功");
				return "main";//登录成功，跳转到main.jsp
			}else{
				logger.info("失败");
				model.addAttribute("messageError", "用户名或密码错误");
				return "login";
			}	
				
	}
	
	/**
	 *处理注册
	 *使用 UserForm对象（实体bean）user接收注册页面提交的请求参数 
	 */
@RequestMapping("/register")
	public String register(UserForm user, Model model) {
		if("zhangsan".equals(user.getUname()) 
				&& "123456".equals(user.getUpass())) {
			logger.info("成功");
			return "login";//注册成功，跳转到login.jsp
		}else{
			logger.info("失败");
			//在register.jsp页面上可以使用EL表达式取出model的uname值
			model.addAttribute("uname", user.getUname());
			return "register";//返回register.jsp
		}
	}
}
