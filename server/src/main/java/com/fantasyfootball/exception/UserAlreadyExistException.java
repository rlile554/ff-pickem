package com.fantasyfootball.exception;

import java.io.Serializable;

public final class UserAlreadyExistException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -1233294159696474805L;

    public UserAlreadyExistException() {
        super();
    }

    public UserAlreadyExistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyExistException(final String message) {
        super(message);
    }

    public UserAlreadyExistException(final Throwable cause) {
        super(cause);
    }

}
