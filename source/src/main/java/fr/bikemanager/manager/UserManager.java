package fr.bikemanager.manager;

import fr.bikemanager.entity.User;

public interface UserManager {

    /**
     * Login an user using his username/password
     * This will compute a token to use with the api
     *
     * @param username the username
     * @param password the user password
     * @return the generated user auth token or null if credentials are invalid
     */
    String login(String username, String password);

    /**
     * Check if an user is admin using the provided auth token
     *
     * @param authToken the user auth token
     * @return true if the user is admin, false otherwise
     */
    boolean isAdmin(String authToken);

    /**
     * find an user using his auth token
     *
     * @param authToken the user auth token
     * @return the associated user or null if invalid auth token
     */
    User getByAuthToken(String authToken);
}
