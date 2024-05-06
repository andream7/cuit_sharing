package filters;
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

@WebFilter("/*")
public class LoginValidateFilter implements Filter {
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(true);
		resp.setContentType("text/html;");
		resp.setCharacterEncoding("UTF-8");
		// �õ��û������URI
		String request_uri = req.getRequestURI();
		// �õ�webӦ�ó����������·��
		String ctxPath = req.getContextPath();
		// ȥ��������·�����õ�ʣ�ಿ�ֵ�·��
		String uri = request_uri.substring(ctxPath.length());
		boolean adminflag = false;
		boolean beforeflag = false;
		// Ĭ����ҳ��css�ļ���ͼƬ�ļ���JS
		if ("/".equals(uri) || uri.contains("css") || uri.contains("jsjs") || uri.contains("images") || uri.contains("uploadFile")) {
			chain.doFilter(request, response);
		}
		// JSP����
		if (uri.contains(".jsp")) {
			// admin�ļ���
			if (uri.contains("admin/")) {
				if (uri.contains("login.jsp") || null != session.getAttribute("admin")
						|| uri.contains("loginerror.jsp")) {
					chain.doFilter(request, response);
				} else {
					adminflag = true;
				}
			}
			// before�ļ���
			else if (uri.contains("beforeUser/")) {
				if (null != session.getAttribute("user") || uri.contains("register.jsp") || // ע��ҳ��
						uri.contains("userLogin.jsp") || // ��¼
						uri.contains("searchResult.jsp")// �������ҳ��
				) {
					chain.doFilter(request, response);
				} else {
					beforeflag = true;
				}
			}
			// ��admin��beforeUser�����JSP
			else {
				chain.doFilter(request, response);
			}
		} // JSP�������
			// servlet����
		else {
			// ��̨�����servlet����
			if (uri.contains("admin_")) {
				if (uri.contains("_login") || null != session.getAttribute("admin")) {
					chain.doFilter(request, response);
				} else {
					adminflag = true;
				}
			}
			// ǰ̨��servlet����
			else if (uri.contains("before_")) {
				if (null != session.getAttribute("user") || uri.contains("_first") || // ��ҳ
						uri.contains("_detail") || // ��Ʒ����
						uri.contains("_userLogin") || // ��¼
						uri.contains("_search") || // ͷ������
						uri.contains("_noticeDetail") || // ��������
						uri.contains("_register") || // ע��
						uri.contains("_validateCode")// ��֤��
				) {
					chain.doFilter(request, response);
				} else {
					beforeflag = true;
				}
			}
		} // servlet�������
		if (beforeflag) {// ǰ̨û�е�¼
			String pah = "userLogin.jsp";
			PrintWriter out = resp.getWriter();
			out.println("��û�е�¼������<a href=beforeUser/" + pah + " target=_top>��¼</a>��");
			return;
		}
		if (adminflag) {// ��̨û�е�¼
			String pah = "login.jsp";
			PrintWriter out = resp.getWriter();
			out.println("��û�е�¼������<a href=admin/" + pah + " target=_top>��¼</a>��");
			return;
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
