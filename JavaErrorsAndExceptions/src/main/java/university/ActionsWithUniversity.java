package university;

import exceptions.*;

import java.util.List;

public class ActionsWithUniversity {
    private List<Faculty> faculties;
    private List<Group> groups;
    private List<Student> students;

    public ActionsWithUniversity() throws EmptyFacultiesList, EmptySubjectsList,
            EmptyGroupList, EmptyStudentsList, IllegalMarkException {
        UniversityBuilder universityBuilder = new UniversityBuilder();
        if (universityBuilder.getFaculties().isEmpty()) {
            throw new EmptyFacultiesList("В университете нет ни одного факультета");
        }
        this.faculties = universityBuilder.getFaculties();
        this.groups = universityBuilder.getGroups();
        this.students = universityBuilder.getStudents();
        System.out.println(universityBuilder.toString());
    }

    public double getAverageStudentMark(String studentName) {
        int marksSum = 0;
        int marksAmount = 0;

        for (Student student : students) {
            if (student.getName().equals(studentName)) {
                for (Subjects subject : student.getMarks().keySet()) {
                    for (Integer mark : student.getMarks().get(subject)) {
                        marksSum += mark;
                        marksAmount++;
                    }
                }
            }
        }

        return (double) marksSum / marksAmount;
    }

    public double getAverageSubjectMarkInGroup(String facultyName,
                                               int groupNumber, Subjects subjectName) {
        int markSum = 0;
        int marksAmount = 0;

        for (Faculty faculty : faculties) {
            if (faculty.getName().equals(facultyName)) {
                for (Group group : faculty.getGroupsInTheFaculty()) {
                    if (group.getNumber() == groupNumber) {
                        for (Student student : group.getStudentsInTheGroup()) {
                            for (Subjects subject : student.getMarks().keySet()) {
                                if (subject.equals(subjectName)) {
                                    for (Integer mark : student.getMarks().get(subject)) {
                                        marksAmount++;
                                        markSum += mark;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return (double) markSum / marksAmount;
    }

    public double getAverageSubjectMarkInUniversity(Subjects subjectName) {
        int marksSum = 0;
        int marksAmount = 0;

        for (Student student : students) {
            for (Subjects subject : student.getMarks().keySet()) {
                if (subject.equals(subjectName)) {
                    for (Integer mark : student.getMarks().get(subject)) {
                        marksAmount++;
                        marksSum += mark;
                    }
                }
            }
        }
        return (double) marksSum / marksAmount;
    }
}
