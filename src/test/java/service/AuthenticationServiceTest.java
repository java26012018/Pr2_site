package service;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpSession;

public class AuthenticationServiceTest {


    private HttpSession session;

    @Before
    public void init(){
        session = mock(HttpSession.class);
        doNothing().when(session).removeAttribute(anyString());
    }

    @Test
    public void removeUserAttributeFromSessionTest(){
        String exit = null;
        assertNull(exit);
        AuthenticationService.removeUserAttributeFromSession(exit, session);
        verify(session, times(0)).removeAttribute("user");
        exit = "true";
        assertNotNull(exit);
        AuthenticationService.removeUserAttributeFromSession(exit, session);
        verify(session, times(1)).removeAttribute("user");
    }
}
