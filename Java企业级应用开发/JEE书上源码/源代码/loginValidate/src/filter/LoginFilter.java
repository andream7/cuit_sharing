package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "loginFilter", urlPatterns = { "/*" })
public class LoginFilter implements Filter {
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(true);
		resp.setContentType("text/html;");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		// 得到用户请求的URI
		String request_uri = req.getRequestURI();
		// 得到web应用程序的上下文路径
		String ctxPath = req.getContextPath();
		// 去除上下文路径，得到剩余部分的路径
		String uri = request_uri.substring(ctxPath.length());
		// 登录页面或Servlet不拦截
		if(uri.contains("login.jsp") || uri.contains("loginServlet")){
			chain.doFilter(request, response);
		}else{
			// 判断用户是否已经登录
			if (null != session.getAttribute("user")) {
				//执行下一个过滤器
				chain.doFilter(request, response);
			} else {
				out.println("您没有登录，请先登录！3秒钟后回到登录页面。");
				resp.setHeader("refresh", "3;url=" + ctxPath + "/login.jsp");
				return;
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
