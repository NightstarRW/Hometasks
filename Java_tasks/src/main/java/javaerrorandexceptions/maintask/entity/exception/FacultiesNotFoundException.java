package javaerrorandexceptions.maintask.entity.exception;

public class FacultiesNotFoundException extends RuntimeException {

    public FacultiesNotFoundException(String message) {
        super(message);
    }

    public FacultiesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
