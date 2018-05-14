package service;

import dao.ItemDao;
import entity.Item;
import spring.SpringContextHolder;

import java.util.LinkedList;
import java.util.List;

public class ItemService {

    private static final ItemDao idao = (ItemDao) SpringContextHolder.getContext().getBean("idao");

    public static List<Item> formItemsForMainServlet(String cat, String q) {
        List<Item> items;
        if (cat != null) {
            items = idao.getByCategoty(cat);
        } else if (q != null) {
            List<Item> allItems = idao.get();
            items = new LinkedList<>();
            for (Item i : allItems) {
                if (i.getModel().contains(q)) {
                    items.add(i);
                }
            }
        } else {
            items = idao.get();
        }
        return items;
    }
}
