package exceptions;

public class EmptyStudentsList extends Exception{
    public EmptyStudentsList() {
    }

    public EmptyStudentsList(String message) {
        super(message);
    }

    public EmptyStudentsList(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyStudentsList(Throwable cause) {
        super(cause);
    }
}
