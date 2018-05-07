package dao;

import entity.User;
import org.junit.Test;
import spring.SpringContextHolder;

import java.util.Random;

import static org.junit.Assert.*;

public class UserDaoTest {

    private final UserDao udao = (UserDao) SpringContextHolder.getContext().getBean("udao");

    private static final String LOGIN = "some_login";
    private static final String PASSWORD = "some_pass";
    private static final String BASKET = "some_basket";

    @Test
    public void userCreationAndRemovingTest() {
        User u = new User(new Random().nextInt(), LOGIN, PASSWORD, BASKET);
        udao.add(u);
        User received = udao.getByLogin(LOGIN);
        assertNotNull(received);
        assertEquals(u.getId(), received.getId());
        assertEquals(PASSWORD, received.getPass());
        assertEquals(BASKET, received.getBasket());
        udao.remove(received);
        received = udao.getByLogin(LOGIN);
        assertNull(received);
    }
}
