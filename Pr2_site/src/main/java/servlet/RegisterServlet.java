package servlet;

import com.google.gson.Gson;
import dao.UserDao;
import entity.Basket;
import entity.User;
import html.HtmlFormer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User)request.getSession().getAttribute("user");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(HtmlFormer.contentRegister(HtmlFormer.top("Register Page", u), HtmlFormer.end()));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");
        if(pass1 != null && pass1.equals(pass2) && login != null && UserDao.getByLogin(login) == null){
            UserDao.add(new User(new Random().nextInt(), login, pass2, new Gson().toJson(new Basket())));
        }
        response.sendRedirect("/Pr2_site/main");
    }

}
