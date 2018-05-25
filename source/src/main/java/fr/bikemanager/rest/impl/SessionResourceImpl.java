package fr.bikemanager.rest.impl;

import fr.bikemanager.manager.UserManager;
import org.springframework.stereotype.Component;
import fr.bikemanager.rest.SessionResource;

import javax.inject.Inject;

@Component
public class SessionResourceImpl implements SessionResource {

    @Inject
    private UserManager userManager;

    @Override
    public String login(String username, String password) {
        return userManager.login(username, password);
    }
}
