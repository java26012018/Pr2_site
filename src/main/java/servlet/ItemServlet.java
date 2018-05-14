package servlet;

import dao.ItemDao;
import entity.Item;
import entity.User;
import html.HtmlFormer;
import spring.SpringContextHolder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ItemServlet extends HttpServlet {

    private final ItemDao idao = (ItemDao) SpringContextHolder.getContext().getBean("idao");
    private final HtmlFormer html = (HtmlFormer) SpringContextHolder.getContext().getBean("html");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User u = (User)request.getSession().getAttribute("user");
        String idString = request.getParameter("id");
        if (idString == null) {
            response.sendRedirect("/Pr2_site/main");
        } else {
            int id = 0;
            try{
                id = Integer.parseInt(idString);
            }catch(Exception e){e.printStackTrace();}
            Item item = idao.getById(id);
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println(html.contentItem(html.top(" - " + item.getModel(), u), html.end(), item, u));
            }
        }
    }

}
