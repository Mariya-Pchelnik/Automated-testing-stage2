package exceptions;

public class EmptyFacultiesListException extends Exception {
    public EmptyFacultiesListException() {
    }

    public EmptyFacultiesListException(String message) {
        super(message);
    }

    public EmptyFacultiesListException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyFacultiesListException(Throwable cause) {
        super(cause);
    }
}
