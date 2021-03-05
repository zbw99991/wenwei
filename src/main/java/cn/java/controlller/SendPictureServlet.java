package cn.java.controlller;

import cn.java.dao.PictureDao;
import cn.java.entity.Picture;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
@MultipartConfig
@WebServlet(name = "SendPictureServlet",urlPatterns = "/sendpicture")
public class SendPictureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取参数
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String intro = request.getParameter("intro");
        String categoryId = request.getParameter("categoryId");
        //获取上传文件
        Part part=request.getPart("file");
        //获取文件的后缀
        String info=part.getHeader("content-disposition");
        String suffix=info.substring(info.lastIndexOf("."),info.length()-1);
        //得到唯一文件名
        String fileName= UUID.randomUUID()+suffix;
        //得到和日期相关的路径
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("/yyyy/MM/dd/");
        String datePath=sdf.format(date);
        /*获取servlet上下文的真实路径*/
        String path=getServletContext().getRealPath("images"+datePath);
        new File(path).mkdirs();
        part.write(path+fileName);
        Picture picture=new Picture(0,title,author,intro,
                "images"+datePath+fileName, System.currentTimeMillis(),
                Integer.parseInt(categoryId),0,0);
        new PictureDao().insert(picture);
        response.sendRedirect("/showsendpicture");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
