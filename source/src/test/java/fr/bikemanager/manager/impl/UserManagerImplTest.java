package fr.bikemanager.manager.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.bikemanager.dao.UserDao;
import fr.bikemanager.entity.User;

public class UserManagerImplTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserManagerImpl userManager;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        String username = "test";
        String password = "test2";

        Mockito.when(userDao.findUserByCredentials(username, password)).thenReturn(null);

        Assert.assertNull(userManager.login(username, password));
    }

    @Test
    public void testLoginWithValidCredentials() {
        String username = "test";
        String password = "test2";

        Mockito.when(userDao.findUserByCredentials(username, password)).thenReturn(new User());

        Assert.assertNotNull(userManager.login(username, password));
    }

    @Test
    public void testIsAdminNotAdminWithValidToken() {
        String token = "testToken";
        User user = new User("creek", "test", false);

        Mockito.when(userDao.findByAuthToken(token)).thenReturn(user);

        Assert.assertFalse(userManager.isAdmin(token));
    }

    @Test
    public void testIsAdminAdminWithValidToken() {
        String token = "testToken";
        User user = new User("creek", "test", true);

        Mockito.when(userDao.findByAuthToken(token)).thenReturn(user);

        Assert.assertTrue(userManager.isAdmin(token));
    }

    @Test
    public void testIsAdminWithInvalidToken() {
        String token = "testTokdeededeen";

        Mockito.when(userDao.findByAuthToken(token)).thenReturn(null);

        Assert.assertFalse(userManager.isAdmin(token));
    }

    @Test
    public void testGetByAuthTokenWithInvalidToken() {
        String token = "testToken";

        Mockito.when(userDao.findByAuthToken(token)).thenReturn(null);

        Assert.assertNull(userManager.getByAuthToken(token));
    }

    @Test
    public void testGetByAuthTokenWithValidToken() {
        String token = "testToken";
        User user = new User("creek", "test", true);

        Mockito.when(userDao.findByAuthToken(token)).thenReturn(user);

        Assert.assertNotNull(userManager.getByAuthToken(token));
    }
}