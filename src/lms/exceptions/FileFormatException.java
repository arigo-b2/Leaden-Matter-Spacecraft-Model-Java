package lms.exceptions;

import java.io.Serializable;

/***
 * The FileFormatException class is an exception that is thrown when a file being read or processed is
 * not in the expected format. This class extends the base Exception class in order to provide custom
 * error handling for file format errors.
 */
public class FileFormatException extends Exception implements Serializable {

    /***
     * Constructs a new FileFormatException with no message.
     */
    public FileFormatException() {
        super();
    }


}
