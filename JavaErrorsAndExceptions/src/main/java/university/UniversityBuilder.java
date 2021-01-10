package university;

import exceptions.EmptyGroupList;
import exceptions.EmptyStudentsList;
import exceptions.EmptySubjectsList;
import exceptions.IllegalMarkException;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class UniversityBuilder {
    private List<Student> students;
    private List<Group> groups;
    private List<Faculty> faculties;

    public UniversityBuilder() throws EmptySubjectsList,
            EmptyStudentsList, EmptyGroupList, IllegalMarkException {
        Student student1 = new Student("Иванов",
                new EnumMap<Subjects, List<Integer>>(Subjects.class) {
                    {
                        put(Subjects.CHEMISTRY, Arrays.asList(10, 9));
                        put(Subjects.PHYSICS, Arrays.asList(5, 7));
                    }
                });
        Student student2 = new Student("Петров",
                new EnumMap<Subjects, List<Integer>>(Subjects.class) {
                    {
                        put(Subjects.COMPUTER_SINCE, Arrays.asList(10, 9));
                        put(Subjects.INFORMATION_SECURITY, Arrays.asList(6, 7));
                    }
                });
        Student student3 = new Student("Андреев",
                new EnumMap<Subjects, List<Integer>>(Subjects.class) {
                    {
                        put(Subjects.ECONOMICS, Arrays.asList(9, 9));
                        put(Subjects.MARKETING, Arrays.asList(8, 8));

                    }
                });
        Student student4 = new Student("Сидоров",
                new EnumMap<Subjects, List<Integer>>(Subjects.class) {
                    {
                        put(Subjects.ENGLISH, Arrays.asList(7, 9));
                        put(Subjects.PHILOSOPHY, Arrays.asList(6, 5));
                        put(Subjects.ECONOMICS, Arrays.asList(7, 8));

                    }
                });

        Group group1 = new Group(11, Arrays.asList(student1));
        Group group2 = new Group(12, Arrays.asList(student2));
        Group group3 = new Group(21, Arrays.asList(student3, student4));

        Faculty faculty1 = new Faculty("Faculty of Computer Systems",
                Arrays.asList(group1, group2));
        Faculty faculty2 = new Faculty("Faculty of economics and engineering",
                Arrays.asList(group3));

        this.faculties = Arrays.asList(faculty1, faculty2);
        this.groups = Arrays.asList(group1, group2, group3);
        this.students = Arrays.asList(student1, student2, student3);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    @Override
    public String toString() {
        return "Университет БГУИР\n" +
                "Факультеты: " + faculties;
    }
}
