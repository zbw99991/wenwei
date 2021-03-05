package cn.java.controlller;

import cn.java.utils.ThUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowLoginServlet",urlPatterns = "/showlogin")
public class ShowLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Context context=new Context();
        //取出Cookie里面保存的名字和值,实现记住用户名功能
        Cookie[] cookies = request.getCookies();
        for(Cookie c:cookies){
            String name=c.getName();
            String value=c.getValue();
            if(name.equals("username")){
                context.setVariable("username",value);
            }else if(name.equals("password")){
                context.setVariable("password",value);
            }
        }
        ThUtils.print("login.html",context,response);
    }
}
