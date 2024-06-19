package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class homeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(false);
        if (session != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            //先显示"请登录后再访问，3秒钟后将跳到登录页面",然后3秒后返回到login.html
            servletResponse.setContentType("text/html;charset=utf-8");
            servletResponse.getWriter().write("请登录后再访问，3秒钟后将跳到登录页面");
            servletResponse.getWriter().write("<meta http-equiv='refresh' content='3;url=/javaweb_2021121079_war_exploded/login.html'>");
        }
    }
}
