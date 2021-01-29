package university;

import exceptions.EmptyFacultiesListException;

import java.util.List;

public class University {
    String name;
    List<Faculty> faculties;

    public University(String name, List<Faculty> faculties)
            throws EmptyFacultiesListException {
        this.name = name;
        if (faculties.isEmpty()) {
            throw new EmptyFacultiesListException("There are no faculties" +
                    " in the university");
        } else {
            this.faculties = faculties;
        }
    }

    public String getName() {
        return name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public double getAverageSubjectMarkInTheGroupAtTheFaculty(
            String facultyName, int groupNumber, Subjects subject) {
        double averageMark = 0;

        for (Faculty faculty : faculties) {
            if (faculty.getName().equals(facultyName)) {
                for (Group group : faculty.getGroups()) {
                    if (group.getNumber() == groupNumber) {
                        averageMark = group.getAverageSubjectMark(subject);
                    }
                }
            }

        }
        return averageMark;
    }

    public double getAverageSubjectMarkForTheUniversity(Subjects subject) {
        int sumOfMarks = 0;
        int numberOfMarks = 0;

        for (Faculty faculty : faculties) {
            for (Group group : faculty.getGroups()) {
                for (Student student : group.getStudents()) {
                    for (Mark mark : student.getMarks()) {
                        if (mark.getSubject() == subject) {
                            sumOfMarks += mark.getValue();
                            numberOfMarks++;
                        }
                    }
                }
            }
        }
        return (double) sumOfMarks / numberOfMarks;
    }

    @Override
    public String toString() {
        return "University" + name +
                "\nFaculties: " + faculties;
    }
}
