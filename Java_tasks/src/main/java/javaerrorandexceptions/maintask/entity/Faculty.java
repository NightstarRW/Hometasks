package javaerrorandexceptions.maintask.entity;

import java.util.List;
import java.util.Objects;

public class Faculty {
    private FacultyNames name;
    private List<Group> groups;

    public Faculty(FacultyNames name, List<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public FacultyNames getName() {
        return name;
    }

    public void setName(FacultyNames name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return name == faculty.name && Objects.equals(groups, faculty.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, groups);
    }
}
