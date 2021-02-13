package exceptions;

public class ObjectWasNotFoundException extends Exception {
    public ObjectWasNotFoundException() {
    }

    public ObjectWasNotFoundException(String message) {
        super(message);
    }

    public ObjectWasNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectWasNotFoundException(Throwable cause) {
        super(cause);
    }
}
