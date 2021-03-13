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

    public List<Faculty> getFaculties() throws EmptyFacultiesListException {
        if (faculties.isEmpty()) {
            throw new EmptyFacultiesListException("There are no faculties" +
                    " in the university");
        }
        return faculties;
    }

    public Faculty getFacultyByName(String facultyName)
            throws EmptyFacultiesListException, ObjectWasNotFoundException {
        Faculty faculty = null;

        for (Faculty currentFaculty : getFaculties()) {
            if (currentFaculty.getName().equals(facultyName)) {
                faculty = currentFaculty;
                break;
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

        for (Faculty faculty : getFaculties()) {
            for (Group group : faculty.getGroups()) {
                for (Student student : group.getStudents()) {
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
