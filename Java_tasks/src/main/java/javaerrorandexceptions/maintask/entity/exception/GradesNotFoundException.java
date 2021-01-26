package javaerrorandexceptions.maintask.entity.exception;

public class GradesNotFoundException extends RuntimeException {

    public GradesNotFoundException(String message) {
        super(message);
    }

    public GradesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
