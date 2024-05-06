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
		//时间不能有空格，不然后续Cookie创建后
		//运行报错（ An invalid character [32] was present in the Cookie value）。
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
		String nowTime = sdf.format(new Date());
		String lastVistTime = "";//访问时间
		int vistedCount = 0;//访问次数
		//获取客户端浏览器保存的所有Cookie
		Cookie[] myCookies = request.getCookies();
		if(myCookies != null) {
			for (Cookie cookie : myCookies) {
				//判断是否为最近访问过的Cookie，Cookie中属性名为lastVist，属性值为上次访问的时间
				if("lastVist".equals(cookie.getName())) {
					lastVistTime = cookie.getValue();
				}
				//判断是否为记录访问次数的Cookie，Cookie中属性名为vistedCount，属性值为上次访问的次数
				if("vistedCount".equals(cookie.getName())) {
					vistedCount = Integer.valueOf(cookie.getValue());
				}
			}
		}
		//不是第一次访问，输出上次访问时间
		if(!"".equals(lastVistTime)){
			out.println("您上次访问时间为：" + lastVistTime);
		}
		//输出访问次数
		out.println("您是第：" + (vistedCount + 1) + "访问该网站。");
		//以本次访问时间创建同名Cookie
		Cookie lastVistTimeC = new Cookie("lastVist", nowTime);
		//设置最大存活时间为一年
		lastVistTimeC.setMaxAge(365 * 24 * 60 * 60);
		//以访问次数创建同名Cookie
		Cookie vistedCountC = new Cookie("vistedCount", (vistedCount + 1) + "");
		//设置最大存活时间为一年
		vistedCountC.setMaxAge(365 * 24 * 60 * 60);
		//将两个Cookie对象响应到客户端
		response.addCookie(lastVistTimeC);
		response.addCookie(vistedCountC);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
