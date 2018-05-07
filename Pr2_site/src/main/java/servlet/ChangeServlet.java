package servlet;

import dao.UserDao;
import entity.User;
import html.HtmlFormer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ChangeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User u = (User) request.getSession().getAttribute("user");
        if (u == null) {
            response.sendRedirect("/Pr2_site/main");
        } else {
            try (PrintWriter out = response.getWriter()) {
                response.setContentType("text/html;charset=UTF-8");
                out.println(HtmlFormer.changePass());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User u = (User) request.getSession().getAttribute("user");
        if (u != null) {
            String oldpass = request.getParameter("oldpassword");
            String pass1 = request.getParameter("pass1");
            String pass2 = request.getParameter("pass2");
            if (u.getPass().equals(oldpass) && pass1 != null && pass1.equals(pass2)) {
                u.setPass(pass1);
                UserDao.update(u);
                response.sendRedirect("/Pr2_site/main");
            } else {
                response.sendRedirect("/Pr2_site/change");
            }
        } else {
            response.sendRedirect("/Pr2_site/main");
        }
    }
}
