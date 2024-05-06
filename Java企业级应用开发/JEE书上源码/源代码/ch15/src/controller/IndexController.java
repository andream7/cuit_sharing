package controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**“@Controller”表示IndexController的实例是一个控制器
 * @Controller相当于@Controller("indexController")
 * 或@Controller(value = "indexController")
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	@RequestMapping("/login")
	public String login() {
		/**login代表逻辑视图名称，需要根据Spring MVC配置
		 * 文件中internalResourceViewResolver的前缀和后缀找到对应的物理视图
		 */
		return "login";
	}
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
}
