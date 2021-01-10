package exceptions;

public class EmptySubjectsList extends Exception{
    public EmptySubjectsList() {
    }

    public EmptySubjectsList(String message) {
        super(message);
    }

    public EmptySubjectsList(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptySubjectsList(Throwable cause) {
        super(cause);
    }
}
