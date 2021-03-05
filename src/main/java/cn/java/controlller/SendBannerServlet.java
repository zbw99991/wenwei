package cn.java.controlller;

import cn.java.dao.Banner_imgDao;
import cn.java.entity.Banner_img;

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

/*修改轮播图*/
@MultipartConfig
@WebServlet(name = "SendBannerServlet",urlPatterns = "/sendbanner")
public class SendBannerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bannerId=request.getParameter("bannerId");
        Part part=request.getPart("file");;
        String info=part.getHeader("content-disposition");
        String suffix=info.substring(info.lastIndexOf("."),info.length()-1);
        String fileName= UUID.randomUUID()+suffix;

        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("/yyyy/MM/dd/");
        String datePath=sdf.format(date);
        /*获取servlet上下文的真实路径*/
        String path=getServletContext().getRealPath("images"+datePath);
        new File(path).mkdirs();
        part.write(path+fileName);

        Banner_imgDao dao=new Banner_imgDao();
        Banner_img img=new Banner_img(0,Integer.parseInt(bannerId),"images"+datePath+fileName,System.currentTimeMillis());
        dao.insert(img);
        response.sendRedirect("/backstage");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
