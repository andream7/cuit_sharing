package filter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class FirstFilter implements Filter {
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//������Ӧ����
		response.setContentType("text/html;charset=utf-8");
		//����������out
		PrintWriter out=response.getWriter();
		//������������
		out.print("����ִ�й�����<br>");
		//ִ����һ��������
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
