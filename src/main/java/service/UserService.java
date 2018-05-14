package service;

import entity.User;

import javax.servlet.http.HttpSession;

public class UserService {
    public static User getUserFromSession(HttpSession session) {
        return (User) session.getAttribute("user");
    }
}
