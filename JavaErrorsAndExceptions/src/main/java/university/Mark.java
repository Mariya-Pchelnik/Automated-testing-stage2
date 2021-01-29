package university;

import exceptions.IllegalMarkException;

public class Mark {
    private int value;
    private Subjects subject;

    public Mark(int value, Subjects subject) throws IllegalMarkException {
        setValue(value);
        this.subject = subject;
    }

    public void setValue(int value) throws IllegalMarkException {
        if (value>10||value<0){
            throw new IllegalMarkException("Mark value cann't be"+value);
        }
        this.value = value;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public int getValue() {
        return value;
    }

    public Subjects getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "value=" + value +
                ", subject=" + subject +
                '}';
    }
}
