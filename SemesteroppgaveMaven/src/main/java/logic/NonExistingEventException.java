package logic;

import java.lang.Exception;
/**
 *
 * @author sarah
 */
public class NonExistingEventException extends Exception {
    public NonExistingEventException(String msg) {
        super(msg);
    }
}
