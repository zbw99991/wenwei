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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet",urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
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
        //查询指定类型轮播图
        Banner_imgDao imgDao=new Banner_imgDao();
        //"大"轮播图
        int bannerId=1;
        List<Banner_img> bList=imgDao.findAllByBannerId(bannerId);
        context.setVariable("bList",bList);
        //"中"轮播图
        bannerId=2;
        List<Banner_img> cList=imgDao.findAllByBannerId(bannerId);
        context.setVariable("cList",cList);
        //"小"轮播图
        bannerId=3;
        List<Banner_img> dList=imgDao.findAllByBannerId(bannerId);
        context.setVariable("dList",dList);

        ThUtils.print("home.html",context,response);
    }
}
