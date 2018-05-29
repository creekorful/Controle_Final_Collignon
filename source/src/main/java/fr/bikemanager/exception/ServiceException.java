package fr.bikemanager.exception;

import javax.ws.rs.WebApplicationException;

public abstract class ServiceException extends WebApplicationException {

    private String error;

    public ServiceException() {

    }

    public ServiceException(String msg) {
        this.error = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
