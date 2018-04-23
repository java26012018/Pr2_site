package servlet;

import entity.User;
import html.HtmlFormer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User u = (User)request.getSession().getAttribute("user");
        if(u == null){
            response.sendRedirect("/Pr2_site/main");
        }else {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println(HtmlFormer.profile());
            }
        }
    }
}
