package fr.bikemanager.dto;

import java.io.Serializable;

public class CredentialsDto implements Serializable {

    private String username;

    private String password;

    public CredentialsDto() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
