package javaerrorandexceptions.maintask.entity.exception;

public class StudentsNotFountException extends RuntimeException {

    public StudentsNotFountException(String message) {
        super(message);
    }

    public StudentsNotFountException(String message, Throwable cause) {
        super(message, cause);
    }
}
