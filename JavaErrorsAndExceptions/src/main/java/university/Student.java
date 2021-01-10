package university;

import exceptions.EmptySubjectsList;
import exceptions.IllegalMarkException;

import java.util.*;

public class Student {

    private String name;
    private Map<Subjects, List<Integer>> marks;

    public Student(String name, Map<Subjects, List<Integer>> marks)
            throws EmptySubjectsList, IllegalMarkException {
        if (marks.isEmpty()) {
            throw new EmptySubjectsList("У студента нет ни одного предмета");
        }
        for (Subjects subject : marks.keySet()) {
            for (Integer mark : marks.get(subject)) {
                if (mark > 10 || mark < 0) {
                    throw new IllegalMarkException("Оценка не может быть равна "
                            + mark);
                }
            }
        }
        this.name = name;
        this.marks = marks;
    }

    public Map<Subjects, List<Integer>> getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\nСтудент: "
                + " " + name
                + ", оценки: "
                + marks;
    }
}
