package exceptions;

public class EmptyGroupListException extends Exception{
    public EmptyGroupListException() {
    }

    public EmptyGroupListException(String message) {
        super(message);
    }

    public EmptyGroupListException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyGroupListException(Throwable cause) {
        super(cause);
    }
}
