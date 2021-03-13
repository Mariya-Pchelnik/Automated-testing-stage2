package university;

import exceptions.EmptyStudentsListException;
import exceptions.EmptySubjectsListException;

import java.util.List;

public class Group {
    private int number;
    private List<Student> students;

    public Group(int number, List<Student> students) {
        this.number = number;
        this.students = students;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public int getNumber() {
        return number;
    }

    public List<Student> getStudents() throws EmptyStudentsListException {
        if (students.isEmpty()) {
            throw new EmptyStudentsListException("There are no " +
                    "students in the group " + number);
        }
        return students;
    }

    public double getAverageSubjectMark(Subjects subject)
            throws EmptyStudentsListException, EmptySubjectsListException {
        int sumOfMarks = 0;
        int numberOfMarks = 0;

        for (Student student : getStudents()) {
            for (Mark mark : student.getMarks()) {
                if (mark.getSubject().equals(subject)) {
                    sumOfMarks += mark.getValue();
                    numberOfMarks++;
                }
            }
        }
        return (double) sumOfMarks / numberOfMarks;
    }

    @Override
    public String toString() {
        return "\nGroup: " +
                +number +
                ". Students in the group: " + students;
    }
}
