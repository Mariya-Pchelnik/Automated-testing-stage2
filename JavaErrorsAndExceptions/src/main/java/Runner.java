import exceptions.*;
import university.ActionsWithUniversity;
import university.Subjects;

public class Runner {
    public static void main(String[] args) {
        try {
            ActionsWithUniversity actions = new ActionsWithUniversity();

            System.out.println("\nСредняя оценка студента Петрова: "
                    + actions.getAverageStudentMark("Петров"));

            System.out.println("Средняя оценка по предмету Экономика в группе 21 на ИЭФ: "
                    + actions.getAverageSubjectMarkInGroup("Faculty of economics and engineering",
                    21, Subjects.ECONOMICS));
            System.out.println("Средняя оценка по химии в университете: "
                    + actions.getAverageSubjectMarkInUniversity(Subjects.CHEMISTRY));


        } catch (EmptySubjectsList | IllegalMarkException | EmptyGroupList
                | EmptyFacultiesList | EmptyStudentsList exception) {
            System.out.println(exception.getMessage());
        }
    }

}
