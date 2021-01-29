package university;

import exceptions.EmptyGroupListException;

import java.util.List;

public class Faculty {
    private String name;
    private List<Group> groups;

    public Faculty(String name, List<Group> groups)
            throws EmptyGroupListException {
        this.name = name;
        if (groups.isEmpty()) {
            throw new EmptyGroupListException("There are no groups at the faculty"
                    + name);
        } else {
            this.groups = groups;
        }
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
