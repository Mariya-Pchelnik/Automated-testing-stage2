package exceptions;

public class EmptyGroupList extends Exception{
    public EmptyGroupList() {
    }

    public EmptyGroupList(String message) {
        super(message);
    }

    public EmptyGroupList(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyGroupList(Throwable cause) {
        super(cause);
    }
}
