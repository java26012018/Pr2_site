package servlet;

import dao.ItemDao;
import entity.Item;
import entity.User;
import html.HtmlFormer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ItemServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User)request.getSession().getAttribute("user");
        String idString = request.getParameter("id");
        if (idString == null) {
            response.sendRedirect("/Pr2_site/main");
        } else {
            int id = 0;
            try{
                id = Integer.parseInt(idString);
            }catch(Exception e){e.printStackTrace();}
            Item item = ItemDao.getById(id);
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println(HtmlFormer.contentItem(HtmlFormer.top(" - "+item.getModel(), u), HtmlFormer.end(), item, u));
            }
        }
    }

}
