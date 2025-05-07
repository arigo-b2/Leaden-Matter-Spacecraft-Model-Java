package lms.exceptions;

import java.io.Serializable;

/***
 * Special Runtime exception -- It is a Runtime (unchecked exception) which is unlike the normal `extends Exception`
 * as it needs to be able to added to a method without needing to have it in a method signature.
 * The UnsupportedActionException class is a type of runtime exception (unchecked exception) that is used to indicate
 * that an unsupported action or operation was attempted.
 * This class extends the base RuntimeException class in order to provide custom error handling for situations where
 * a method needs to throw an exception, but the exception does not need to be included in the method signature.
 * This class is designed to be used in situations where an action or operation is attempted but is not supported by the
 * current state or configuration of the system. By throwing an instance of this exception, the developer can signal to
 * the calling code that the requested action cannot be performed.
 * The constructors for this class allow for the creation of custom error messages and the inclusion of additional
 * information about the cause of the error, if desired.
 */
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

    /**
     * Constructs a new UnsupportedActionException with the specified cause.
     * @param cause A Throwable object representing the cause of this exception.
     */
    public UnsupportedActionException(Throwable cause) {
        super(cause);
    }

}
