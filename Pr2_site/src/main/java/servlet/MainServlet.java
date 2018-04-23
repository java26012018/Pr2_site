package servlet;

import entity.User;
import html.HtmlFormer;
import service.AuthenticationService;
import service.ItemService;
import service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AuthenticationService.removeUserAttributeFromSession(request.getParameter("exit"), request.getSession());
        User u = UserService.getUserFromSession(request.getSession());
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(HtmlFormer.contentMain(
                    HtmlFormer.top("Main Page", u),
                    HtmlFormer.end(),
                    ItemService.formItemsForMainServlet(request.getParameter("cat"), request.getParameter("q"))));
        }
    }

}
