package fr.bikemanager.dto;

import java.io.Serializable;

/**
 * Dto used to return error code to client
 */
public class ErrorDto implements Serializable {

    private String error;

    public ErrorDto() {

    }

    public ErrorDto(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
