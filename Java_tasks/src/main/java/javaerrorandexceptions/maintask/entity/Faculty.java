package javaerrorandexceptions.maintask.entity;

import java.util.List;
import java.util.Objects;

public class Faculty {
    private FacultyNames facultyName;
    private List<Group> groups;

    public Faculty(FacultyNames facultyName, List<Group> groups) {
        this.facultyName = facultyName;
        this.groups = groups;
    }

    public FacultyNames getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(FacultyNames facultyName) {
        this.facultyName = facultyName;
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
        return facultyName == faculty.facultyName && Objects.equals(groups, faculty.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyName, groups);
    }
}
