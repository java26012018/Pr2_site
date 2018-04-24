package service;

import dao.ItemDao;
import entity.Item;
import org.junit.Test;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;
import spring.SpringContextHolder;


public class ItemServiceTest {
    private List<Item> list=null;
    private  static final ItemDao idao = (ItemDao) SpringContextHolder.getContext().getBean("idao");

//    @Before
//    public void init(){
//        list = mock(List.class);
//    }
    @Test
    public void formItemsForMainServletTest (){


        String cat;
        String q;
       assertNull(list);
        cat="e";
        list= idao.getByCategoty(cat);
        assertNotNull(list);
        assertEquals(list.get(1).getCat(), cat );
        list=null; q="3";
            List<Item> allItems = idao.get();
            list = new LinkedList<>();
            for (Item i : allItems) {
                if (i.getModel().contains(q)) {
                    list.add(i);
                }
            }
        assertNotNull(list);

}}
