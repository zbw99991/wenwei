package cn.java.Filter;

import cn.java.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Filter"/*,urlPatterns = {"/backstage","/deletebanner","/sendbanner","/logout"}*/)
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }
    //接收到请求时执行的方法
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        User user= (User) request.getSession().getAttribute("user");
        if(user==null){
            response.sendRedirect("/showlogin");
        }else{
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
