package cn.java.controlller;

import cn.java.dao.BannerDao;
import cn.java.dao.Banner_imgDao;
import cn.java.entity.Banner;
import cn.java.entity.Banner_img;
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

/*管理员入口*/
@WebServlet(name = "BackstageServlet",urlPatterns = "/backstage")
public class BackstageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Context context=new Context();
        /*获取session域中的用户*/
        User user=(User)request.getSession().getAttribute("user");
        context.setVariable("user",user);

        /*查找所有轮播图*/
        Banner_imgDao imgDao=new Banner_imgDao();
        List<Banner_img> bList=imgDao.findAll();
        context.setVariable("bList",bList);

        /*查找轮播图分类*/
        BannerDao bannerDao=new BannerDao();
        List<Banner> list=bannerDao.findAll();
        context.setVariable("list",list);

        ThUtils.print("backstage.html",context,response);
    }
}
