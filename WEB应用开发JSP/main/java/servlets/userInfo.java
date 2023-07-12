package servlets;

import jsp.exp.dao.UserDao;
import jsp.exp.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "userInfo", value = "/userInfo.do")
public class userInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        UserDao userDao = new UserDao("C:\\Users\\Lenovo\\IdeaProjects\\2021121079_javaweb\\target\\javaweb_2021121079-1.0-SNAPSHOT\\WEB-INF\\lib\\db.db");
        System.out.println(userId);
        User user = userDao.findById(Integer.parseInt(userId));
        System.out.println(user);
        if (user != null) {
            response.setCharacterEncoding("GBK");
            request.getSession().setAttribute("user", user);
            response.getWriter().write("登录成功,3秒钟后跳转到信息");
            response.setHeader("refresh", "3;url=/javaweb_2021121079_war_exploded/info.jsp");
        } else {
            response.setCharacterEncoding("GBK");
            response.getWriter().write("查询失败,3秒钟后跳转回原页面");//\nSystem.out.println("我Tm来辣");
            response.setHeader("refresh", "3;url=/javaweb_2021121079_war_exploded/users.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
