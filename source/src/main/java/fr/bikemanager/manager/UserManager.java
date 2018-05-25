package fr.bikemanager.manager;

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
}
