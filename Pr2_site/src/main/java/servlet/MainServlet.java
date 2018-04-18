package servlet;

import dao.ItemDao;
import entity.Item;
import entity.User;
import html.HtmlFormer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("exit") != null){
            request.getSession().removeAttribute("user");
        }
        User u = (User)request.getSession().getAttribute("user");
        List<Item> items;
        String cat = request.getParameter("cat");
        String q = request.getParameter("q");
        if(cat != null){
            items = ItemDao.getByCategoty(cat);
        }else if(q != null){
            List<Item> allItems = ItemDao.get();
            items = new LinkedList<>();
            for(Item i:allItems){
                if(i.getModel().contains(q)){
                    items.add(i);
                }
            }
        }else{
            items = ItemDao.get();
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(HtmlFormer.contentMain(HtmlFormer.top("", u), HtmlFormer.end(), items));
        }
    }

}
