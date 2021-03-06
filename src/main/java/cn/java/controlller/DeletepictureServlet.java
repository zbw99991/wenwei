package cn.java.controlller;

import cn.java.dao.PictureDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "DeletepictureServlet",urlPatterns = "/deletepicture")
public class DeletepictureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        PictureDao pictureDao=new PictureDao();
        String url=pictureDao.findUrlById(id);
        String path=getServletContext().getRealPath(url);
        System.out.println("path:"+path);
        new File(path).delete();
        pictureDao.deleteById(id);

        response.sendRedirect("/showsendpicture");
    }
}
