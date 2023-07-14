package servlets;

import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jsp.exp.dao.UserDao;
import jsp.exp.entity.User;

@WebServlet(name = "register", value = "/register.do")
public class register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user1 = new User();
        user1.setUserName(request.getParameter("userName"));
        user1.setPwd(request.getParameter("pwd"));
        user1.setGender(request.getParameter("gender"));
        user1.setCategory(request.getParameter("category"));
        user1.setInterest(request.getParameter("interest"));
        user1.setPhoto(request.getParameter("photo"));
        UserModel userModel = new UserModel();
        String userDictionary = getServletContext().getRealPath("/WEB-INF/users");
        System.out.println(userDictionary);
        File userFile = new File(userDictionary + "/" + user1.getUserName() + ".properties");
        boolean isRegistered = userModel.registerUser(userFile, (entities.User) user1);
        if (isRegistered) {
            //请先显示"注册成功,三秒钟后将跳到登录页面",然后跳转到login.html
            response.setCharacterEncoding("GBK");
            response.getWriter().write("注册成功,三秒钟后将跳到登录页面");
            response.setHeader("refresh", "3;url=/javaweb_2021121079_war_exploded/login.html");
        } else {
            response.sendRedirect("/javaweb_2021121079_war_exploded/register.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
//@WebServlet(name = "register", value = "/register.do")
//public class register extends HttpServlet{
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User user1 = new User();
//        user1.setUserName(request.getParameter("userName"));
//        user1.setPwd(request.getParameter("pwd"));
//        user1.setGender(request.getParameter("gender"));
//        user1.setCategory(request.getParameter("category"));
//        user1.setInterest(request.getParameter("interest"));
//        user1.setPhoto(request.getParameter("photo"));
//        UserDao userDao = new UserDao("C:\\Users\\Lenovo\\IdeaProjects\\2021121079_javaweb\\target\\javaweb_2021121079-1.0-SNAPSHOT\\WEB-INF\\lib\\db.db");
//        int check = userDao.addUser(user1);
//        if (check >-1) {
//            response.setCharacterEncoding("GBK");
//            response.getWriter().write("注册成功,三秒钟后将跳到登录页面");
//            response.setHeader("refresh", "3;url=/javaweb_2021121079_war_exploded/login.jsp");
//        } else {
//            response.sendRedirect("/javaweb_2021121079_war_exploded/register.jsp");
//        }
//    }
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//}