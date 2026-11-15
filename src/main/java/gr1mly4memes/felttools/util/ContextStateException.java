package gr1mly4memes.felttools.util;

public class ContextStateException extends RuntimeException {

    public ContextStateException() {
        super();
    }

    public ContextStateException(String message) {
        super(message);
    }

    public ContextStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContextStateException(Throwable cause) {
        super(cause);
    }
}
