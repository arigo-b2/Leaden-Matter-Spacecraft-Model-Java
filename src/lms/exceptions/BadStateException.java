package lms.exceptions;

import java.io.Serializable;

/***
 * Special Runtime exception - It is a Runtime (unchecked exception) which is unlike the normal `extends Exception`
 * because it needs to be able to be added to a method without needing to have it in a method signature.
 */
public class BadStateException extends RuntimeException implements Serializable {


    public BadStateException() {
        super();
    }


    public BadStateException(String message) {
        super(message);
    }


    public BadStateException(String message, Throwable cause) {
        super(message, cause);
    }


    public BadStateException(Throwable cause) {
        super(cause);
    }

}
