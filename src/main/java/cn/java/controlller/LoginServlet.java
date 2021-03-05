package cn.java.controlller;

import cn.java.dao.UserDao;
import cn.java.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取用户输入的用户名和密码
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        UserDao dao=new UserDao();
        User user=dao.login(username,password);
        if(user!=null){//user不为空登录成功
            String rem=request.getParameter("rem");
            if(rem!=null){//判断是否需要记住用户名和密码,需要则下发到客户端
                Cookie c1=new Cookie("username",username);
                Cookie c2=new Cookie("password",password);
                response.addCookie(c1);
                response.addCookie(c2);
            }
            //将用户存入Session域
            HttpSession session=request.getSession();
            session.setAttribute("user",user);

            response.sendRedirect("/home");
        }else{
            response.sendRedirect("/showlogin");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
