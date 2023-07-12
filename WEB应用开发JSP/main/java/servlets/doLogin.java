package servlets;

import model.UserModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

//@WebServlet("/servlets.doLogin.do")
//public class doLogin extends javax.servlet.http.HttpServlet {
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userName = req.getParameter("userName");
//        String password = req.getParameter("pwd");
//        if (userName.equals("caterpillar") && password.equals("123456")) {
//            resp.setCharacterEncoding("GBK");
//            resp.getWriter().write("登录成功！");
//        } else {
//            resp.sendRedirect("/2021121079_war_exploded/login.html");
//        }
//    }
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//
//    public void destroy() {
//        super.destroy();
//    }
//}

//⽤户通过login.html⻚⾯登录，⽤户提交登录名和密码给这个Servlet，在此Servlet中使⽤UserModel提供的⽅法验证⽤户提交的⽤户名和密码是否正确
//如果⽤户名密码正确，在session中保存⽤户名,作为成功登录的记录
//再输出"登录成功,3秒钟后跳转到首页",然后跳转到index.html
//反之,则输出"登陆失败,用户名或密码错误,3秒钟后将跳到登录页面",然后跳回到login.html

@WebServlet(name = "login", value = "/doLogin.do")
public class doLogin extends javax.servlet.http.HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName, password, checkbox;
        userName = req.getParameter("userName");
        password = req.getParameter("pwd");
        checkbox = req.getParameter("autoLogin");

        UserModel userModel = new UserModel();
        String userDictionary = getServletContext().getRealPath("/WEB-INF/users");
        File userFile = new File(userDictionary + "/" + userName + ".properties");
        boolean check = userModel.loginCheck(userFile, password);
        //使用cookie实现自动登录,若checkbox的值为on,则将用户名和密码存入cookie中,用户在下一次访问页面时实现自动登录
        if (check) {
            if (checkbox != null) {
                Cookie cookie2 = new Cookie(
                        "autoLogin",
                        userName + ":" + password
                );
                cookie2.setMaxAge(60 * 60 * 24 * 7);
                cookie2.setPath("/");
                cookie2.setComment("自动登录");
                cookie2.setHttpOnly(true);
                cookie2.setSecure(true);
                cookie2.setVersion(1);
                cookie2.setDomain("localhost");
                resp.addCookie(cookie2);
            }
            HttpSession session = req.getSession();
            session.setAttribute("userName", userName);
            resp.setCharacterEncoding("GBK");
            resp.getWriter().write("登录成功,3秒钟后跳转到首页");
            resp.setHeader("refresh", "3;url=/javaweb_2021121079_war_exploded/home.jsp");
        } else {
            resp.setCharacterEncoding("GBK");
            resp.getWriter().write("登录失败,用户名或密码错误,3秒钟后跳转到登录页面");
            resp.setHeader("refresh", "3;url=/javaweb_2021121079_war_exploded/login.jsp");
        }
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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void destroy() {
        super.destroy();
    }
}

