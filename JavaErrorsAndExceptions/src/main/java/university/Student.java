package university;

import exceptions.EmptySubjectsListException;
import exceptions.IllegalMarkException;

import java.util.*;

public class Student {
    private String name;
    private List<Mark> marks;

    public Student(String name, List<Mark> marks) {
        this.name = name;
        this.marks = marks;
    }

    public void addMark(Mark mark)
            throws IllegalMarkException {
        marks.add(mark);
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    public double getAverageMark()
            throws EmptySubjectsListException {
        int sumOfMarks = 0;

        if (marks.isEmpty()) {
            throw new EmptySubjectsListException("Student "
                    + name + "has no subjects");
        }
        for (Mark mark : marks) {
            sumOfMarks += mark.getValue();
        }
        return (double) sumOfMarks / marks.size();
    }

    @Override
    public String toString() {
        return "\nStudent: "
                + " " + name
                + ", marks: "
                + marks;
    }
}
