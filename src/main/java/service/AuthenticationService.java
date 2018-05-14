package service;

import javax.servlet.http.HttpSession;

public class AuthenticationService {

    public static void removeUserAttributeFromSession(String exit, HttpSession session){
        if(exit != null){
            session.removeAttribute("user");
        }
    }

}
