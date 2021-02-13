package university;

import exceptions.*;

import java.util.List;

public class University {
    String name;
    List<Faculty> faculties;

    public University(String name, List<Faculty> faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public String getName() {
        return name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public Faculty getFacultyByName(String facultyName)
            throws EmptyFacultiesListException, ObjectWasNotFoundException {
        Faculty faculty = null;

        if (faculties.isEmpty()) {
            throw new EmptyFacultiesListException("There are no faculties" +
                    " in the university");
        }
        for (Faculty currentFaculty : faculties) {
            if (currentFaculty.getName().equals(facultyName)) {
                faculty = currentFaculty;
            }
        }
        if (faculty == null) {
            throw new ObjectWasNotFoundException("Faculty " + facultyName
                    + "wasn't found");
        }
        return faculty;
    }

    public double getAverageSubjectMarkForTheUniversity(Subjects subject)
            throws EmptyFacultiesListException, EmptyGroupListException,
            EmptyStudentsListException, EmptySubjectsListException {
        int sumOfMarks = 0;
        int numberOfMarks = 0;

        if (faculties.isEmpty()) {
            throw new EmptyFacultiesListException("There are no faculties" +
                    " in the university");
        }
        for (Faculty faculty : faculties) {
            if (faculty.getGroups().isEmpty()) {
                throw new EmptyGroupListException("There are no groups at the faculty"
                        + faculty.getName());
            }
            for (Group group : faculty.getGroups()) {
                if (group.getStudents().isEmpty()) {
                    throw new EmptyStudentsListException("There are no " +
                            "students in the group " + group.getNumber());
                }
                for (Student student : group.getStudents()) {
                    if (student.getMarks().isEmpty()) {
                        throw new EmptySubjectsListException("Student "
                                + student.getName() + "has no subjects");
                    }
                    for (Mark mark : student.getMarks()) {
                        if (mark.getSubject().equals(subject)) {
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
