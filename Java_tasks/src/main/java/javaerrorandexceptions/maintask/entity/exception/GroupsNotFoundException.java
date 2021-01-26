package javaerrorandexceptions.maintask.entity.exception;

public class GroupsNotFoundException extends RuntimeException{

    public GroupsNotFoundException(String message) {
        super(message);
    }

    public GroupsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
