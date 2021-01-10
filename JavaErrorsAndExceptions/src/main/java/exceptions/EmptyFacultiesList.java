package exceptions;

public class EmptyFacultiesList extends Exception {
    public EmptyFacultiesList() {
    }

    public EmptyFacultiesList(String message) {
        super(message);
    }

    public EmptyFacultiesList(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyFacultiesList(Throwable cause) {
        super(cause);
    }
}
