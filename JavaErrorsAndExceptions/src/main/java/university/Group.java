package university;

import exceptions.EmptyStudentsListException;

import java.util.List;

public class Group {
    private int number;
    private List<Student> students;

    public Group(int number, List<Student> students)
            throws EmptyStudentsListException {
        this.number = number;
        if (students.isEmpty()) {
            this.number = number;
            throw new EmptyStudentsListException("There are no " +
                    "students in the group "+number);
        }else {
        this.students = students;
    }}

    public void setNumber(int number) {
        this.number = number;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getNumber() {
        return number;
    }

    public List<Student> getStudents() {
        return students;
    }

    public double getAverageSubjectMark(Subjects subject) {
        int sumOfMarks = 0;
        int numberOfMarks = 0;

        for (Student student : students) {
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
