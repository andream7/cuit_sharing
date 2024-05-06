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
	//�õ�һ��������¼��־�Ķ���������ӡ��Ϣ��ʱ���ܹ�����Ǵ�ӡ���Ǹ������Ϣ
	private static final Log logger = LogFactory.getLog(UserController.class);
	/**
	 * �����¼
	 * ʹ��UserForm����ʵ��bean��user����ע��ҳ���ύ���������
	 */
	@RequestMapping("/login")
	public String login(UserForm user, HttpSession session, Model model) {
			if("zhangsan".equals(user.getUname()) 
					&& "123456".equals(user.getUpass())) {
				session.setAttribute("u", user);
				logger.info("�ɹ�");
				return "main";//��¼�ɹ�����ת��main.jsp
			}else{
				logger.info("ʧ��");
				model.addAttribute("messageError", "�û������������");
				return "login";
			}	
				
	}
	
	/**
	 *����ע��
	 *ʹ�� UserForm����ʵ��bean��user����ע��ҳ���ύ��������� 
	 */
@RequestMapping("/register")
	public String register(UserForm user, Model model) {
		if("zhangsan".equals(user.getUname()) 
				&& "123456".equals(user.getUpass())) {
			logger.info("�ɹ�");
			return "login";//ע��ɹ�����ת��login.jsp
		}else{
			logger.info("ʧ��");
			//��register.jspҳ���Ͽ���ʹ��EL���ʽȡ��model��unameֵ
			model.addAttribute("uname", user.getUname());
			return "register";//����register.jsp
		}
	}
}
