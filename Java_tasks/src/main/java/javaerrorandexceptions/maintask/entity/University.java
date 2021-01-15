package javaerrorandexceptions.maintask.entity;

import java.util.List;
import java.util.Objects;

public class University {
    List<Faculty> faculties;
    private String name;

    public University(String name, List<Faculty> faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(faculties, that.faculties) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculties, name);
    }
}
