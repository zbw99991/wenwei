package cn.java.controlller;

import cn.java.dao.CategoryDao;
import cn.java.dao.PictureDao;
import cn.java.entity.Category;
import cn.java.entity.Picture;
import cn.java.utils.ThUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowSendPictureServlet",urlPatterns = "/showsendpicture")
public class ShowSendPictureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Context context=new Context();
        /*1.查询导航分类,即为图片分类*/
        CategoryDao dao= new CategoryDao();
        List<Category> list=dao.findAll();
        context.setVariable("list",list);

        //查询所有图片
        PictureDao pictureDao=new PictureDao();
        List<Picture> bList= pictureDao.findAll();
        context.setVariable("bList",bList);

        ThUtils.print("sendpicture.html",context,response);
    }
}
