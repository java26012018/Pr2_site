package servlet;

import dao.UserDao;
import entity.User;
import html.HtmlFormer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User)request.getSession().getAttribute("user");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(HtmlFormer.contentLogin(HtmlFormer.top("SigIn Page", u), HtmlFormer.end()));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        if(login != null){
            User u = UserDao.getByLogin(login);
            if(u != null && u.getPass().equals(pass)){
                request.getSession().setAttribute("user", u);
            }
        }
        response.sendRedirect("/Pr2_site/main");
    }
}
