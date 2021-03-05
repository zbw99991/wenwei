package cn.java.controlller;

import cn.java.dao.Banner_imgDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "DeleteBannerServlet",urlPatterns = "/deletebanner")
public class DeleteBannerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        Banner_imgDao dao=new Banner_imgDao();
        String url=dao.findUrlById(id);
        String path=getServletContext().getRealPath(url);
        new File(path).delete();
        dao.deleteById(id);
        response.sendRedirect("/backstage");
    }
}
