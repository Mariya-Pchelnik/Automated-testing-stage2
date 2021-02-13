import exceptions.*;
import university.*;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        try {
            Student student1 = new Student("Иванов", Arrays.asList(
                    new Mark(10, Subjects.CHEMISTRY),
                    new Mark(9, Subjects.CHEMISTRY),
                    new Mark(5, Subjects.PHYSICS),
                    new Mark(5, Subjects.PHYSICS),
                    new Mark(7, Subjects.PHYSICS)

            ));
            Student student2 = new Student("Петров", Arrays.asList(
                    new Mark(10, Subjects.COMPUTER_SINCE),
                    new Mark(9, Subjects.COMPUTER_SINCE),
                    new Mark(6, Subjects.INFORMATION_SECURITY),
                    new Mark(7, Subjects.INFORMATION_SECURITY)
            ));
            Student student3 = new Student("Андреев", Arrays.asList(
                    new Mark(9, Subjects.ECONOMICS),
                    new Mark(9, Subjects.ECONOMICS),
                    new Mark(8, Subjects.MARKETING),
                    new Mark(8, Subjects.MARKETING)
            ));
            Student student4 = new Student("Сидоров", Arrays.asList(
                    new Mark(7, Subjects.ENGLISH),
                    new Mark(9, Subjects.ENGLISH),
                    new Mark(6, Subjects.PHILOSOPHY),
                    new Mark(5, Subjects.PHILOSOPHY),
                    new Mark(7, Subjects.ECONOMICS),
                    new Mark(8, Subjects.ECONOMICS)
            ));

            Group group1 = new Group(11, Arrays.asList(student1));
            Group group2 = new Group(11, Arrays.asList(student2));
            Group group3 = new Group(21, Arrays.asList(student3, student4));

            Faculty faculty1 = new Faculty("Faculty of Computer Systems",
                    Arrays.asList(group1, group2));
            Faculty faculty2 = new Faculty("Faculty of economics and engineering",
                    Arrays.asList(group3));

            University university = new University("BSUIR", Arrays.asList(faculty1, faculty2));

            System.out.println(university);
            System.out.println("\nAverage mark of the student Ivanov: "
                    + student1.getAverageMark());
            System.out.println("Average grade in Economics in the group 21 at the Faculty of economics and engineering: "
                    + university.getFacultyByName("Faculty of economics and engineering")
                    .getGroupByNumber(21)
                    .getAverageSubjectMark(Subjects.ECONOMICS));
            System.out.println("Average grade in chemistry at the university: "
                    + university.getAverageSubjectMarkForTheUniversity(Subjects.CHEMISTRY));
        } catch (EmptySubjectsListException | IllegalMarkException
                | EmptyGroupListException | EmptyFacultiesListException
                | EmptyStudentsListException | ObjectWasNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
