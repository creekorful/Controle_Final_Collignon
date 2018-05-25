package fr.bikemanager.rest.impl;

import fr.bikemanager.dto.CredentialsDto;
import fr.bikemanager.dto.TokenDto;
import fr.bikemanager.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import fr.bikemanager.rest.SessionResource;

import javax.inject.Inject;

@Component
public class SessionResourceImpl implements SessionResource {

    private UserManager userManager;

    @Autowired
    public SessionResourceImpl(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public TokenDto login(CredentialsDto credentialsDto) {
        String token = userManager.login(credentialsDto.getUsername(), credentialsDto.getPassword());
        return new TokenDto(token);
    }
}