package exception;

public class NullKeyException extends Exception {
    private String message;

    public NullKeyException() {
        message = ("You can't pass a key = null");
    }

    public String getMessage() {
        return message;
    }
}
