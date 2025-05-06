package lms.exceptions;

import java.io.Serializable;

/***
 * Special Runtime exception - It is a Runtime (unchecked exception) which is unlike the normal `extends Exception`
 * because it needs to be able to be added to a method without needing to have it in a method signature.
 */
public class BadStateException extends RuntimeException implements Serializable {

    /***
     * Constructs a new BadStateException with no message.
     */
    public BadStateException() {
        super();
    }

    /***
     * Constructs a new BadStateException with the specified error message.
     * @param message A String containing the error message to be associated with this exception.
     */
    public BadStateException(String message) {
        super(message);
    }

    /**
     * Constructs a new BadStateException with the specified detail message and cause.
     * @param message the detail message for exception
     * @param cause the cause for exception
     */
    public BadStateException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new BadStateException with the specified cause.
     * @param cause the cause for exception
     */
    public BadStateException(Throwable cause) {
        super(cause);
    }

}
