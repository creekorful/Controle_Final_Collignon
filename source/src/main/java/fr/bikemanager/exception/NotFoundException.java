package fr.bikemanager.exception;

/**
 * Exception throw when an entity has not been found
 */
public class NotFoundException extends ServiceException {

    public NotFoundException() {

    }

    public NotFoundException(String msg) {
        super(msg);
    }
}
