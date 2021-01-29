package university;

import exceptions.EmptySubjectsListException;

import java.util.*;

public class Student {

    private String name;
    private List<Mark> marks;

    public Student(String name, List<Mark> marks)
            throws EmptySubjectsListException {
        this.name = name;
        if (marks.isEmpty()) {
            throw new EmptySubjectsListException("Student "
                    +name+"has no subjects");
        }
        this.marks = marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    public double getAverageMark() {
        int sumOfMarks = 0;

        for (Mark mark : marks) {
            sumOfMarks += mark.getValue();
        }
        return (double)sumOfMarks / marks.size();
    }

    @Override
    public String toString() {
        return "\nStudent: "
                + " " + name
                + ", marks: "
                + marks;
    }
}
