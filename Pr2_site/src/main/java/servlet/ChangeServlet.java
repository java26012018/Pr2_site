package servlet;

import com.google.gson.Gson;
import dao.ItemDao;
import dao.UserDao;
import entity.Basket;
import entity.Item;
import entity.User;
import html.HtmlFormer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class ChangeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            User u = (User) request.getSession().getAttribute("user");
            response.setContentType("text/html;charset=UTF-8");
            if (u == null) {
                response.sendRedirect("/Pr2_site/main");
            } else {
                out.println(HtmlFormer.changePass());
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) request.getSession().getAttribute("user");
        if (u != null) {
            String oldpass = request.getParameter("oldpassword");
            String pass1 = request.getParameter("pass1");
            String pass2 = request.getParameter("pass2");

            if (!oldpass.equals("")) {
                User un = UserDao.getByLogin(u.getLogin());
                if (un != null && un.getPass().equals(oldpass)) {
                    if (pass1.equals(pass2)) {
                        un.setPass(pass1);
                        UserDao.update(un);
                        response.sendRedirect("/Pr2_site/main");
                    } else {
                        response.sendRedirect("/Pr2_site/change");
                    }
                }
            } else
                response.sendRedirect("/Pr2_site/profile");
        } else {
            response.sendRedirect("/Pr2_site/main");
        }
    }
}
