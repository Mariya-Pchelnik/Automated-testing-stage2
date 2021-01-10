package university;

import exceptions.EmptyStudentsList;

import java.util.List;

public class Group {
    private int number;
    private List<Student> studentsInTheGroup;

    public Group(int number, List<Student> studentsInTheGroup)
            throws EmptyStudentsList {
        if (studentsInTheGroup.isEmpty()) {
            throw new EmptyStudentsList("Нет ни одного студента в группе");
        }
        this.number = number;
        this.studentsInTheGroup = studentsInTheGroup;
    }

    public int getNumber() {
        return number;
    }

    public List<Student> getStudentsInTheGroup() {
        return studentsInTheGroup;
    }

    @Override
    public String toString() {
        return "\nГруппа: " +
                +number +
                ". Студенты в группе: " + studentsInTheGroup;
    }
}
