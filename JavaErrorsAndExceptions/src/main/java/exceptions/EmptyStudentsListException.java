package exceptions;

public class EmptyStudentsListException extends Exception{
    public EmptyStudentsListException() {
    }

    public EmptyStudentsListException(String message) {
        super(message);
    }

    public EmptyStudentsListException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyStudentsListException(Throwable cause) {
        super(cause);
    }
}
