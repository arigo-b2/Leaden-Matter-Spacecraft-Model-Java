package lms.exceptions;

import java.io.Serializable;


public class BadStateException extends RuntimeException implements Serializable {


    public BadStateException() {
        super();
    }


    public BadStateException(String message) {
        super(message);
    }




}
