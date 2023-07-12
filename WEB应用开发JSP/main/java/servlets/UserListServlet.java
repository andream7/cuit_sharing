package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import jsp.exp.dao.UserDao;
import jsp.exp.entity.User;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//定义⼀个Servlet，⾃⾏定义类名及其URL映射；在该Servlet中创建⼀个List<⽤户 JavaBean>对象，在List集合对象中存放多个User对象（可⾃⾏添加User对象， 也可以尝试读取/WEB-INF/users⽬录下已注册的⽤户信息来构建User对象
//在下面编写代码，完成上述要求
@WebServlet(name = "userList", urlPatterns = "/users.do")
public class UserListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = new ArrayList<>();
        UserDao userDao = new UserDao("C:\\Users\\Lenovo\\IdeaProjects\\2021121079_javaweb\\target\\javaweb_2021121079-1.0-SNAPSHOT\\WEB-INF\\lib\\db.db");
        userList = userDao.queryAll();
        System.out.println(userList);
        try {
            request.setAttribute("userList", userList);
        }catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/users.jsp").forward(request, response);
    }
}
