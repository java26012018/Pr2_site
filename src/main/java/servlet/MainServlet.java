package servlet;

import entity.User;
import html.HtmlFormer;
import service.AuthenticationService;
import service.ItemService;
import service.UserService;
import spring.SpringContextHolder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {

    //private final HtmlFormer html = (HtmlFormer) SpringContextHolder.getContext().getBean("html");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HtmlFormer html = new HtmlFormer();
        AuthenticationService.removeUserAttributeFromSession(request.getParameter("exit"), request.getSession());
        User u = UserService.getUserFromSession(request.getSession());
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(html.contentMain(
                    html.top("Main Page", u),
                    html.end(),
                    ItemService.formItemsForMainServlet(request.getParameter("cat"), request.getParameter("q"))));
        }
    }

}
