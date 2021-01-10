package university;

import exceptions.EmptyGroupList;

import java.util.List;

public class Faculty {
    private String name;
    private List<Group> groupsInTheFaculty;

    public Faculty(String name, List<Group> groupsInTheFaculty)
            throws EmptyGroupList {
        if (groupsInTheFaculty.isEmpty()) {
            throw new EmptyGroupList("На факультете нет ни одной группы");
        }
        this.name = name;
        this.groupsInTheFaculty = groupsInTheFaculty;
    }

    public String getName() {
        return name;
    }

    public List<Group> getGroupsInTheFaculty() {
        return groupsInTheFaculty;
    }

    @Override
    public String toString() {
        return "\n\nФакультет: " + name
                + "\nГруппы на факультете: " + groupsInTheFaculty;
    }
}
