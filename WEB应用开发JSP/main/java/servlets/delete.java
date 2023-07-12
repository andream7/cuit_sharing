package servlets;

import jsp.exp.dao.UserDao;
import jsp.exp.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "delete", value = "/delete.do")
public class delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        UserDao userDao = new UserDao("C:\\Users\\Lenovo\\IdeaProjects\\2021121079_javaweb\\target\\javaweb_2021121079-1.0-SNAPSHOT\\WEB-INF\\lib\\db.db");
        int check = userDao.deleteUser(Integer.parseInt(userId));
        if (check>-1){
            response.setCharacterEncoding("GBK");
            response.getWriter().write("删除成功,3秒钟后跳转回原页面");
            response.setHeader("refresh", "3;url=/javaweb_2021121079_war_exploded/users.jsp");
        }else {
            response.setCharacterEncoding("GBK");
            response.getWriter().write("删除失败,3秒钟后跳转回原页面");
            response.setHeader("refresh", "3;url=/javaweb_2021121079_war_exploded/users.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
