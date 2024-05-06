package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//ʱ�䲻���пո񣬲�Ȼ����Cookie������
		//���б��� An invalid character [32] was present in the Cookie value����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��HH:mm:ss");
		String nowTime = sdf.format(new Date());
		String lastVistTime = "";//����ʱ��
		int vistedCount = 0;//���ʴ���
		//��ȡ�ͻ�����������������Cookie
		Cookie[] myCookies = request.getCookies();
		if(myCookies != null) {
			for (Cookie cookie : myCookies) {
				//�ж��Ƿ�Ϊ������ʹ���Cookie��Cookie��������ΪlastVist������ֵΪ�ϴη��ʵ�ʱ��
				if("lastVist".equals(cookie.getName())) {
					lastVistTime = cookie.getValue();
				}
				//�ж��Ƿ�Ϊ��¼���ʴ�����Cookie��Cookie��������ΪvistedCount������ֵΪ�ϴη��ʵĴ���
				if("vistedCount".equals(cookie.getName())) {
					vistedCount = Integer.valueOf(cookie.getValue());
				}
			}
		}
		//���ǵ�һ�η��ʣ�����ϴη���ʱ��
		if(!"".equals(lastVistTime)){
			out.println("���ϴη���ʱ��Ϊ��" + lastVistTime);
		}
		//������ʴ���
		out.println("���ǵڣ�" + (vistedCount + 1) + "���ʸ���վ��");
		//�Ա��η���ʱ�䴴��ͬ��Cookie
		Cookie lastVistTimeC = new Cookie("lastVist", nowTime);
		//���������ʱ��Ϊһ��
		lastVistTimeC.setMaxAge(365 * 24 * 60 * 60);
		//�Է��ʴ�������ͬ��Cookie
		Cookie vistedCountC = new Cookie("vistedCount", (vistedCount + 1) + "");
		//���������ʱ��Ϊһ��
		vistedCountC.setMaxAge(365 * 24 * 60 * 60);
		//������Cookie������Ӧ���ͻ���
		response.addCookie(lastVistTimeC);
		response.addCookie(vistedCountC);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
