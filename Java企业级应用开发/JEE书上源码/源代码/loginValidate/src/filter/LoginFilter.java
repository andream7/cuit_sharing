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
		// �õ��û������URI
		String request_uri = req.getRequestURI();
		// �õ�webӦ�ó����������·��
		String ctxPath = req.getContextPath();
		// ȥ��������·�����õ�ʣ�ಿ�ֵ�·��
		String uri = request_uri.substring(ctxPath.length());
		// ��¼ҳ���Servlet������
		if(uri.contains("login.jsp") || uri.contains("loginServlet")){
			chain.doFilter(request, response);
		}else{
			// �ж��û��Ƿ��Ѿ���¼
			if (null != session.getAttribute("user")) {
				//ִ����һ��������
				chain.doFilter(request, response);
			} else {
				out.println("��û�е�¼�����ȵ�¼��3���Ӻ�ص���¼ҳ�档");
				resp.setHeader("refresh", "3;url=" + ctxPath + "/login.jsp");
				return;
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
