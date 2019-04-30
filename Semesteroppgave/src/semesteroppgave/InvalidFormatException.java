package semesteroppgave;
import java.lang.Exception;

/* File contains various subclasses of Exception which use 
    the built in constructor of the super class with the
    error-message of the given exception as a parameter
*/

public class InvalidFormatException extends Exception {
    public InvalidFormatException(String msg) {
        super(msg);
    }
}

class InvalidDateFormatException extends Exception {
    public InvalidDateFormatException(String msg){
        super(msg);
    }
}

class InvalidTimeOverlapException extends Exception {
    public InvalidTimeOverlapException(String msg) {
        super(msg);
    }
}

class InvalidObjectTypeException extends Exception {
    public InvalidObjectTypeException(String msg) {
        super(msg);
    }
}
