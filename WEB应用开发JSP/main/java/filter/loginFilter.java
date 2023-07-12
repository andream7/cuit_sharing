package filter;

import model.UserModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

//@WebFilter(filterName = "loginFilter", urlPatterns = {"/test_war_exploded/login.html"})
public class loginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Cookie[] cookies = request.getCookies();
        Cookie cookie1 = getCookieByName(cookies, "autoLogin");
        String userName = null, password = null, checkbox = null;
        if (cookie1 != null) {
            String[] values = cookie1.getValue().split(":");
            userName = values[0];
            password = values[1];
            checkbox = "on";
            HttpServletResponse resp = (HttpServletResponse) servletResponse;
            resp.setCharacterEncoding("GBK");
            resp.getWriter().write("登录成功,3秒钟后跳转到首页");
            resp.setHeader("refresh", "3;url=/javaweb_2021121079_war_exploded/home.html");
        }
        filterChain.doFilter(request, servletResponse);
    }

    private Cookie getCookieByName(Cookie[] cookies, String autoLogin) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(autoLogin)) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
