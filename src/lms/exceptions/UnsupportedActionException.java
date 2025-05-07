package lms.exceptions;

import java.io.Serializable;

public class UnsupportedActionException extends RuntimeException implements Serializable {

    /**
     * Constructs a new UnsupportedActionException with no message.
     */
    public UnsupportedActionException() {
        super();
    }

    /**
     * Constructs a new UnsupportedActionException with the specified error message.
     * @param message A String containing the error message to be associated with this exception.
     */
    public UnsupportedActionException(String message) {
        super(message);
    }

    /**
     * Constructs a new UnsupportedActionException with the specified error message and cause.
     * @param message A String containing the error message to be associated with this exception.
     * @param cause A Throwable object representing the cause of this exception.
     */
    public UnsupportedActionException(String message, Throwable cause) {
        super(message, cause);
    }



}
