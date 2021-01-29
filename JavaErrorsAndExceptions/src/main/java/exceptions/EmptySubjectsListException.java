package exceptions;

public class EmptySubjectsListException extends Exception{
    public EmptySubjectsListException() {
    }

    public EmptySubjectsListException(String message) {
        super(message);
    }

    public EmptySubjectsListException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptySubjectsListException(Throwable cause) {
        super(cause);
    }
}
