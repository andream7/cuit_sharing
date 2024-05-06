package controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**��@Controller����ʾIndexController��ʵ����һ��������
 * @Controller�൱��@Controller("indexController")
 * ��@Controller(value = "indexController")
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	@RequestMapping("/login")
	public String login() {
		/**login�����߼���ͼ���ƣ���Ҫ����Spring MVC����
		 * �ļ���internalResourceViewResolver��ǰ׺�ͺ�׺�ҵ���Ӧ��������ͼ
		 */
		return "login";
	}
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
}
