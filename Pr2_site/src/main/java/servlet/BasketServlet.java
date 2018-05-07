package servlet;

import com.google.gson.Gson;
import dao.ItemDao;
import dao.UserDao;
import entity.Basket;
import entity.Item;
import entity.User;
import html.HtmlFormer;
import service.UserService;
import spring.SpringContextHolder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class BasketServlet extends HttpServlet {

    private final ItemDao idao = (ItemDao) SpringContextHolder.getContext().getBean("idao");
    private final UserDao udao = (UserDao) SpringContextHolder.getContext().getBean("udao");
    private final HtmlFormer html = (HtmlFormer) SpringContextHolder.getContext().getBean("html");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User u = UserService.getUserFromSession(request.getSession());
        if (u == null) {
            response.sendRedirect("/Pr2_site/main");
        } else {
            String idString = request.getParameter("id");
            Gson gson = new Gson();
            Basket b = gson.fromJson(u.getBasket(), Basket.class);
            if (idString != null) {
                Integer id = null;
                try {
                    id = Integer.valueOf(idString);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (id != null) {
                    if (id.equals(0)) {
                        b.items.clear();
                    }
                    if (id > 0) {
                        b.items.add(id);
                    }
                    if (id < 0) {
                        id = id * -1;
                        b.items.remove(id);
                    }
                    u.setBasket(gson.toJson(b));
                    udao.update(u);
                }
                response.sendRedirect("/Pr2_site/basket");
            } else {
                List<Item> items = new LinkedList<>();
                for (Integer id : b.items) {
                    items.add(idao.getById(id));
                }
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    out.println(html.contentBasket(html.top("Your Basket", u), html.end(), items));
                }

            }

        }
    }

}
