package fr.bikemanager.dao;

import fr.bikemanager.entity.User;

public interface UserDao {

    /**
     * Find an user using his username/password credentials
     *
     * @param username the username
     * @param password the user password
     * @return the associated user or null if not found
     */
    User findUserByCredentials(String username, String password);

    /**
     * Find an user using his auth token
     *
     * @param authToken the user auth token
     * @return the associated user or null if not found
     */
    User findByAuthToken(String authToken);

    /**
     * Save an user into the database
     *
     * @param user the user to save
     */
    void save(User user);
}
