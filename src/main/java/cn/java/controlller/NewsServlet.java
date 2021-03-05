package cn.java.controlller;

import cn.java.dao.Banner_imgDao;
import cn.java.dao.CategoryDao;
import cn.java.entity.Banner_img;
import cn.java.entity.Category;
import cn.java.entity.User;
import cn.java.utils.ThUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewsServlet",urlPatterns = "/news")
public class NewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Context context=new Context();
        /*1.查询导航分类*/
        CategoryDao dao= new CategoryDao();
        List<Category> list=dao.findAll();
        context.setVariable("list",list);
        //获取session中的用户信息
        User user= (User) request.getSession().getAttribute("user");
        context.setVariable("user",user);

        ThUtils.print("news.html",context,response);
    }
}
