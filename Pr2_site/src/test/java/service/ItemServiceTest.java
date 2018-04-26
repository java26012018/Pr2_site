package service;

import dao.ItemDao;
import entity.Item;
import org.junit.Test;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;
import spring.SpringContextHolder;


public class ItemServiceTest {

    private  static final ItemDao idao = (ItemDao) SpringContextHolder.getContext().getBean("idao");

    @Test
    public void formItemsForMainServletTest (){
        List<Item> list=null;
        List<Item> emptyList = new LinkedList<>();
        String cat;
        String q;
       assertNull(list);
        cat="e";
        list= idao.getByCategoty(cat);
        assertNotNull(list);
        assertEquals(list.get(1).getCat(), cat );

        cat="NONAME_cat";
        list=idao.getByCategoty(cat);
        assertEquals(emptyList, list);
        q="3";
            List<Item> allItems = idao.get();
            list = new LinkedList<>();
            for (Item i : allItems) {
                if (i.getModel().contains(q)) {
                    list.add(i);
                }
            }
        assertNotNull(list);
        q="NONAME_q";
            allItems = idao.get();
            list = new LinkedList<>();
            for (Item i : allItems) {
                if (i.getModel().contains(q)) {
                    list.add(i);
                }
        }
        assertEquals(emptyList, list);


}}
