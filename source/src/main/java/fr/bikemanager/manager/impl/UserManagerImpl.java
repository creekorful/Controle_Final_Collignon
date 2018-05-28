package fr.bikemanager.manager.impl;

import fr.bikemanager.dao.UserDao;
import fr.bikemanager.manager.UserManager;
import fr.bikemanager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class UserManagerImpl implements UserManager {

    private UserDao userDao;

    @Autowired
    public UserManagerImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public String login(String username, String password) {
        User user = userDao.findUserByCredentials(username, password);
        String token = null;

        if (user != null) {
            token = generateAuthToken();
            user.setApiToken(token);
        }

        return token;
    }

    @Transactional
    @Override
    public boolean isAdmin(String authToken) {
        User user = userDao.findByAuthToken(authToken);
        return user != null && user.isAdmin();
    }

    @Transactional
    @Override
    public User getByAuthToken(String authToken) {
        return userDao.findByAuthToken(authToken);
    }

    /**
     * Generate an auth token to be used with the api
     *
     * @return a auth token
     */
    private static String generateAuthToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
