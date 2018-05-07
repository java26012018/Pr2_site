package servlet;

import com.google.gson.Gson;
import dao.UserDao;
import entity.Basket;
import entity.User;
import html.HtmlFormer;
import spring.SpringContextHolder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class RegisterServlet extends HttpServlet {

    private final UserDao udao = (UserDao) SpringContextHolder.getContext().getBean("udao");
    private final HtmlFormer html = (HtmlFormer) SpringContextHolder.getContext().getBean("html");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User u = (User)request.getSession().getAttribute("user");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(html.contentRegister(html.top("Register Page", u), html.end()));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");
        if (pass1 != null && pass1.equals(pass2) && login != null && udao.getByLogin(login) == null) {
            udao.add(new User(new Random().nextInt(), login, pass2, new Gson().toJson(new Basket())));
        }
        response.sendRedirect("/Pr2_site/main");
    }

}
