package cn.java.controlller;

import cn.java.dao.Banner_imgDao;
import cn.java.dao.CategoryDao;
import cn.java.dao.PictureDao;
import cn.java.entity.Banner_img;
import cn.java.entity.Category;
import cn.java.entity.Picture;
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

@WebServlet(name = "ActivityServlet",urlPatterns = "/activity")
public class ActivityServlet extends HttpServlet {
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
        //"副页面"的轮播图
        Banner_imgDao imgDao=new Banner_imgDao();
        int bannerId=4;
        List<Banner_img> bList=imgDao.findAllByBannerId(bannerId);
        context.setVariable("bList",bList);

        //分类查询图片(人气活动.作品展示.最新外景.真实客照)
        String categoryId=request.getParameter("id");
        PictureDao pictureDao =new PictureDao();
        List<Picture> cList=pictureDao.findByCategoryId(categoryId);
        context.setVariable("cList",cList);


        ThUtils.print("activity.html",context,response);
    }
}
