package university;

import exceptions.EmptyGroupListException;
import exceptions.ObjectWasNotFoundException;

import java.util.List;

public class Faculty {
    private String name;
    private List<Group> groups;

    public Faculty(String name, List<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public Group getGroupByNumber(int number)
            throws EmptyGroupListException, ObjectWasNotFoundException {
        Group group = null;

        if (groups.isEmpty()) {
            throw new EmptyGroupListException("There are no groups at the faculty"
                    + name);
        }
        for (Group currentGroup : groups) {
            if (currentGroup.getNumber() == number) {
                group = currentGroup;
                break;
            }
        }
        if (group == null) {
            throw new ObjectWasNotFoundException("Group № " + number
                    + "wasn't found" + "at the faculty " + name);
        }
        return group;
    }

    public String getName() {
        return name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return "\n\nFaculty: " + name
                + "\nGroups at the Faculty: " + groups;
    }
}
