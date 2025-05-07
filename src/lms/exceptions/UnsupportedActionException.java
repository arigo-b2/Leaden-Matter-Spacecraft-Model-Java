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



}
