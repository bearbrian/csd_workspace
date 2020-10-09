package com.workspace.authenticate;

import org.junit.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class AuthenticationServiceTest {

    User stubUser;
    User realUser;
    UserDao userDao;
    AuthenticationService authService;

    @Before
    public void setUp(){
        // data set
        realUser = new User();
        realUser.setName("Puneet");
        realUser.setDob("10/10/10");
        realUser.setCountry("India");

        // mock - simulate getting real user
        userDao = mock(UserDao.class);
        when(userDao.getUserByName("Puneet")).thenReturn(realUser);

        // initialization
        authService = new AuthenticationService();
    }

    @After
    public void tearDown(){}

    @Test
    public void checkAuthorizedUser() throws Exception {
        // data set
        stubUser = new User();
        stubUser.setName("Puneet");
        stubUser.setDob("10/10/10");
        stubUser.setCountry("India");

        // assertion
        Boolean expected = true;
        Boolean actual = authService.authorizedUser(stubUser, userDao.getUserByName("Puneet"));
        assertEquals(expected, actual);

        // verify the userDao is invoked
        verify(userDao).getUserByName("Puneet");
    }

    @Test
    public void checkUnauthorizedUserWithDifferentName() throws Exception {
        // data set
        stubUser = new User();
        stubUser.setName("Vineet");
        stubUser.setDob("10/10/10");
        stubUser.setCountry("India");

        // assertion
        Boolean expected = false;
        Boolean actual = authService.authorizedUser(stubUser, userDao.getUserByName("Puneet"));
        assertEquals(expected, actual);

        // verify the userDao is invoked
        verify(userDao).getUserByName("Puneet");
    }

    @Test
    public void checkUnauthorizedUserWithDifferentDob() throws Exception {
        // data set
        stubUser = new User();
        stubUser.setName("Puneet");
        stubUser.setDob("10/10/11");
        stubUser.setCountry("India");

        // assertion
        Boolean expected = false;
        Boolean actual = authService.authorizedUser(stubUser, userDao.getUserByName("Puneet"));
        assertEquals(expected, actual);

        // verify the userDao is invoked
        verify(userDao).getUserByName("Puneet");
    }

    @Test
    public void checkUnauthorizedUserWithDifferentCountry() throws Exception {
        // data set
        stubUser = new User();
        stubUser.setName("Puneet");
        stubUser.setDob("10/10/10");
        stubUser.setCountry("America");

        // assertion
        Boolean expected = false;
        Boolean actual = authService.authorizedUser(stubUser, userDao.getUserByName("Puneet"));
        assertEquals(expected, actual);

        // verify the userDao is invoked
        verify(userDao).getUserByName("Puneet");
    }

}

