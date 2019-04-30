package semesteroppgave;
import java.lang.Exception;

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
