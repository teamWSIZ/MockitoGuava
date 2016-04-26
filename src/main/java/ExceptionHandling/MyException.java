package ExceptionHandling;

/**
 * Created by mareckip on 26.04.16.
 */
public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
