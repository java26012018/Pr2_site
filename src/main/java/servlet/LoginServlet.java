package servlet;

import dao.UserDao;
import entity.User;
import html.HtmlFormer;
import spring.SpringContextHolder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    private final UserDao udao = (UserDao) SpringContextHolder.getContext().getBean("udao");
    private final HtmlFormer html = (HtmlFormer) SpringContextHolder.getContext().getBean("html");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User u = (User)request.getSession().getAttribute("user");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(html.contentLogin(html.top("SigIn Page", u), html.end()));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        if(login != null){
            User u = udao.getByLogin(login);
            if(u != null && u.getPass().equals(pass)){
                request.getSession().setAttribute("user", u);
            }
        }
        response.sendRedirect("/Pr2_site/main");
    }
}
