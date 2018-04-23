package dao;

import entity.User;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class UserDaoTest {
    private static final String LOGIN = "some_login";
    private static final String PASSWORD = "some_pass";
    private static final String BASKET = "some_basket";

    @Test
    public void userCreationAndRemovingTest() {
        User u = new User(new Random().nextInt(), LOGIN, PASSWORD, BASKET);
        UserDao.add(u);
        User received = UserDao.getByLogin(LOGIN);
        assertNotNull(received);
        assertEquals(u.getId(), received.getId());
        assertEquals(PASSWORD, received.getPass());
        assertEquals(BASKET, received.getBasket());
        UserDao.remove(received);
        received = UserDao.getByLogin(LOGIN);
        assertNull(received);
    }
}
